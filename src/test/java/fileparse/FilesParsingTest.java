package fileparse;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class FilesParsingTest {

    ClassLoader cl = FilesParsingTest.class.getClassLoader();

    @Test
    void zipParseTest() throws Exception {
        try (
                InputStream resource = cl.getResourceAsStream("archive.zip");
                ZipInputStream zis = new ZipInputStream(resource);
        ) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null){
                assertThat(entry.getName()).isIn("file.csv", "example.pdf", "table.xlsx");
            }
        }
    }

    @Test
    void unzipParseTest() throws Exception {
        try (
                InputStream resource = cl.getResourceAsStream("archive.zip");
                ZipInputStream zis = new ZipInputStream(resource);
        ) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null){
               if(entry.getName().contains(".csv")){
                   CSVReader reader = new CSVReader(new InputStreamReader(zis));
                   List<String[]> content = reader.readAll();
                   assertThat(content.get(0)[1]).contains("name");
                   assertThat(content.get(1)[2]).contains("100");
                   assertThat(content.get(2)[1]).contains("Phil");
               } else if (entry.getName().contains(".pdf")) {
                   PDF content = new PDF(zis);
                   assertThat(content.text).contains("ГОСТ 12.2.063-81");
               } else if (entry.getName().contains(".xlsx")){
                   XLS content = new XLS(zis);
                    assertThat(content.excel.getSheetAt(0)
                            .getRow(2)
                            .getCell(2)
                            .getStringCellValue())
                            .contains("заместитель директора");
               }
            }
        }
    }
}

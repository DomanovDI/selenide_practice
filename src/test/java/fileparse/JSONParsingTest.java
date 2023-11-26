package fileparse;

import com.fasterxml.jackson.databind.ObjectMapper;
import fileparse.model.Sample;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;

public class JSONParsingTest {
    ClassLoader cl = JSONParsingTest.class.getClassLoader();
    ObjectMapper mapper = new ObjectMapper();

    @Test
    @DisplayName("Парсинг json файла с помощью Jackson")
    void jsonParseTest() throws Exception {
        try (InputStream resource = cl.getResourceAsStream("sample.json");
             InputStreamReader reader = new InputStreamReader(resource)
        ){
            Sample sample = mapper.readValue(reader, Sample.class);
            assertThat(sample.firstName).isEqualTo("Joe");
            assertThat(sample.age).isEqualTo(28);
            assertThat(sample.address.city).contains("Diego");
            assertThat(sample.phoneNumbers).contains("8888888888","777777777");
        }
    }
}

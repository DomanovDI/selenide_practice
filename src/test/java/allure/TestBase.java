package allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.$;

public class TestBase {

    String url = "https://github.com/",
            repo = "selenide/selenide",
            name = "selenide",
            issue = "#2550";
    SelenideElement searchInput = $(".search-input-container"),
            query = $("#query-builder-test"),
            issueTab = $("#issues-tab");


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
    }

}

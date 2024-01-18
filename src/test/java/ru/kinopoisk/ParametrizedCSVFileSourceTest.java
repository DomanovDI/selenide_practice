package ru.kinopoisk;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.kinopoisk.config.WebDriverProvider;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParametrizedCSVFileSourceTest {

    @BeforeAll
    static void beforeAll() {
        WebDriverProvider webDriverProvider = new WebDriverProvider();
        Configuration.browserSize = "1920x1080";
    }

    @CsvFileSource (resources = "/testData.csv")
    @ParameterizedTest(name = "Сериал {1} должен появиться в результате поиска по запросу {0}")
    @Tags({@Tag("BLOCKER"), @Tag("UI_TEST")})
    void subjectsNameShouldBePresentInResultsByLettersQuery(String query, String result){
        open("/");
        $(".kinopoisk-header-search-form-input__input").setValue(query).pressEnter();
        $(".block_left_pad").shouldHave(text(result));
    }
}

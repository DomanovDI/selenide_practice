package ru.kinopoisk;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParametrizedValueSourceTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.kinopoisk.ru/";
        Configuration.browserSize = "1920x1080";
    }

    @ValueSource(
            strings = {"Рик", "Морт"}
    )
    @ParameterizedTest(name = "Сериал 'Рик и морти' должен появиться в результате поиска по запросу {0}")
    @Tags({@Tag("BLOCKER"), @Tag("UI_TEST")})
    void subjectsNameShouldBePresentInResultsByLettersQuery(String query){
        open("/");
        $(".kinopoisk-header-search-form-input__input").setValue(query).pressEnter();
        $(".block_left_pad").shouldHave(text("Рик и Морти"));
    }
}

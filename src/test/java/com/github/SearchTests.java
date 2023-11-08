package com.github;

import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class SearchTests {

    @Test
    void successfulLoginTest() {
        open("https://github.com/");
        $("[data-target=\"qbsearch-input.inputButton\"]").click();
        $("[id=query-builder-test]").setValue("selenide").pressEnter();
        $$("[data-testid=\"results-list\"]").first().$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }

    @Test
    void bestContributorTest() {
        open("https://github.com/selenide/selenide");
        $(".BorderGrid").$(Selectors.byText("Contributors"))
                .ancestor(".BorderGrid-row").$$("ul li").first().hover();
        $(".Popover").shouldHave(text("Andrei Solntsev"));
    }

    @Test
    void exampleCodeForJUnit5() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-body").$(Selectors.byText("Soft assertions")).click();
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}

package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import com.demoqa.pages.AutomationPracticeFormPage;

public class TestBase {
    AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
}

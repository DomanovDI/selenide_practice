package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormPage {
    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String HEADER_TEXT = "Practice Form";
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            phoneNumberInput = $("#userNumber"),
            genderInput = $("#genterWrapper"),
            subjectInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            fileNameLocator = $("#uploadPicture"),
            addressLocator = $("#currentAddress"),
            stateLocator = $("#state"),
            cityLocator = $("#city"),
            submitLocator = $("#submit");

    public AutomationPracticeFormPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".main-header").shouldHave(text(HEADER_TEXT));
        return this;
    }

    public AutomationPracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day,month,year);
        return this;
    }

    public AutomationPracticeFormPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public AutomationPracticeFormPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }

    public AutomationPracticeFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setPhoneNumber(String value) {
        phoneNumberInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public AutomationPracticeFormPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public AutomationPracticeFormPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public AutomationPracticeFormPage setFile(String value) {
        fileNameLocator.uploadFile(new File("src/test/resources/" + value));
        return this;
    }

    public AutomationPracticeFormPage setAddress(String value) {
        addressLocator.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setState(String value) {
        stateLocator.click();
        $(byText(value)).click();
        return this;
    }

    public AutomationPracticeFormPage setCity(String value) {
        cityLocator.click();
        $(byText(value)).click();
        return this;
    }

    public AutomationPracticeFormPage submit() {
        submitLocator.click();
        return this;
    }
}

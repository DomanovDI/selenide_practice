package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920*1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void automationPracticeFillFormTest() {
        String firstName = "Dmitriy";
        String lastName = "Dimqooo";
        String email = "dimqoooo@gmail.com";
        String phoneNumber = "1234567890";
        String sex = "Male";
        String year = "1990";
        String month = "March";
        String day = "31";
        String subject1 = "Computer Science";
        String subject2 = "Maths";
        String hobbies = "Music";
        String fileName = "Untitled.jpg";
        String address = "Russia";
        String state = "NCR";
        String city = "Gurgaon";

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(sex)).click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionContainingText(year);
        $(".react-datepicker__month-select").selectOptionContainingText(month);
        $(".react-datepicker__day--031").click();
        $("#subjectsInput").setValue(subject1).pressEnter();
        $("#subjectsInput").setValue(subject2).pressEnter();
        $("[for=hobbies-checkbox-3]").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/" + fileName));
        $("#currentAddress").setValue(address);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();
        //проверки
        $(".table-responsive").$(byText("Student Name")).sibling(0).shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Student Email")).sibling(0).shouldHave(text(email));
        $(".table-responsive").$(byText("Gender")).sibling(0).shouldHave(text(sex));
        $(".table-responsive").$(byText("Mobile")).sibling(0).shouldHave(text(phoneNumber));
        $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldHave(text(day + " " + month + "," + year));
        $(".table-responsive").$(byText("Subjects")).sibling(0).shouldHave(text(subject1 + ", " + subject2));
        $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldHave(text(hobbies));
        $(".table-responsive").$(byText("Picture")).sibling(0).shouldHave(text(fileName));
        $(".table-responsive").$(byText("Address")).sibling(0).shouldHave(text(address));
        $(".table-responsive").$(byText("State and City")).sibling(0).shouldHave(text(state + " " + city));
    }
}

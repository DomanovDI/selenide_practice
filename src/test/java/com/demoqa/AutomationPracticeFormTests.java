package com.demoqa;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AutomationPracticeFormTests extends TestBase {


    @Test
    void automationPracticeFormTest() {
        String firstName = "Dmitriy";
        String lastName = "Dimqooo";
        String email = "dimqoooo@gmail.com";
        String phoneNumber = "1234567890";
        String sex = "Male";
        String year = "1990";
        String month = "March";
        String day = "31";
        String subject = "Computer Science";
        String hobbies = "Music";
        String fileName = "Untitled.jpg";
        String address = "Russia";
        String state = "NCR";
        String city = "Gurgaon";

        automationPracticeFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .setGender(sex)
                .setBirthDate(day,month,year)
                .setSubject(subject)
                .setHobbies(hobbies)
                .setFile(fileName)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit();

        automationPracticeFormPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", sex)
                .verifyResult("Mobile", phoneNumber)
                .verifyResult("Date of Birth", day + " " + month + "," + year)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", fileName)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);

//        $(".table-responsive").$(byText("Student Name")).sibling(0).shouldHave(text(firstName + " " + lastName));
//        $(".table-responsive").$(byText("Student Email")).sibling(0).shouldHave(text(email));
//        $(".table-responsive").$(byText("Gender")).sibling(0).shouldHave(text(sex));
//        $(".table-responsive").$(byText("Mobile")).sibling(0).shouldHave(text(phoneNumber));
//        $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldHave(text(day + " " + month + "," + year));
//        $(".table-responsive").$(byText("Subjects")).sibling(0).shouldHave(text(subject1 + ", " + subject2));
//        $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldHave(text(hobbies));
//        $(".table-responsive").$(byText("Picture")).sibling(0).shouldHave(text(fileName));
//        $(".table-responsive").$(byText("Address")).sibling(0).shouldHave(text(address));
//        $(".table-responsive").$(byText("State and City")).sibling(0).shouldHave(text(state + " " + city));
    }
}

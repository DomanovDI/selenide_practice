package com.demoqa;

import org.junit.jupiter.api.Test;

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
    }
}

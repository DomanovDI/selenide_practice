package com.demoqa;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String phoneNumber = faker.number().digits(10);
    String sex = faker.options().option("Male", "Female", "Other");
    String year = String.valueOf(faker.number().numberBetween(1990,2023));
    String month = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    String day = String.valueOf(faker.number().numberBetween(1,28));
    String subject = faker.options().option("Computer Science", "Commerce", "Accounting",
                    "Economics", "Social Studies", "Civics", "English", "Arts", "History", "Maths");
    String hobbies = faker.options().option("Sports", "Reading", "Music");
    String fileName = "Untitled.jpg";
    String address = faker.address().fullAddress();
    String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    String city = getCity();

    private String getCity(){
        String cityItem = switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };

        return cityItem;
    }
}

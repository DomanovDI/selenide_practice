package fileparse.model;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Sample {
    public String firstName;
    @JsonSetter("last_Name")
    public String lastName;
    public String gender;
    public int age;
    public Address address;
    public String[] phoneNumbers;

    public static class Address {
        public String streetAddress;
        public String city;
        public String state;
    }
}

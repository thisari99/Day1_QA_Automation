package com.rootcodelabs.java.Day2.util;

import com.github.javafaker.Faker;

public class DataManager {

    public static String getFirstname() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName().replaceAll("' ", "").trim();
        return firstName;
    }

    public static String getLastname() {
        Faker faker = new Faker();
        String lastName = faker.name().firstName().replaceAll("' ", "").trim();
        return lastName;
    }

    public static String getMiddlename() {
        return getLastname();

    }

    public static EmployeeDetails getEmployeeDetails() {
        return new EmployeeDetails();
    }


}

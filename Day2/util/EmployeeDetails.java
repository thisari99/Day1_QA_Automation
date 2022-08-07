package com.rootcodelabs.java.Day2.util;

public class EmployeeDetails {

    private String firstName;
    private String lastName;
    private String middleName;
    private String username;


    public EmployeeDetails() {

        this.firstName = DataManager.getFirstname();
        this.lastName = DataManager.getLastname();
        this.middleName =DataManager.getMiddlename();
        this.username = String.format("%s.%s", firstName,lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getUsername() {
        return username;
    }



}

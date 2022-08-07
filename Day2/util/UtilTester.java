package com.rootcodelabs.java.Day2.util;


import com.github.javafaker.Faker;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.GregorianCalendar;
import java.util.concurrent.ThreadLocalRandom;

public class UtilTester {

    public static void main(String[] args) {
        Faker faker = new Faker();
        String firstname = DataManager.getFirstname();
        String lastname = DataManager.getLastname();
        String middlename = DataManager.getMiddlename();

        EmployeeDetails employeeDetails = DataManager.getEmployeeDetails();


        //For creating a new employee
//        System.out.println(firstname);
//        System.out.println(lastname);
//        System.out.println(middlename);


        //After creating a new employee
        EmployeeDetails firstEmployee = DataManager.getEmployeeDetails();
        System.out.println(firstEmployee.getFirstName());
        System.out.println(firstEmployee.getLastName());
        System.out.println(firstEmployee.getMiddleName());
        System.out.println(firstEmployee.getUsername());
    }
}

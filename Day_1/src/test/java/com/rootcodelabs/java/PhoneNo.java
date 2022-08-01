package com.rootcodelabs.java;

import com.github.javafaker.Faker;

public class PhoneNo {
    public static void main(String[] args) {
        System.out.println("Auto generated phone number is below ");

        Faker faker = new Faker();
        String phoneNo= faker.phoneNumber().phoneNumber();
        System.out.println(String.format("Phone Number is %s", phoneNo));

        System.out.println("Auto generated address is below ");

        Faker faker1 = new Faker();
        String address= faker.address().fullAddress();
        System.out.println(String.format("Address is  %s", address));


    }

}

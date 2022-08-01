package com.rootcodelabs.java;

public class Address {

    public static void main(String[] args) {

        String houseNo    = "80/8,";
        String streetName = "Balika Vidyala Road,";
        String city       = "Kosgama";

        String addressName = getAddressName(houseNo,streetName,city);

        System.out.println("Address = " + addressName);

    }

    private static String getAddressName(String houseNo, String streetName, String city) {
        String addressName = String.format("%s %s %s", houseNo, streetName, city);
        return addressName;
    }
    }


package com.rootcodelabs.java;

import java.sql.SQLOutput;

public class DisplayTotal {

    public static void main(String[] args) {

        String price1 ="10.5";
        String price2 ="12.5";


        String total = price1 + price2;

        double totalPrice= Double.parseDouble(price1) + Double.parseDouble(price2);

        System.out.println("Total Price is USD " + total);

    }

}

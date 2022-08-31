package com.rootcodelabs.java.day8_9.sauce;

import org.testng.annotations.DataProvider;

public class SauceDataProvider {

    @DataProvider(name = "invalid-login-inputs")
    public static Object[][] invalidLoginInputs(){
        return new Object[][]{
            {"","","Username is required"},
            {"standard_user","","Password is required"},
            {"standard_user","asssee","Password is required"},
        };
    }

    @DataProvider(name = "product-names")
    public static Object [][] productNames() {
        return new Object[][]{
                {"Sauce Labs Backpack"},
                {"Sauce Labs Bike Light"},
                {"Sauce Labs Bolt T-Shirt"},
                {"Sauce Labs Fleece Jacket"},
                {"Sauce Labs Onesie"},
                {"Test.allTheThings() T-Shirt (Red)"},

        };
    }



}

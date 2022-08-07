package com.rootcodelabs.java.Day2.Loginpage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {

    public static void main(String[] args) {
        //Setup a browser driver
        WebDriverManager.chromedriver().setup();

        //Create an instance of browser and assign to WebDriver
        WebDriver driver = new ChromeDriver();

        //Navigate to URL
        driver.get("https://www.saucedemo.com/");

        //Actions
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


        //Assertions
        //driver.quit();
    }
}
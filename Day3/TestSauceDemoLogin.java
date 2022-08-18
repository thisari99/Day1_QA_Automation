package com.rootcodelabs.java.Day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import static org.assertj.core.api.Assertions.*;

public class TestSauceDemoLogin {
    private WebDriver driver;

    // BC BM T1 AM BM T2 AM BM T3 AM BM T4 AM AC

    @BeforeClass
    public void beforeClass(){
        // WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

    }

    @BeforeMethod
    public void beforeMethod(){
        //driver = new ChromeDriver();
       driver = new FirefoxDriver();
       driver.get("https://www.saucedemo.com/");
       driver.manage().window().minimize();
    }

    @AfterClass
    public void afterClass(){
    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null){
            driver.close();
    }
    }


    @Test
    public void testLoginWithValidCredentials(){
        //User actions
        //Type username
        String username = "standard_user";
        String password = "secret_sauce";


        driver.findElement(By.id("user-name")).sendKeys("username");
        String attributeValue = driver.findElement(By.id("user-name")).getAttribute("value");
        assertThat(attributeValue).isEqualTo(username);

        //Type password
        driver.findElement(By.id("password")).sendKeys("password");

        //Click on login button
        driver.findElement(By.id("login-button")).click();

        String actualTitle = driver.findElement(By.className("title")).getText();
        //Verify the outcome against the expected
        assertThat(actualTitle.toLowerCase()).isEqualTo("products");

        //Close the browser
    }

    public void testLoginWithValidCredentialsWithPressEnterKey(){
        //User actions
        //Type username
        String username = "standard_user";
        String password = "secret_sauce";


        driver.findElement(By.id("user-name")).sendKeys(username);
        String attributeValue = driver.findElement(By.id("user-name")).getAttribute("value");
        assertThat(attributeValue).isEqualTo(username);

        //Type password
        driver.findElement(By.id("password")).sendKeys(password + Keys.ENTER);


        String actualTitle = driver.findElement(By.className("title")).getText();
        //Verify the outcome against the expected
        assertThat(actualTitle).isEqualTo("PRODUCTS");

        //Close the browser
    }

    @Test
    public void testLoginWithInvalidPassword(){

        String expectedError = "Epic sadface: Username and password do not match any user in this service";

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Type password
        driver.findElement(By.id("password")).sendKeys("invalid_sauce");

        //Click on login button
        driver.findElement(By.id("login-button")).click();

        String actualError = driver.findElement(By.tagName("h3")).getText();
        assertThat(actualError).containsIgnoringCase(expectedError);
    }

    @Test
    public void testLoginWithBlankPassword(){
        String expectedError = "Epic sadface: Password is required";

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Type password
        driver.findElement(By.id("password")).sendKeys("invalid_sauce");

        //Click on login button
        driver.findElement(By.id("login-button")).click();

        String actualError = driver.findElement(By.tagName("h3")).getText();
        assertThat(actualError).containsIgnoringCase(expectedError);
    }

    @Test
    public void testLoginWithInvalidUsername(){
        String expectedError = "Epic sadface: Username and password do not match any user in this service";

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Type password
        driver.findElement(By.id("password")).sendKeys("invalid_sauce");

        //Click on login button
        driver.findElement(By.id("login-button")).click();

        String actualError = driver.findElement(By.tagName("h3")).getText();
        assertThat(actualError).containsIgnoringCase(expectedError);
    }

    @Test
    public void testLoginWithBlankUsernameAndBlankPassword() {
        String expectedError = "Epic sadface: Username is required";

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Type password
        driver.findElement(By.id("password")).sendKeys("invalid_sauce");

        //Click on login button
        driver.findElement(By.id("login-button")).click();

        String actualError = driver.findElement(By.tagName("h3")).getText();
        assertThat(actualError).containsIgnoringCase(expectedError);
    }
}

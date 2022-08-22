package com.rootcodelabs.java.day7.test;

import com.rootcodelabs.java.day7.pages.LandingPage;
import com.rootcodelabs.java.day7.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com");
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void afterMethod(){
        if (driver != null){
            driver.quit();
        }
    }

    @Test
    public void testUserLoginWithValidCredentials(){
        loginPage.typeUsername("Admin").typePassword("Ptl@#321").clickLogin();
        LandingPage landingPage = new LandingPage(driver);
        //String welcomeMessage = landingPage.getWelcomeMessage();
        Assert.assertEquals(landingPage.getWelcomeMessage(),"Welcome Admin");

    }

    @Ignore
    @Test
    public void testUserLoginWithBlankUserNameAndPassword(){}

    @Test(enabled = false)
    public void testUserLoginWithInvalidPassword() {
    }

    @Test(enabled = false)
    public void testUserLoginWithBlankPassword() {
    }

    @Test(enabled = false)
    public void testUserLoginWithBlankUserName() {
    }



}

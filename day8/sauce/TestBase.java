package com.rootcodelabs.java.day8.sauce;


import com.rootcodelabs.java.day8.sauce.pages.LoginPage;
import com.rootcodelabs.java.day8.sauce.utils.PropertyManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.get(PropertyManager.getBaseURL());
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod(){
        if (driver!=null){
            driver.quit();
        }
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected void standardUserLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername("standard_user").typePassword("secret_sauce").clickLogin();
    }
}

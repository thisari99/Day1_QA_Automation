package com.rootcodelabs.java.day8_9.sauce;


import com.rootcodelabs.java.day8_9.sauce.pages.LoginPage;
import com.rootcodelabs.java.day8_9.sauce.utils.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        BrowserManager.setup();

    }

    @BeforeMethod
    public void beforeMethod(){
        driver = BrowserManager.launchBrowser();
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

    public void ClearAndType(WebElement element, String inputText) {
        element.clear();
        element.sendKeys(inputText);
    }
}

package com.rootcodelabs.java.day8_9.sauce.pages;

import com.rootcodelabs.java.day8_9.sauce.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    private final WebDriver driver;

    @FindBy(xpath ="//input[@id='user-name']")
    private WebElement txtUserName;

    @FindBy(xpath ="//input[@placeholder='Password']")
    private WebElement txtPassword;

    @FindBy(xpath ="//input[@value='Login']")
    private WebElement btnLogin;

    @FindBy(xpath ="//h3[@data-test='error']")
    private WebElement lblError;



    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage typeUsername(String username) {
        ClearAndType(txtUserName, username);
        //clearAndType (txtUserName,username);
        return this;
    }



    public LoginPage typePassword(String password){
        ClearAndType(txtPassword, password);
        return this;
    }

    public void clickLogin(){

        btnLogin.click();
    }

    public String getError() {

        return lblError.getText();
    }

}


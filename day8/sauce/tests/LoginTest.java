package com.rootcodelabs.java.day8.sauce.tests;

import com.rootcodelabs.java.day8.sauce.SauceDataProvider;
import com.rootcodelabs.java.day8.sauce.TestBase;
import com.rootcodelabs.java.day8.sauce.pages.InventoryPage;
import com.rootcodelabs.java.day8.sauce.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class LoginTest extends TestBase {

    @Test
    public void testUserLoginWithValidCredentials(){

        LoginPage loginPage = new LoginPage(super.getDriver());
        loginPage.typeUsername("standard_user").typePassword("secret_sauce").clickLogin();
        InventoryPage inventoryPage = new InventoryPage(super.getDriver());
        Assert.assertEquals(inventoryPage.getTitle(), "PRODUCTS");
    }


    @Test(dataProvider = "invalid-login-inputs")
    public void testUserLoginWithInvalidCredentials(String username, String password,String expectedError ) {

        LoginPage loginPage = new LoginPage(super.getDriver());
        loginPage.typeUsername(username).typePassword(password).clickLogin();
        InventoryPage inventoryPage = new InventoryPage(super.getDriver());
        assertThat(loginPage.getError()).containsPattern(expectedError);
    }




}

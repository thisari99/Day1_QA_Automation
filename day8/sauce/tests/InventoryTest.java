package com.rootcodelabs.java.day8.sauce.tests;

import com.rootcodelabs.java.day8.sauce.Item;
import com.rootcodelabs.java.day8.sauce.SauceDataProvider;
import com.rootcodelabs.java.day8.sauce.TestBase;
import com.rootcodelabs.java.day8.sauce.pages.InventoryPage;
import com.rootcodelabs.java.day8.sauce.pages.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.OptionalDouble;

public class InventoryTest extends TestBase {

    @Test
    public void testItemCount(){
        super.standardUserLogin();
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        Assert.assertEquals(inventoryPage.getProductCount(),6);
    }

    @Test
    public void testSearchProductName(){
        super.standardUserLogin();
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        Assert.assertTrue(inventoryPage.searchProduct("Sauce Labs Bike Light"));
    }

    @Test
    public void testSearchProductNameNotExists(){
        super.standardUserLogin();
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        Assert.assertFalse(inventoryPage.searchProduct("Sauce Labs Bike Light NEW"));
    }

    @Test(dataProvider = "product-names", dataProviderClass = SauceDataProvider.class)
    public void testSearchProductNameList(String productName){
        super.standardUserLogin();
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        Assert.assertTrue(inventoryPage.searchProduct(productName));
    }

    @Test
    public void testMaxItemPrice(){
        super.standardUserLogin();
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        List<Item> itemList = inventoryPage.getItemList();
        OptionalDouble maxPrice = itemList.stream().mapToDouble(Item::price).max();
        System.out.println(maxPrice);

    }


}

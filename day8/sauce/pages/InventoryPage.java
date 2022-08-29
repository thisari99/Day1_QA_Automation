package com.rootcodelabs.java.day8.sauce.pages;

import com.rootcodelabs.java.day8.sauce.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class InventoryPage {
    private final WebDriver driver;

    @FindBy(className = "title")
    private WebElement eleTitle;

    @FindBy(css = ".inventory_item")
    private List<WebElement> eleItems;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public String getTitle() {
        return eleTitle.getText().strip();
    }

    public int getProductCount() {
        return eleItems.size();

    }

    public boolean searchProduct(String productName) {
        for (WebElement eleItem: eleItems

        ) {
            String itemName = eleItem.findElement(By.cssSelector(".inventory_item_name")).getText().strip();
            if (itemName.equals(productName)){
                return true;
            }
        }
        return false;
    }

    public List<Item> getItemList() {
        List<Item> itemList = new ArrayList<>();

        for (WebElement eleItem :eleItems
             ) {

            String itemName = eleItem.findElement(By.className("inventory_item_name")).getText().strip();
            String itemDescription = eleItem.findElement(By.className("inventory_item_desc")).getText().strip();
            double itemPrice = Double.parseDouble(eleItem.findElement(By.className("inventory_item_desc")).getText().replace("$","").strip());
            Item item = new Item(itemName,itemDescription,itemPrice);
            itemList.add(item);
        }
        return itemList;
    }
}

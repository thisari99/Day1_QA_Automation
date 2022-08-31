package com.rootcodelabs.java.day8_9.sauce;

import com.rootcodelabs.java.day8_9.sauce.utils.PropertyManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserManager {
    public static void setup() {
        String browserType = PropertyManager.getBrowserType();

        switch (browserType.toLowerCase().strip()){
            case "chrome", "chrome-headless" -> WebDriverManager.chromedriver().setup();
            case "firefox", "firefox-headless" -> WebDriverManager.firefoxdriver().setup();
            case "safari"-> WebDriverManager.safaridriver().setup();
            default -> throw new IllegalArgumentException(String.format("Browser type is not supported %s", browserType));
        }

    }

    public static WebDriver launchBrowser() {
        WebDriver driver;

        String browseType = PropertyManager.getBrowserType();

        switch (browseType.toLowerCase().strip()) {
            case "chrome" -> driver = new ChromeDriver();
            case "chrome-headless" -> {
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(true);
                driver = new ChromeDriver(options);
            }

            case "firefox" -> driver = new FirefoxDriver();
            case "firefox-headless" -> {
                FirefoxOptions options = new FirefoxOptions();
                options.setHeadless(true);
                driver = new FirefoxDriver(options);
            }

            default -> throw new IllegalArgumentException (String.format ("Browser Type is not supported %s",browseType));
        }

        return driver;
    }
}

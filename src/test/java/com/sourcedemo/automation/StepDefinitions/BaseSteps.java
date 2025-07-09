package com.sourcedemo.automation.StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseSteps {

    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    public static Actions actions;
    public WebDriverWait wait;
    public WebDriver driver;

    public BaseSteps() {
        if (threadLocalDriver.get() == null) {
            driver = new ChromeDriver();
            // Initialize WebDriver here, e.g., with a DriverFactory
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
             threadLocalDriver.set(driver);
//            throw new IllegalStateException("WebDriver not initialized. Set it before using BaseSteps.");
        }
        actions = new Actions(threadLocalDriver.get());
        wait = new WebDriverWait(threadLocalDriver.get(), Duration.ofSeconds(10));
    }

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    public static void setDriver(WebDriver driver) {
        threadLocalDriver.set(driver);
    }

}

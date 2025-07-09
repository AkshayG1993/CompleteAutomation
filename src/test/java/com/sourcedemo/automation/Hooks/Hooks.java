package com.sourcedemo.automation.Hooks;

import com.sourcedemo.automation.StepDefinitions.BaseSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    @Before
    public void setUp() {
        if (BaseSteps.getDriver() == null) {
            WebDriver driver = new ChromeDriver();
            BaseSteps.setDriver(driver);
        }
    }

    @After
    public void tearDown() {
        if (BaseSteps.getDriver() != null) {
            BaseSteps.getDriver().quit();
            BaseSteps.setDriver(null);
        }
    }
}

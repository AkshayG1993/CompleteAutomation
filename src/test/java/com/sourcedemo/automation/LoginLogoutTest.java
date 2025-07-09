package com.sourcedemo.automation;

import com.saucedemo.POJOS.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginLogoutTest extends BaseTest {
    private LoginPage loginPage;

    @Test
    public void testLoginAndLogout() {
        WebDriver driver = getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = PageFactory.initElements(driver, LoginPage.class);

        // Login
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(driver.getCurrentUrl().contains("inventory"));
        actions.sendKeys(Keys.ESCAPE).build().perform();

        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();
        assertTrue(driver.getCurrentUrl().contains("saucedemo.com"));
    }
}
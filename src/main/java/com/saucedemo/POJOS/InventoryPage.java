package com.saucedemo.POJOS;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.PageFactory.initElements;

@Log4j2
@Data
public class InventoryPage {
    WebDriverWait wait;
    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, ofSeconds(10));
        initElements(this.driver, this);
    }

    @FindBy(css = ".inventory_list")
    private WebElement inventoryList;

    @FindBy(css = "div.app_logo")
    private WebElement appLogo;

    @FindBy(css = ".inventory_item")
    private List<WebElement> inventoryItems;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartButton;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_linkn")
    private WebElement logoutLink;

    @FindBy(css = ".product_sort_container")
    private WebElement sortDropdown;

    public boolean isAppLogoDisplayed() {
        log.info("Checking if app logo is displayed");
        try {
            wait.until(ExpectedConditions.visibilityOf(appLogo));
            return true;
        } catch (Exception e) {
            log.error("App logo is not displayed: {}" + e.getMessage());
            return false;
        }
    }

    public boolean isProductListDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(inventoryList));
            return inventoryList.isDisplayed();
        } catch (Exception e) {
            log.error("Product list is not displayed: {}", e.getMessage());
            return false;
        }
    }

    public boolean isCartIconDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(cartButton));
            return cartButton.isDisplayed();
        } catch (Exception e) {
            log.error("Cart icon is not displayed: {}", e.getMessage());
            return false;
        }
    }

    public boolean isMenuButtonDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(menuButton));
            return menuButton.isDisplayed();
        } catch (Exception e) {
            log.error("Menu button is not displayed: {}", e.getMessage());
            return false;
        }
    }
}
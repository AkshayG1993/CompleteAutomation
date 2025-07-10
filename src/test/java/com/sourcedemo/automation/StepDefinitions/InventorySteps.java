package com.sourcedemo.automation.StepDefinitions;

import com.saucedemo.POJOS.InventoryPage;
import io.cucumber.java.en.And;

import static com.sourcedemo.automation.StepDefinitions.BaseSteps.getDriver;
import static org.testng.Assert.assertTrue;

public class InventorySteps {
    private InventoryPage inventoryPage;

    @And("the inventory page components should be loaded")
    public void theInventoryPageComponentShouldBeLoaded() {
        inventoryPage = new InventoryPage(getDriver());
        assertTrue(inventoryPage.isAppLogoDisplayed(), "App logo is not displayed");
        assertTrue(inventoryPage.isProductListDisplayed(), "Product list is not displayed");
        assertTrue(inventoryPage.isCartIconDisplayed(), "Cart icon is not displayed");
        assertTrue(inventoryPage.isMenuButtonDisplayed(), "Menu button is not displayed");
    }

}

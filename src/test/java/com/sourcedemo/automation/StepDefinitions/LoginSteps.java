package com.sourcedemo.automation.StepDefinitions;

import com.saucedemo.POJOS.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;

public class LoginSteps extends BaseSteps {
    private LoginPage loginPage;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        getDriver().get("https://www.saucedemo.com/");
        loginPage = PageFactory.initElements(getDriver(), LoginPage.class);
    }

    @When("the user logs in with username {string} and password {string}")
    public void the_user_logs_in_with_username_and_password(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("the user should be redirected to the inventory page")
    public void the_user_should_be_redirected_to_the_inventory_page() {
    // Verify that the user is redirected to the inventory page
        assertTrue(getDriver().getCurrentUrl().contains("inventory"));
    }

    @And("the user closes the browser")
    public void the_user_closes_the_browser() {
        getDriver().quit();
    }
}

package com.sourcedemo.automation;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
    features = "src/test/resources/features/login.feature",
    glue = {"com.sourcedemo.automation.StepDefinitions", "Hooks"},
    plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class LoginFeatureTest extends AbstractTestNGCucumberTests {
    // This class runs the Cucumber tests for the login feature
}
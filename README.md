# CompleteAutomation
This Project is been created to demonstrate the entire automation capability both on frontend and backend
Here is a complete `README.md` for this project

```
# ReqRes Automation Project

## Overview

This project automates both frontend (UI) and backend (API) testing for the ReqRes and saucedemo application using Java, Maven, Selenium, Cucumber, TestNG, and RestAssured. It provides robust validation of user flows and API endpoints, with integrated reporting.

---

## Table of Contents

- [Project Structure](#project-structure)
- [Tech Stack](#tech-stack)
- [Setup Instructions](#setup-instructions)
- [Test Organization](#test-organization)
- [How to Run Tests](#how-to-run-tests)
- [Best Practices](#best-practices)
- [Contributing](#contributing)

---

## Project Structure

```
src/
  main/
    java/
  test/
    java/
      com/
        sourcedemo/
          automation/
            LoginFeatureTest.java
            StepDefinitions/
            Hooks/
        reqres/
          automation/
            api/
    resources/
      features/
        login.feature
testng.xml
pom.xml
```

---

## Tech Stack

- Java 17+
- Maven
- Selenium WebDriver
- Cucumber (BDD)
- TestNG
- RestAssured

---

## Setup Instructions

1. **Clone the repository:**
   ```
   git clone <your-repo-url>
   cd <project-directory>
   ```

2. **Install dependencies:**
   ```
   mvn clean install
   ```

3. **Configure environment:**
   - Update `config.properties` for environment-specific values (URLs, credentials, etc.).
   - Ensure ChromeDriver/GeckoDriver is available in your system PATH.

---

## Test Organization

- **Frontend (UI) Automation:**  
  - Entry point: `LoginFeatureTest.java`  
  - Feature files: `src/test/resources/features/login.feature`  
  - Step definitions: `com.sourcedemo.automation.StepDefinitions`

- **Backend (API) Automation:**  
  - Entry point: `testng.xml`  
  - Test classes: `com.reqres.automation.api.*`

---

## How to Run Tests

### Frontend (UI) Tests

Run all Cucumber UI scenarios:
```
mvn test -Dcucumber.options="--tags @Login"
```

### Backend (API) Tests

Run all API tests via TestNG suite:
```
mvn test -DsuiteXmlFile=testng.xml
```

---


## Best Practices

- Use clear package structure for UI and API tests.
- Parameterize tests using TestNG `@DataProvider`.
- Store static test data in `src/test/resources`.
- Use configuration files for environment variables.
- Keep tests independent and maintainable.
- Use base classes for common setup/teardown logic.

---

## Contributing

1. Fork the repository.
2. Create a feature branch.
3. Commit your changes.
4. Open a pull request.

---

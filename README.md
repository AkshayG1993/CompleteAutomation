
# CompleteAutomation Project

## Overview
Automated testing project for the SourceDemo web application (frontend) and Reqres.in public APIs (backend) using Java, Maven, Selenium, Cucumber, and Extent Reports.

---

## Table of Contents
- \[Tech Stack\]
- \[Project Structure\]
- \[Setup Instructions\]
- \[Running Tests\]
- \[Reporting\]
- \[Frontend Automation\]
- \[Backend API Testing\]
- \[Contributing\]
- \[License\]

---

## Tech Stack

**Frontend:**
- Java
- Selenium WebDriver
- Cucumber (BDD)
- Page Object Model (POM)
- SourceDemo website (UI under test)

**Backend:**
- Java
- RestAssured
- Cucumber (BDD)
- Reqres.in APIs

**Common:**
- Maven
- Extent Reports

---

## Project Structure

```
src/
  test/
    java/
      com.sourcedemo.automation/
        StepDefinitions/      # Step definitions for UI and API
        Hooks/                # Test hooks, reporting, plugins
        Runner/               # Cucumber test runners
        Utils/                # Utilities (ExtentManager, etc.)
    resources/
      features/               # Cucumber feature files (UI & API)
pom.xml                       # Maven build file
README.md                     # Project documentation
```

---

## Setup Instructions

1. **Clone the repository:**
   ```
   git clone <your-repo-url>
   cd sourcedemo-automation
   ```

2. **Install dependencies:**
   ```
   mvn clean install
   ```

3. **WebDriver setup:**
   - Update driver configuration in `BaseSteps.java` or use WebDriverManager.

4. **API setup:**
   - No authentication required for Reqres.in; endpoints are public.

---

## Running Tests

- **Run all tests:**
  ```
  mvn test
  ```

- **Run specific feature:**
  ```
  mvn test -Dcucumber.options="src/test/resources/features/login.feature"
  ```

---

## Reporting

- **Extent Reports** are generated after test execution.
- Default location: `test-output/ExtentReport.html` (configurable in `ExtentManager.java`).

---

## Frontend Automation

- **Target:** SourceDemo website.
- **Tools:** Selenium WebDriver, Cucumber, POM.
- **Features:** UI scenarios written in Gherkin.
- **Step Definitions:** Located in `StepDefinitions/`.
- **Hooks:** Reporting and screenshot capture in `Hooks/ExtentHooks.java`.

---

## Backend API Testing

- **Target:** Reqres.in public REST APIs.
- **Tools:** RestAssured, Cucumber.
- **Features:** API scenarios in Gherkin.
- **Step Definitions:** Located in `StepDefinitions/`.
- **No authentication required.**

---

## Contributing

1. Fork the repository.
2. Create a feature branch.
3. Commit your changes.
4. Submit a pull request.

---

## License

MIT License.

---

**Contact:**  
Open an issue for support or questions.

---

Replace `<your-repo-url>` with your actual repository URL. Update sections as needed for your project specifics.

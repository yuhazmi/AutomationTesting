Feature: Log in to the application
  Scenario: Login to application as valid user
    Given Login page
    When user enter valid credentials
    And click on login
    Then Home page should be displayed

  Scenario: Login to application as invalid user
    Given Login page
    When user enter invalid credentials
    And click on login
    Then error message should be displayed
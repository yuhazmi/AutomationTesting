Feature: About Menu
  Scenario: About Menu displaying incorrect about page
    Given User loged in
    When User click about menu
    Then Incorrect about page displayed
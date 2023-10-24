Feature: Logout
  Scenario: User can logout from home page
    Given User already loged in
    When User click home menu
    And Click on logout menu
    Then User logged out and login page displayed
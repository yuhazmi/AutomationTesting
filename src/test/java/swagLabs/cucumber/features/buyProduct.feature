Feature: Product Menu
  Scenario: User is able to buy products
    Given User already login
    When User click add to cart button
    And User click cart icon
    And User check the shopping list and click Checkout button
    And User fill the biodata and click Continue button
    And User click the Finish button
    Then User directed to Checkout complete page

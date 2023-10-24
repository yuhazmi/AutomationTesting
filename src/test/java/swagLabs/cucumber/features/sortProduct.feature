Feature: Sort Product
  Scenario: User is able to sort products
    Given User already loginn
    When User sort product by name z to a
    Then product sorted from z to a
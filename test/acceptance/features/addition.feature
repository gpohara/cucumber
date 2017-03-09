Feature: Addition
  In order to avoid silly mistakes
  As a math idiot
  I want to be told the sum of two numbers

  Scenario: Subtract two numbers
    Given I have a new calculator
    And I have entered 500 into the calculator
    And I have entered 100 into the calculator
    When I press sub
    Then the result should be 400 on the screen

  Scenario: Add two numbers
    Given I have a new calculator
    And I have entered 50 into the calculator
    And I have entered 100 into the calculator
    When I press add
    Then the result should be 150 on the screen


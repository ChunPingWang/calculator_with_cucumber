Feature: Calculator

Scenario Outline: Add two numbers
    Given the first number is <firstNumber>
    And the second number is <secondNumber>
    When the two numbers are added
    Then the result should be <result>

    Examples:
      | firstNumber | secondNumber | result |
      | 50          | 70           | 120    |
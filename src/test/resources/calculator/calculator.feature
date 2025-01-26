Feature: Calculator

  Scenario Outline: Add two numbers
    Given the first number is <firstNumber>
    And the second number is <secondNumber>
    When the two numbers are added
    Then the result should be <result>
    Examples:
      | firstNumber | secondNumber | result |
      | 50          | 70           | 120    |


  Scenario Outline: Subtracting two numbers
    Given the first number is <firstNumber>
    And the second number is <secondNumber>
    When the first number subtract the second number
    Then the result should be <result>
    Examples:
      | firstNumber | secondNumber | result |
      | 70          | 50           | 20     |
      | 50          | 70           | -20    |
      | 50          | 50           | 0      |

package calculator;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {
    private Calculator calculator = new Calculator();
    private int result;
    @Given("the first number is {int}")
    public void theFirstNumberIs(Integer firstNumber) {
       this.calculator.firstNumber = firstNumber;
    }

    @And("the second number is {int}")
    public void theSecondNumberIs(Integer secondNumber) {
        this.calculator.secondNumber = secondNumber;
    }

    @When("the two numbers are added")
    public void theTwoNumbersAreAdded() {
        this.result = this.calculator.add();
    }

    @Then("the result should be {int}")
    public void theResultShouldBe(Integer result) {
        assertEquals(result, this.result);
    }

}

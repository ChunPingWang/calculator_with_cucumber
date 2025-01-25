package calculator;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {
    private Calculator calculator = new Calculator();
    private int result;

    @Given("the first number is {int}")
    public void the_first_number_is(Integer int1) {
        calculator.firstNumber = int1;
    }
    @Given("the second number is {int}")
    public void the_second_number_is(Integer int1) {
        calculator.secondNumber = int1;
    }
    @When("the two numbers are added")
    public void the_two_numbers_are_added() {
        this.result = calculator.add();
    }
    @Then("the result should be {int}")
    public void the_result_should_be(Integer int1) {
        assertEquals(int1, this.result);
    }


}

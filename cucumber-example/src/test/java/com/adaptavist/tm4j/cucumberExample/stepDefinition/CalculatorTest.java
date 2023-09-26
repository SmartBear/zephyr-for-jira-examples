package com.adaptavist.tm4j.cucumberExample.stepDefinition;

import com.adaptavist.tm4j.cucumberExample.calculator.Calculator;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private Calculator c;

    @Given("^a calculator I just turned on$")
    public void aCalculatorIJustTurnedOn() {
        c = new Calculator();
    }

    @And("^I subtract (\\d+) and (\\d+) and the result is (\\d+)$")
    public void numbersAreSubtracted(long number1, long number2, int result) {
        assertEquals(result, c.subtract(number1, number2));
    }

    @And("^I multiply (\\d+) and (\\d+) and the result is (\\d+)$")
    public void numbersAreMultiplied(long number1, long number2, int result) {
        assertEquals(result, c.multiply(number1, number2));
    }

    @Then("^I sum (\\d+) and (\\d+) and the result is (\\d+)$")
    public void numbersAreSummedUp(int number1, int number2, int result) {
        assertEquals(result, c.sum(number1, number2));
    }
}

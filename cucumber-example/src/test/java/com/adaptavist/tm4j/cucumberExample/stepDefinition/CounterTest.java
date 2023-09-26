package com.adaptavist.tm4j.cucumberExample.stepDefinition;

import org.junit.Assert;

import com.adaptavist.tm4j.cucumberExample.counter.Counter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CounterTest {
    private Counter counter;

    @Given("^a counter I just turned on$")
    public void aCounterIJustTurnedOn() {
        counter = new Counter();
    }

    @Then("^the size is (\\d+)$")
    public void theSizeIs(int result) {
        Assert.assertEquals("Actual doesn't match expected ", counter.getSize(), result);
    }

    @When("^I pass the word (\\w+)$")
    public void lettersAreCounted(String text) {
        counter.count(text);
    }
}

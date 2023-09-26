package com.smartbear.zephyrscale.junitexample;

import com.smartbear.zephyrscale.junit.annotation.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CalculatorSumTest {

    @Test
    @TestCase(key = "WEB-T10")
    public void sumTwoNumbersAndPass() {
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.sum(1, 2));
    }

    @Test
    @TestCase(key = "WEB-T11")
    public void sumTwoNumbersAndFail() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.sum(1, 2));
    }

    @Test
    @TestCase(key = "WEB-T11")
    public void anotherResultForTheSamePreviousTestCase() {
        Calculator calculator = new Calculator();
        assertNotEquals(2, calculator.sum(1, 2));
    }

    @Test
    public void notMappedToTestCaseAndPass() {
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.sum(1, 2));
    }

    @Test
    public void notMappedToTestCaseAndFail() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.sum(1, 2));
    }
}

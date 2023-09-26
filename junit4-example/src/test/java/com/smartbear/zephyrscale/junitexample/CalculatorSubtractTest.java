package com.smartbear.zephyrscale.junitexample;

import com.smartbear.zephyrscale.junit.annotation.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorSubtractTest {

    @Test
    @TestCase(key = "WEB-T7")
    public void subtractTwoNumbersAndPass() {
        Calculator calculator = new Calculator();
        assertEquals(-1, calculator.subtract(1, 2));
    }

    @Test
    @TestCase(key = "WEB-T8")
    public void subtractTwoNumbersAndFail() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.subtract(1, 2));
    }

    @Test
    public void notMappedToTestCaseAndPass() {
        Calculator calculator = new Calculator();
        assertEquals(-1, calculator.subtract(1, 2));
    }

    @Test
    public void notMappedToTestCaseAndFail() {
        Calculator calculator = new Calculator();
        assertEquals(-2, calculator.subtract(1, 2));
    }

    @Test
    @TestCase(key = "WEB-T9", name= "Mapped with both testCaseKey and testCaseName and fails")
    public void mappedWithBothTestCaseKeyAndTestCaseNameFails() {
        Calculator calculator = new Calculator();
        assertEquals(-2, calculator.subtract(1, 2));
    }
}

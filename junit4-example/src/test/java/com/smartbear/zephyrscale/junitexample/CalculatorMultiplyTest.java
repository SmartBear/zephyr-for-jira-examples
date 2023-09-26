package com.smartbear.zephyrscale.junitexample;

import com.smartbear.zephyrscale.junit.annotation.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorMultiplyTest {

    @Test
    @TestCase(key = "WEB-T5")
    public void multiplyTwoNumbersAndPass() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.multiply(1, 2));
    }

    @Test
    @TestCase(key = "WEB-T6")
    public void multiplyTwoNumbersAndFail() {
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.multiply(1, 2));
    }

    @Test
    public void notMappedToTestCaseAndPass() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.multiply(1, 2));
    }

    @Test
    public void notMappedToTestCaseAndFail() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.multiply(1, 2));
    }

    @Test
    @TestCase(name = "Test with custom name pass")
    public void notMappedToTestCaseAndPassWithACustomName() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.multiply(1, 2));
    }
}

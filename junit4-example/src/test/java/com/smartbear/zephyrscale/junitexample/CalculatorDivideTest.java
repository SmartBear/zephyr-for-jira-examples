package com.smartbear.zephyrscale.junitexample;

import com.smartbear.zephyrscale.junit.annotation.TestCase;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CalculatorDivideTest {

    @Test
    @TestCase(key = "WEB-T3")
    public void divideTwoNumbersAndPass() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.divide(4, 2));
    }

    @Test
    @TestCase(key = "WEB-T4")
    public void divideTwoNumbersAndFail() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.divide(4, 2));
    }

    @Test
    @TestCase(key = "WEB-T13")
    @Ignore
    public void ignoreTest() {
        Calculator calculator = new Calculator();
        assertNotEquals(1, calculator.divide(4, 2));
    }

    @Test
    @TestCase(name = "Ignore test with custom name")
    @Ignore
    public void ignoreTestWithCustomName() {
        Calculator calculator = new Calculator();
        assertNotEquals(1, calculator.divide(4, 2));
    }

    @Test
    public void notMappedToTestCaseAndPass() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.divide(4, 2));
    }

    @Test
    public void notMappedToTestCaseAndFail() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.divide(4, 2));
    }

    @Test
    @TestCase(name = "Test with custom name fails")
    public void notMappedToTestCaseAndFailWithACustomName() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.divide(4, 2));
    }
}

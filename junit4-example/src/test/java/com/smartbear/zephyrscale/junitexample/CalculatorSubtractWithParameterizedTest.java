package com.smartbear.zephyrscale.junitexample;

import com.smartbear.zephyrscale.junit.annotation.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CalculatorSubtractWithParameterizedTest {

    private final int n1;
    private final int n2;
    private final int result;

    @Parameterized.Parameters
    public static List<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
                {1, 1, 0},
                {2, 2, 0},
                {3, 2, 0},
                {1, 2, -1}
        });
    }

    public CalculatorSubtractWithParameterizedTest(int n1, int n2, int result) {
        this.n1 = n1;
        this.n2 = n2;
        this.result = result;
    }

    @Test
    @TestCase(key = "WEB-T9")
    public void subtractNumbersAndFail() {
        Calculator calculator = new Calculator();
        assertEquals(result, calculator.subtract(n1, n2));
    }
}

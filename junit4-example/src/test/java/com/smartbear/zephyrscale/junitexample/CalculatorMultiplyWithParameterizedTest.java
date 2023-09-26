package com.smartbear.zephyrscale.junitexample;

import com.smartbear.zephyrscale.junit.annotation.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CalculatorMultiplyWithParameterizedTest {

    private final int n1;
    private final int n2;
    private final int result;

    @Parameterized.Parameters
    public static List<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
                {1, 1, 1},
                {2, 2, 4},
                {3, 2, 6},
                {1, 2, 2}
        });
    }

    public CalculatorMultiplyWithParameterizedTest(int n1, int n2, int result) {
        this.n1 = n1;
        this.n2 = n2;
        this.result = result;
    }

    @Test
    @TestCase(name = "Parameterized Test with custom name pass")
    public void multiplyNumbersAndPass() {
        Calculator calculator = new Calculator();
        assertEquals(result, calculator.multiply(n1, n2));
    }
}

package com.smartbear.junitsupportexample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class ExampleTest {

    // will link to a test case named com.smartbear.junitsupportexample.ExampleTest.testNr1
    @Test
    void testNr1() {
        assertEquals(4, 3);
    }

    // will match with test case with key DEV-T1
    @Test
    void DEV_T1_testNr2() {
        assertEquals(4, 4);
    }

    // will match with test case with key DEV-T2
    @Test
    void testNr3_DEV_T2() {
        fail("failing test");
    }

    // will link to a test case named com.smartbear.junitsupportexample.ExampleTest.parametrizedTest (result aggregated to one test execution)
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = { "-1", "2", "3" })
    void parametrizedTest(String numberAsText) {
        assertTrue(Integer.parseInt(numberAsText) > 0);
    }

}

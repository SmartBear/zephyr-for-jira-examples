package com.smartbear.testngexamples;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class ExemplaryTest {

    // will match test case with key DEV-T19
    @Test(groups = { "group-1", "group-2" })
    public void DEV_T19_testMethod1() {
        assertThat(true).isTrue();
    }

    // will match test case with key DEV-T20
    @Test(dependsOnMethods = {"DEV_T19_testMethod1"})
    public void DEV_T20_testMethod2() {
        assertThat(true).isTrue();
    }

    // will match test case with key DEV-T21
    @Test()
    public void testMethod3_DEV_T21() {
        fail("failing test");
    }

    // will match test case named com.smartbear.testngexamples.ExemplaryTest.testMethod4
    @Test(dependsOnMethods = {"testMethod3_DEV_T21"})
    public void testMethod4() {
        assertThat(true).isTrue();
    }

    @Test()
    @Ignore
    public void DEV_T23_ignoredTestMethod() {
        assertThat(true).isTrue();
    }
}

package com.smartbear.testngexamples;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParametrizedExemplaryTest {

    @DataProvider(name = "peopleDataProvider")
    public Object[][] createData() {
        return new Object[][] {
                { "Cedric", 36},
                { "", 1},
                { "Anne", 37},
                { "Doris", -15},
        };
    }

    @Test(dataProvider = "peopleDataProvider")
    public void DEV_T30_parametrizedTest(String name, Integer age) {
        assertThat(name).isNotBlank();
        assertThat(age).isPositive();
    }

    @Ignore
    @Test(dataProvider = "peopleDataProvider")
    public void DEV_T31_ignoredParametrizedTest(String name, Integer age) {
        assertThat(name).isNotBlank();
        assertThat(age).isPositive();
    }

    @Test(dataProvider = "peopleDataProvider", dependsOnMethods = {"DEV_T30_parametrizedTest"} )
    public void DEV_T32_ignoredParametrizedTest(String name, Integer age) {
        assertThat(name).isNotBlank();
        assertThat(age).isPositive();
    }

    @Test(dataProvider = "peopleDataProvider")
    public void parametrizedTestMatchedByName(String name, Integer age) {
        assertThat(name).isNotBlank();
        assertThat(age).isPositive();
    }

}

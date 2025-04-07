# JUnit 5 Integration Example

This is an example project on how to use the integration of Zephyr and Zephyr Essential with automated tests when using JUnit.

## Executing tests and uploading results to Zephyr

The script `script.sh` generates the JUnit XML results files, zip them together and uploads to Zephyr using the following API endpoint: [`POST /automations/executions/junit`](https://support.smartbear.com/zephyr-scale-cloud/api-docs/#operation/createJUnitExecutions) or to Zephyr Essential using the following API endpoint: [`POST /automations/executions/junit`](https://smartbear.portal.swaggerhub.com/zephyr-squad/default/zephyr-zquad-cloud-api-2#/Automations/createJUnitExecutions).
The above mentioned API accepts either a single XML file as well as a .zip file containing multiple XML files. The POST request will create a new test cycle in Zephyr containing the results and will respond with the key of the created test cycle.
To run the script, execute the following command in bash shell providing the Jira project key as the first parameter and Public REST API token as the second one:

```
./script.sh PROJECT-KEY TOKEN
```

### Linking JUnit tests to Zephyr test cases 

Zephyr relies on a specific format for naming tests: either test case name is matched by full class name and test method name, or a test case key is parsed from the method name if the method name contains a Zephyr test case key.

For example from ExampleTest class:
```
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
    @NullAndEmptySource
    @ValueSource(strings = { "-1", "2", "3" })
    void parametrizedTest(String numberAsText) {
        assertTrue(Integer.parseInt(numberAsText) > 0);
    }

}
```

## Considerations

Zephyr relies on method names provided in JUnit result file. We have detected that for Gradle version 6.7 it does not include method names for parametrized tests for JUnit5. Zephyr will ignore such test cases. We suggest changing the Gradle version.

## Requirements to run this example project

In order to execute script in the example on your local machine you’ll have to checkout this repository and have minimum Java 8, mvn, bash, curl and zip available.

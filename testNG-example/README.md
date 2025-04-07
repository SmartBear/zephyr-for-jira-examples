# TestNG Integration Example

This is an example project that demonstrates how to configrue TestNG to generate the JUnit XML results file required for uploading test results to Zephyr or Zephyr Essential.

## Configuration

No configuration is required beforehand. TestNG already supports JUnit format by default.

In case the default listeners provided by the TestNG library are disabled, it might be necessary to add `org.testng.reporters.XMLReporter` to the listeners used in case default listeners are disabled. Find below how to configure this listener for Gradle and Maven.

### Gradle

```
test {
    useTestNG()
    options {
        useDefaultListeners = false // in case your configuration require disabling default listeners
        listeners = ['org.testng.reporters.JUnitXMLReporter']
    }
}

```

### Maven
```
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>2.22.2</version>
            <configuration>
                <properties>
                    <property>
                        <name>usedefaultlisteners</name>
                        <value>false</value> <!-- in case your configuration require disabling default listeners -->
                    </property>
                    <property>
                        <name>listener</name>
                        <value>
                            org.testng.reporters.JUnitXMLReporter
                        </value>
                    </property>
                </properties>
            </configuration>
        </plugin>
    </plugins>
</build>
```

## Executing tests and uploading results to Zephyr
To execute tests using this example project all that is required is to use Gradle in the root folder from the terminal:

`./gradlew test`

...or run the Gradle task `test` from your IDE.

The command above will execute the TestNG tests and generate a JUnit XML results file. Then, this file containing the test results can be uploaded to Zephyr using the following API endpoint: [`POST /automations/executions/junit`](https://support.smartbear.com/zephyr-scale-cloud/api-docs/#operation/createJUnitExecutions) or to Zephyr Essential using the following API endpoint: [`POST /automations/executions/junit`](https://smartbear.portal.swaggerhub.com/zephyr-squad/default/zephyr-zquad-cloud-api-2#/Automations/createJUnitExecutions).

The abovementioned API accepts either a single XML file as well as a .zip file containing multiple XML files. The POST request will create a new test cycle in Zephyr containing the results and will respond with the key of the created test cycle.

## Naming conventions
Test cases in Zephyr will be matched by the full class name and test name or test case key if a method starts or ends with it. Find below an example:
```
public class ExemplaryTest {

    // will match test case with key DEV-T19
    @Test(groups = { "group-1", "group-2" })
    public void DEV_T19_testMethod1() {
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
}
```

## Requirements to run this example project
In order to execute tests in the example on your local machine you’ll have to checkout this repository and install java 8 or above. 

## Considerations:
- Tests and classes marked with `@Ignore` annotation are not taken into consideration by the framework when it comes to generating output file - as a result, the test cases linked to those tests won't be present in the test cycle created by the endpoint. 
- Tests that depends on a failing tests (e.g. `@Test(dependsOnMethods = {"DEV_T21_testMethod3"})`) is considered skipped and Zephyr test cases linked to such tests will have status Skipped (if custom status present) or Blocked.
- Each test class results in one output file in JUnit xml format in `build/test-results/test` (unless the `@Ignore` annotation is present).

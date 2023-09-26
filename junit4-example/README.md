# Junit 4 Integration Example

This is an example project on how to use the integration of Zephyr Scale and Zephyr Squad with automated tests when using JUnit 4. This JUnit mechanism creates a JSON file containing the test results that can then be uploaded to Zephyr Scale or Zephyr Squad after tests are run.

In order to achieve that, you need to annotate the JUnit methods with `@TestCase`.

## Usage

Firstly, you need to add a dependency to your pom file, to get access to the JUnit listener and the annotations. Note that although the library is named `zephyrscale-junit-integration` it is compatible with both Zephyr Scale and Zephyr Squad:

```
<dependencies>
    <dependency>
        <groupId>com.smartbear</groupId>
        <artifactId>zephyrscale-junit-integration</artifactId>
        <version>2.0.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

Also, you'll need to register the JUnit Listener. This listener is responsible for generating the correct JSON
output file needed for uploading to Zephyr Scale or Zephyr Squad.

```
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>2.22.0</version>
            <configuration>
                <properties>
                    <property>
                        <name>listener</name>
                        <value>com.smartbear.zephyrscale.junit.ExecutionListener</value>
                    </property>
                </properties>
            </configuration>
        </plugin>
    </plugins>
</build>
```

The next step is to annotate your JUnit tests with @TestCase.

The @TestCase(key = "JQA-T1") annotation maps the test method to an existing test case in Zephyr Scale or Zephyr Squad, by matching its key.

The @TestCase(name = "Sum Two Numbers") annotation adds a pretty name to the test case. This will map this test method to an existing test case in Zephyr Scale or Zephyr Squad, by matching its name. If the test case doesn't exist, then a new one can be automatically created using this name, when the results are uploaded.

```
public class CalculatorSumTest {

    @Test
    @TestCase(key = "JQA-T1")
    public void sumTwoNumbersAndPass() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.sum(3, 2));
    }

    @Test
    @TestCase(key = "JQA-T2")
    public void sumTwoNumbersAndFail() {
        Calculator calculator = new Calculator();
        assertNotEquals(2, calculator.sum(1, 2));
    }

    @Test
    public void notMappedToTestCaseAndPass() {
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.sum(1, 2));
    }

    @Test
    @TestCase(name = "Mapped to a Test Case Name and Pass")
    public void mappedToATestCaseNameAndPass() {
        Calculator calculator = new Calculator();
        assertEquals(4, calculator.sum(2, 2));
    }

}

```

Now, you can run your tests with `mvn test` and the test execution result file will be generated in the same execution folder. Not that the file will be named `zephyrscale_result.json` but it works with both Zephyr Scale and Zephyr Squad.

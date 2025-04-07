# Pytest Integration Example

This is an example project that demonstrates how to configure pytest to generate the JUnit XML results file required for uploading test results to Zephyr or Zephyr Essential.

### Configuration

No configuration is required beforehand. Check the section below to see how to execute tests and upload the test results to Zephyr.

## Executing tests and uploading results to Zephyr

In order to instruct pytest to generate the JUnit XML results file, all that is required is to execute the tests with `--junitxml` parameter followed by the xml file name. Here is an example:

```
pytest --junitxml=output/junitxml_report.xml
```

The command line above will execute the pytest tests and generate the JUnit XML results file `output/junitxml_report.xml`. Then, this file containing the test results can be uploaded to Zephyr using the following API endpoint: [`POST /automations/executions/junit`](https://support.smartbear.com/zephyr-scale-cloud/api-docs/#operation/createJUnitExecutions) and to Zephyr Essential using the following API endpoint: [`POST /automations/executions/junit`](https://smartbear.portal.swaggerhub.com/zephyr-squad/default/zephyr-zquad-cloud-api-2#/Automations/createJUnitExecutions).

The above mentioned API accepts either a single XML file as well as a .zip file containing multiple XML files. The POST request will create a new test cycle in Zephyr containing the results and will respond with the key of the created test cycle.

### Naming conventions

In the declared path or current directory, it searches for test_*.py or *_test.py files, imported by their test package name.
From those files, collect test items:
- `test` prefixed test functions or methods outside of class
- `test` prefixed test functions or methods inside `Test` prefixed test classes (without an __init__ method)
(https://docs.pytest.org/en/stable/goodpractices.html#test-discovery)

However, Zephyr relies on a specific format for naming tests: either test case name is matched by full class name (or file path) and test method name or a test case key is parsed from the method name if the method name starts or ends with a Zephyr test case key.
In order to mark a test with a test case key, it must be added at the end of the name. (Or the configuration of pytest framework might be adjusted, more information here: https://docs.pytest.org/en/stable/example/pythoncollection.html)

For example from TestClass:
```
class TestClass:

    # will match with test case with key DEV-T21
    def test_method_3_DEV_T21(self):
        assert 5 == 5

    # will match with test case named tests.test_sample.TestClass.test_method
    def test_method(self):
        x = 'this'
        assert 'h' in x


# will match with test case named tests.test_sample.test_method_1_without_class
def test_method_1_without_class():
    assert 1 == 1
```
## Requirements to run this example project

In order to execute tests in the example on your local machine you’ll have to checkout this repository and install python 3 and pip.
Next, install pytest: `pip install pytest`.
To use the code example, simply run `pyest` in the root folder. In order to generate junit format, use `pytest --junitxml=output/junitxml_report.xml`.

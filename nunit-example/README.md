# NUnit Integration Example

This is an example project that demonstrates how to configure Nunit Framework to generate the JUnit XML results file required for uploading test results to Zephyr or Zephyr Essential.

## Configuration

No configuration is required beforehand. Check the section below to see how to execute tests and upload the test results to Zephyr.


## Executing tests and uploading results to Zephyr

In order to instruct Nunit to excute the tests and generate the JUnit XML results file, It is required is to execute `nunit-console` like this:

```
nunit3-console.exe YourTestAssembly.dll --result=junit-results.xml;transform=nunit3-junit.xslt
```


The command line above will execute the tests and will generate the JUnit XML results file `junit-results.xml`. More info https://github.com/nunit/nunit-transforms/tree/master/nunit3-junit

Then, this file containing the test results can be uploaded to Zephyr using the following API endpoint: [`POST /automations/executions/junit`](https://support.smartbear.com/zephyr-scale-cloud/api-docs/#operation/createJUnitExecutions) or to Zephyr Essential using the following API endpoint: [`POST /automations/executions/junit`](https://smartbear.portal.swaggerhub.com/zephyr-squad/default/zephyr-zquad-cloud-api-2#/Automations/createJUnitExecutions). This API accepts either a single XML file or a .zip file containing multiple XML files. The POST request will create a new test cycle in Zephyr containing the results and will respond with the key of the created test cycle.

## Naming conventions

There are 2 ways to link NUnit test cases with Zephyr test cases:
- **Test case key**: in case your NUnit test case contains the Zephyr test case key
- **Test case name**: if your NUnit test case doesn't contain some Zephyr test case key, then it will try to match the test case by name using the following pattern `<namespace>.<class name>.<method name>`

Here is an example. Consider a class named `UnitTest.cs`:
```csharp

using NUnit.Framework;

namespace UnitTest
{
    public class Tests
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void Test_SubstractMethod()  //  this will match Zephyr test case named UnitTest.Test.Test_SubstractMethod 
        {
            double res = 10 - 10;
            Assert.AreEqual(res, 0);
        }

        [TestCase(2, 2, 4)]
        [TestCase(0, 5, 5)]
        public void Test_AddMethod_NET_T1743(double a, double b, double c) // this will match Zephyr test case with key NET-T1743
        {
            double res = a + b;
            Assert.AreEqual(res, c);
        }

        [Test]
        public void NET_T1744_DivideMethod() // this will match Zephyr test case with key NET-T1744
        {
            Warn.If(2 + 2 != 5); // this warning will failed, in the resport will be show as skipped
            double res = 10 / 5;
            Assert.AreEqual(res, 2);
        }

    }
}

```
As we can see, the first tests will match Zephyr test cases by name and the last 2 will match by key.

## Requirements to run this example project

In order to execute this example on your local machine you will have to checkout this repository and install visual studio and NUnit Console Runner https://docs.nunit.org/articles/nunit/running-tests/Index.html

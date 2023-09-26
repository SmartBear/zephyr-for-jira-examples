package com.adaptavist.tm4j.cucumberExample.counter;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/counterFeatures"
        ,glue={"com/adaptavist/tm4j/cucumberExample/stepDefinition"}
        ,plugin = {"junit:target/cucumber/result.xml", "json:target/cucumber/counter.json"}
)

public class TestRunner {

}

package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/resources/features",
glue = "stepDefinition", 
plugin = { "pretty","html:target/cucumber-reports" }
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
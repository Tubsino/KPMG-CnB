package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"stepDefinition"},tags = ("@Done"),plugin = {"html:target/cucumber-report/html-report.html"}
		)

public class Runner extends AbstractTestNGCucumberTests {

} 

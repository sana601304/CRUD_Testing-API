package com.testautomation.TestRunner;
import java.io.File;
import org.testng.annotations.AfterClass;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="features",glue={"com.testsutomation.StepDef"},
				plugin = { "pretty", "html:target/cucumber-reports" },
				 monochrome = true)

public class TestRunner {
	
	
}

package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)
@io.cucumber.testng.CucumberOptions(features="featurefiles/employee.feature",glue="Stepdefinitions",dryRun =false,plugin= {"pretty","html:reports/empresult.html"})

public class EmployeeLoginTest extends AbstractTestNGCucumberTests{
	
	
	
	
}

package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@io.cucumber.testng.CucumberOptions(features ="featurefiles/Adminlogin.feature",glue = "Stepdefinitions",dryRun = true,plugin={"pretty","html:reports/loginreport.html"})

public class AdminLoginTest extends AbstractTestNGCucumberTests { 


	
	
}

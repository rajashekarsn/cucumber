package testRunner_Package;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/home/shanmukh/git/repository/CucumberMaven_BDDFramework/src/test/freeCRM_BDDPAck_Feature",
		glue = {"testDefinitionsPackage"},
		dryRun = true, //true - to check if all the test definitions are defined
		monochrome = true,
		plugin = {"pretty", "html:target/cucumber", "json:target/cucumber-report.json"},
		junit = "--step-notifications" //to display all the test steps under test results
		)
public class loginTestRunnerClass {

}

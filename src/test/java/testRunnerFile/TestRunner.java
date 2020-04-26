package testRunnerFile;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features ="src/test/java/features",
		glue ="stepDefinations"
		)
public class TestRunner extends AbstractTestNGCucumberTests {
	

}

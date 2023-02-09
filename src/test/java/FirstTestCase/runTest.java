package FirstTestCase;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/FirstTestCase/Features/cucumberJava.feature",format = {"pretty", "html:target/cucumber"})
//@Cucumber.Options(features = "src/test/java/cucumberJava/cucumberJava.feature",format = {"pretty", "html:target/cucumber"})

public class runTest { }
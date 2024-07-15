package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/calendar.feature",
        glue = "stepDefinition"
)
public class TestRunner extends AbstractTestNGCucumberTests {

}

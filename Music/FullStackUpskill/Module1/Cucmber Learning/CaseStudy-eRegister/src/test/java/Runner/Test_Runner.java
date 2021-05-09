package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions (features = {"src\\test\\resources\\Registration\\Registration.feature"},
glue ={"RegistrationProcess"},
//tags="@InValidScenario",
dryRun=false,
monochrome=true,
strict=true,
plugin = {"html:testoutput/eRegistration.html","junit:testoutput/eRegistration.xml","json:testoutput/eRegistration.json"})
public class Test_Runner extends AbstractTestNGCucumberTests {

}
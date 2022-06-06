package steps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        plugin = {"pretty",
                  "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"},
        tags = "@functional",
        features = "src/test/resources/features",
        glue = "steps",
        strict = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}

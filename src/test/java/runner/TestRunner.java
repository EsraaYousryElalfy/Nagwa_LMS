package runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features",
        glue = {"src/test/java/stepDef"},
        plugin = {"pretty", "html:target/cucumber-html-report"})
public class TestRunner {

}

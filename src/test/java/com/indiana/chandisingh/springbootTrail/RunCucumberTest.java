package com.indiana.chandisingh.springbootTrail;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
                 glue="src/test/java/com/indiana/chandisingh/springbootTrail/StoreGlassesStepDefinitions.java",
                 features = "src/test/resources/cucumber")
public class RunCucumberTest {

}

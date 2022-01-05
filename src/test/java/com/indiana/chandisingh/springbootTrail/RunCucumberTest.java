package com.indiana.chandisingh.springbootTrail;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
                 features = "src/test/resources/cucumber/StoreGlasses.feature")
public class RunCucumberTest {

}

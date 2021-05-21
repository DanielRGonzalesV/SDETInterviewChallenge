package us.challenge.web.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Cucumber runner.
 */
@CucumberOptions(
        plugin = {"pretty", "json:report/cucumber.json", "junit:report/cucumber.xml",
                "html:report/cucumber-html-report", "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"},
        features = {"src/test/resources/features"},
        glue = {"us.challenge.web"},
        strict = true)
public class CucumberRunner extends AbstractTestNGCucumberTests {

}

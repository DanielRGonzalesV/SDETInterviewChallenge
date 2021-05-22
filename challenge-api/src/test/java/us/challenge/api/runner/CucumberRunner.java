package us.challenge.api.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Cucumber runner.
 */
@CucumberOptions(
        plugin = {"pretty", "json:report/cucumber.json", "junit:report/cucumber.xml",
                "html:report/cucumber-html-report", "rerun:report/rerun.txt",
                "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"},
        features = {"src/test/resources/features"},
        glue = {"us.challenge.api"},
        strict = true)
public class CucumberRunner extends AbstractTestNGCucumberTests {

}

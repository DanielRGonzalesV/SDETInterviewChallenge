package us.challenge.web.webDriver;

import org.openqa.selenium.WebDriver;

/**
 * This is the interface of the InitWebDriver function.
 */
@FunctionalInterface
public interface IDriver {

    /**
     * This method initialize the driver.
     *
     * @return WebDriver.
     */
    WebDriver initWebDriver();
}

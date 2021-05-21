package us.challenge.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import us.challenge.core.utils.PropertiesInfo;
import us.challenge.web.webDriver.DriverManager;

/**
 * This method represents base page.
 */
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Constructor method.
     */
    public BasePage() {
        driver = DriverManager.getInstance().getDriver();
        wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }

    public void navigateToBaseUrl(){
        driver.get(PropertiesInfo.getInstance().getUrl());
    }

    /**
     * This method closes browser.
     */
    public void closeBrowser() {
        driver.close();
    }
}

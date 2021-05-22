package us.challenge.web.webDriver;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import us.challenge.core.utils.PropertiesInfo;
import us.challenge.web.utils.Constants;

import java.util.concurrent.TimeUnit;

/**
 * This class is going to handle WebDriver that is being used.
 */
public final class DriverManager {

    private static final Logger LOG = Logger.getLogger(DriverManager.class);
    private static DriverManager instance;
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Constructor to prevent instantiation.
     */
    private DriverManager() {
        initWebDriver();
    }

    /**
     * This function used the singleton patter to retrieve just one instance of a DriverManager.
     *
     * @return an instance of a DriverManager.
     */
    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    /**
     * This method is going to be use initialize an instance of a WebDriver.
     */
    private void initWebDriver() {
        driver = FactoryDriver.getDriver(PropertiesInfo.getInstance().getBrowser().toUpperCase()).initWebDriver();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Constants.LOAD_PAGE_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Constants.WAIT_TIME);
        LOG.info("Driver created with hash " + driver.hashCode());
        LOG.info("DriverWait created with hash " + wait.hashCode());
    }

    /**
     * This method retrieves the instance of a WebDriver.
     *
     * @return driver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * This method retrieves the instance of a WebDriverWait.
     *
     * @return wait
     */
    public WebDriverWait getWait() {
        return wait;
    }
}

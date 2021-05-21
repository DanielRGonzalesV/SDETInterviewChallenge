package us.challenge.web.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import us.challenge.web.pages.CartPage;
import us.challenge.web.pages.HomePage;
import us.challenge.web.pages.NavBarPage;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents before and after hooks.
 */
public class WebHooks {
    private static final Logger LOGGER = Logger.getLogger(WebHooks.class.getSimpleName());
    HomePage homePage = new HomePage();
    NavBarPage navBarPage = new NavBarPage();

    /**
     * This method is going to open the browser and maximize it.
     */
    @Before
    public void beforeFeature() {
    }

    /**
     * Hook to remove item from Cart.
     */
    @After("@deleteAddedItem")
    public void deleteUserApi() {
        CartPage cartPage = navBarPage.clickCartIcon();
        cartPage.removeAllItems();
    }

    /**
     * Hook to step a broadcast.
     */
    @After()
    public void stopBroadcast() {
        LOGGER.info("Finish execution");
        homePage.closeBrowser();
    }
}

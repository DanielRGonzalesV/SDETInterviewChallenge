package us.challenge.web.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import us.challenge.web.pages.CartPage;
import us.challenge.web.pages.HomePage;
import us.challenge.web.pages.NavBarPage;

/**
 * This class represents before and after hooks.
 */
public class WebHooks {
    private static final Logger LOGGER = Logger.getLogger(WebHooks.class.getSimpleName());
    private HomePage homePage = new HomePage();
    private NavBarPage navBarPage = new NavBarPage();

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
    public void deleteAddedItem() {
        CartPage cartPage = navBarPage.clickCartIcon();
        cartPage.removeAllItems();
    }

    /**
     * Hook to step a broadcast.
     */
    @AfterSuite()
    public void stopBroadcast() {
        LOGGER.info("Finish execution");
        homePage.closeBrowser();
    }
}

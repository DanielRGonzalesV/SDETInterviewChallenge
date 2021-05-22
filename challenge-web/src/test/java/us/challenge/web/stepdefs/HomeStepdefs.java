package us.challenge.web.stepdefs;

import io.cucumber.java.en.Given;
import org.apache.log4j.Logger;
import us.challenge.web.pages.HomePage;

/**
 * This class represents Store steps.
 */
public class HomeStepdefs {
    private static final Logger LOGGER = Logger.getLogger(HomeStepdefs.class.getSimpleName());

    private HomePage homePage;

    /**
     * Constructor for Home page steps.
     *
     * @param homePage dependency.
     */
    public HomeStepdefs(final HomePage homePage) {
        this.homePage = homePage;
    }

    /**
     * Step to navigate to home Page.
     */
    @Given("I navigate to Amazon Portal")
    public void iNavigateToAmazonPortal() {
        this.homePage.navigateToBaseUrl();
        LOGGER.info("Navigate to Portal page");
    }
}

package us.challenge.web.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
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

    @When("I search the {string} item")
    public void iSearchTheItem(String keyNameItem) {
        this.homePage.searchItem(keyNameItem);
    }

}

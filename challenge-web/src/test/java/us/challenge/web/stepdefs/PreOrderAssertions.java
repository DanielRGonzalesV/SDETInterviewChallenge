package us.challenge.web.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.testng.Assert;
import us.challenge.core.constants.EnvConstants;
import us.challenge.web.pages.PreOrderPage;

/**
 * User Pre order page dependency.
 */
public class PreOrderAssertions {

    private static final Logger LOGGER = Logger.getLogger(PreOrderAssertions.class.getSimpleName());

    private PreOrderPage preOrderPage;

    /**
     * Constructor for Pre order page steps.
     *
     * @param preOrderPage dependency.
     */
    public PreOrderAssertions(final PreOrderPage preOrderPage) {
        this.preOrderPage = preOrderPage;
    }

    /**
     * Step to validate if the Pre order page is displayed.
     */
    @Then("The pre-order page is displayed")
    public void thePreOrderPageIsDisplayed() {
        Assert.assertTrue(this.preOrderPage.isDisplayed(), "Item page is not displayed");
    }

    @And("The item price added should be the same as saved {string} price")
    public void theItemPriceAddedShouldBeTheSameAsSavedPrice(String keyNameItem) {
        Assert.assertEquals(this.preOrderPage.getItemPriceWithoutSymbol(), EnvConstants.get(keyNameItem.concat("Price")),
                "The prices are not equals");
    }
}

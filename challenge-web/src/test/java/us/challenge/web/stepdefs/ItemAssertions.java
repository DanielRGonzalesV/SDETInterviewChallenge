package us.challenge.web.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.testng.Assert;
import us.challenge.core.constants.EnvConstants;
import us.challenge.web.pages.ItemPage;

/**
 * User Item page dependency.
 */
public class ItemAssertions {

    private static final Logger LOGGER = Logger.getLogger(ItemAssertions.class.getSimpleName());

    private ItemPage itemPage;

    /**
     * Constructor for Item page steps.
     *
     * @param itemPage dependency.
     */
    public ItemAssertions(final ItemPage itemPage) {
        this.itemPage = itemPage;
    }

    /**
     * Step to validate if the Item page is displayed.
     */
    @Then("The item page is displayed")
    public void theItemPageIsDisplayed() {
        Assert.assertTrue(itemPage.isDisplayed(), "Item page is not displayed");
    }

    @And("The item price displayed should be the same as saved {string} price")
    public void theItemPriceDisplayedShouldBeTheSameAsSavedPrice(String keyNameItem) {
        Assert.assertEquals(itemPage.getItemPriceWithoutSymbol(), EnvConstants.get(keyNameItem.concat("Price")),
                "The prices are not equals");
    }
}

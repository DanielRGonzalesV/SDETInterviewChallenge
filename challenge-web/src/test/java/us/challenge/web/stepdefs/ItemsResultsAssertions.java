package us.challenge.web.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import us.challenge.web.pages.ItemsResultsPage;

/**
 * Items results page dependency.
 */
public class ItemsResultsAssertions {

    private ItemsResultsPage itemsResultsPage;

    /**
     * Constructor for Items results assertions.
     *
     * @param itemsResultsPage dependency.
     */
    public ItemsResultsAssertions(final ItemsResultsPage itemsResultsPage) {
        this.itemsResultsPage = itemsResultsPage;
    }

    /**
     * Step to validate if the Items results page is displayed.
     */
    @Then("The result page is displayed")
    public void theResultPageIsDisplayed() {
        Assert.assertTrue(itemsResultsPage.isDisplayed(), "Items results page is not displayed");
    }

    @And("The {string} item is displayed in the page")
    public void theItemIsDisplayedInThePage(String keyNameItem) {
        Assert.assertTrue(itemsResultsPage.isItemOnResultsDisplayed(keyNameItem),
                "no item matches the search in the results");
    }
}

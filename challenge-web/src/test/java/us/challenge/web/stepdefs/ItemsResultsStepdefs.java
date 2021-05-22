package us.challenge.web.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import us.challenge.web.pages.ItemsResultsPage;

/**
 * This class represents Store steps.
 */
public class ItemsResultsStepdefs {
    private static final Logger LOGGER = Logger.getLogger(ItemsResultsStepdefs.class.getSimpleName());

    private ItemsResultsPage itemsResultsPage;

    /**
     * Constructor for Home page steps.
     *
     * @param itemsResultsPage dependency.
     */
    public ItemsResultsStepdefs(final ItemsResultsPage itemsResultsPage) {
        this.itemsResultsPage = itemsResultsPage;
    }

    @And("I save the item price for first {string}")
    public void iSaveTheItemPriceFor(String keyNameItem) {
        this.itemsResultsPage.saveDataValue(keyNameItem);
    }

    @When("I click on the {string} first item on the result list")
    public void iClickOnTheFirstItemOnTheResultList(String keyNameItem) {
        this.itemsResultsPage.selectFirstItem(keyNameItem);
    }
}

package us.challenge.web.stepdefs;

import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import us.challenge.web.pages.ItemPage;

/**
 * This class represents Item steps.
 */
public class ItemStepdefs {
    private static final Logger LOGGER = Logger.getLogger(ItemStepdefs.class.getSimpleName());

    private ItemPage itemPage;

    /**
     * Constructor for Item page steps.
     *
     * @param itemPage dependency.
     */
    public ItemStepdefs(final ItemPage itemPage) {
        this.itemPage = itemPage;
    }

    @When("I add the item to the Cart")
    public void iAddTheItemToTheCart() {
        this.itemPage.addItemToCart();
    }
}

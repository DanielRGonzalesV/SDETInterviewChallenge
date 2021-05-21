package us.challenge.web.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import us.challenge.web.pages.HomePage;
import us.challenge.web.pages.NavBarPage;

/**
 * This class represents Store steps.
 */
public class NavBarStepdefs {
    private static final Logger LOGGER = Logger.getLogger(NavBarStepdefs.class.getSimpleName());

    private NavBarPage navBarPage;

    /**
     * Constructor for NavBar page steps.
     *
     * @param navBarPage dependency.
     */
    public NavBarStepdefs(final NavBarPage navBarPage) {
        this.navBarPage = navBarPage;
    }

    @When("I search the {string} item")
    public void iSearchTheItem(String keyNameItem) {
        this.navBarPage.searchItem(keyNameItem);
    }

    @When("I open the Account and list options")
    public void iOpenTheAccountAndListOptions() {
        this.navBarPage.openAccountAndListDropDownList();
    }

    @And("I click on Start here for New customer")
    public void iClickOnStartHereForNewCustomer() {
        this.navBarPage.openAccountAndListMenu.clickOnClickHere();
    }
}

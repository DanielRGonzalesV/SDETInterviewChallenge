package us.challenge.web.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;
import us.challenge.web.pages.CreateAccountPage;

import java.util.List;
import java.util.Map;

/**
 * This class represents Create Account steps.
 */
public class CreateAccountStepdefs {
    private static final Logger LOGGER = Logger.getLogger(CreateAccountStepdefs.class.getSimpleName());

    private CreateAccountPage createAccountPage;

    /**
     * Constructor for Create Account Page steps.
     *
     * @param createAccountPage dependency.
     */
    public CreateAccountStepdefs(CreateAccountPage createAccountPage) {
        this.createAccountPage = createAccountPage;
    }

    @Then("The Create account page is displayed")
    public void theCreateAccountPageIsDisplayed() {
        Assert.assertTrue(createAccountPage.isDisplayed(), "Create Account page is not displayed");
    }

    @When("I fill out the form with the information of employee number {string}")
    public void iFillOutTheFormWithTheInformationOfEmployeeNumber(final String indexEmployee, final DataTable newAccountInfo) {
        this.createAccountPage.loadEmployeeInformation(indexEmployee);
        List<Map<String, String>> dataToFill = newAccountInfo.asMaps(String.class, String.class);
        for (Map<String, String> rowMap : dataToFill) {
            this.createAccountPage.fillOutForm(rowMap.get("Field"), rowMap.get("Value"));
        }
    }

    @And("I click on Create your Amazon account")
    public void iClickOnCreateYourAmazonAccount() {
        this.createAccountPage.clickOnCreateAccount();
    }
}

package us.challenge.web.stepdefs;

import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.testng.Assert;
import us.challenge.web.pages.VerifyEmailAddressPage;

/**
 * This class represents verify Email Address steps.
 */
public class VerifyEmailStepdefs {
    private static final Logger LOGGER = Logger.getLogger(VerifyEmailStepdefs.class.getSimpleName());

    private VerifyEmailAddressPage verifyEmailAddressPage;

    /**
     * Constructor for verify Email Address page steps.
     *
     * @param verifyEmailAddressPage dependency.
     */
    public VerifyEmailStepdefs(final VerifyEmailAddressPage verifyEmailAddressPage) {
        this.verifyEmailAddressPage = verifyEmailAddressPage;
    }

    @Then("The Verify email address page is displayed")
    public void theVerifyEmailAddressPageIsDisplayed() {
        Assert.assertTrue(verifyEmailAddressPage.isDisplayed(), "verify Email Address page is not displayed");
    }
}

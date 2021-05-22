package us.challenge.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import us.challenge.web.utils.CommonActions;

public class VerifyEmailAddressPage extends BasePage {
    private static final Logger LOG = Logger.getLogger(VerifyEmailAddressPage.class.getName());

    @FindBy(id = "a-page")
    private WebElement verificationPuzzle;

    /**
     * Constructor method.
     */
    public VerifyEmailAddressPage() {
    }

    public boolean isDisplayed() {
        return CommonActions.isElementPresent(verificationPuzzle);
    }
}

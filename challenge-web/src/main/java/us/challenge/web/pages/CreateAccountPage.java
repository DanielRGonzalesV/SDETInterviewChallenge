package us.challenge.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import us.challenge.web.utils.CommonActions;

import java.util.Map;

public class CreateAccountPage extends BasePage {

    private static final Logger LOG = Logger.getLogger(CreateAccountPage.class.getName());

    @FindBy(id = "ap_register_form")
    private WebElement registerFormContainer;

    @FindBy(id = "continue")
    private WebElement createAccount;

    /**
     * Constructor method.
     */
    public CreateAccountPage() {
    }

    public boolean isDisplayed() {
        return CommonActions.isElementPresent(registerFormContainer);
    }

    public void fillOutForm(int indexEmployee, Map<String, String> newAccountInfo) {

    }

    public void clickOnCreateAccount() {
        CommonActions.clickWebElement(createAccount);
    }
}

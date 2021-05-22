package us.challenge.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import us.challenge.core.constants.EnvConstants;
import us.challenge.web.utils.CommonActions;
import us.challenge.web.utils.ParseEmployeeInformation;

import java.util.HashMap;
import java.util.Map;

public class CreateAccountPage extends BasePage {

    private static final Logger LOG = Logger.getLogger(CreateAccountPage.class.getName());
    private Map<String, IStepActionWithStringParam> formInformation = new HashMap<>();


    @FindBy(id = "ap_register_form")
    private WebElement registerFormContainer;

    @FindBy(id = "continue")
    private WebElement createAccount;

    @FindBy(css = "input#ap_customer_name")
    private WebElement userName;

    @FindBy(css = "input#ap_email")
    private WebElement userEmail;

    @FindBy(css = "input#ap_password")
    private WebElement userPass;

    @FindBy(css = "input#ap_password_check")
    private WebElement userCheckPass;


    /**
     * Constructor method.
     */
    public CreateAccountPage() {
    }

    /**
     * Method to validate if the page is displayed
     * @return true if the page is displayed, otherwise false
     */
    public boolean isDisplayed() {
        return CommonActions.isElementPresent(registerFormContainer);
    }

    public void fillOutForm(final String field, final String value) {
        formInformation.put("Your name", this::setName);
        formInformation.put("Email", this::setEmail);
        formInformation.put("Password", this::setPassword);
        formInformation.put("Re-enter password", this::setConfirmPassword);

        formInformation.get(field).performAction(value);
    }

    private void setConfirmPassword(String keyPassApi) {
        String valueFromApi = EnvConstants.get(keyPassApi);
        CommonActions.setWebElement(userPass, valueFromApi);
    }

    private void setPassword(String keyPassApi) {
        String valueFromApi = EnvConstants.get(keyPassApi);
        CommonActions.setWebElement(userCheckPass, valueFromApi);
    }

    private void setEmail(String keyEmailApi) {
        String valueFromApi = EnvConstants.get(keyEmailApi);
        CommonActions.setWebElement(userEmail, valueFromApi);
    }

    private void setName(String keyNameApi) {
        String valueFromApi = EnvConstants.get(keyNameApi);
        CommonActions.setWebElement(userName, valueFromApi);
    }

    public void clickOnCreateAccount() {
        CommonActions.clickWebElement(createAccount);
    }

    public void loadEmployeeInformation(String indexEmployee) {
        ParseEmployeeInformation.loadInformationFromApi(indexEmployee);
    }
}

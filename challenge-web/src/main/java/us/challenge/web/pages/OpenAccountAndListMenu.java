package us.challenge.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import us.challenge.web.utils.CommonActions;

/**
 * This class represents Open Account And List Menu.
 */
public class OpenAccountAndListMenu extends BasePage {

    private static final Logger LOG = Logger.getLogger(OpenAccountAndListMenu.class.getName());

    @FindBy(css = "#nav-flyout-ya-newCust .nav-a")
    private WebElement clickHereLink;

    /**
     * Constructor method.
     */
    public OpenAccountAndListMenu() {
    }

    public CreateAccountPage clickOnClickHere() {
        CommonActions.clickWebElement(clickHereLink);
        return new CreateAccountPage();
    }
}

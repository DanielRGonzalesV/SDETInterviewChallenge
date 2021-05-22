package us.challenge.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import us.challenge.core.constants.EnvConstants;
import us.challenge.web.utils.CommonActions;

public class NavBarPage extends BasePage {

    private static final Logger LOG = Logger.getLogger(NavBarPage.class.getName());

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchInput;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    @FindBy(css = "a#nav-cart")
    private WebElement cartIcon;

    @FindBy(id = "nav-link-accountList")
    private WebElement accountAndList;

    /**
     * Constructor method.
     */
    public NavBarPage() {
    }

    public void searchItem(String keyNameItem) {
        String dataValue = EnvConstants.get(keyNameItem);
        CommonActions.setWebElement(searchInput, dataValue);
        CommonActions.clickWebElement(searchButton);
    }

    public CartPage clickCartIcon() {
        CommonActions.clickWebElement(cartIcon);
        return new CartPage();
    }

    public void openAccountAndListDropDownList() {
        CommonActions.hoverOverWebElement(accountAndList);
    }
}

package us.challenge.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import us.challenge.web.utils.CommonActions;

public class CartPage extends BasePage {

    private static final Logger LOG = Logger.getLogger(CartPage.class.getName());

    @FindBy(css = "[data-action='delete'][type='submit']")
    private WebElement removeItem;

    private NavBarPage navBarPage;

    /**
     * Constructor method.
     */
    public CartPage() {
        this.navBarPage = new NavBarPage();
    }

    /**
     * Method to remove All item on the Cart
     */
    public void removeAllItems() {
        CommonActions.clickWebElement(removeItem);
    }
}

package us.challenge.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import us.challenge.web.utils.CommonActions;

public class PreOrderPage extends BasePage {

    private static final Logger LOG = Logger.getLogger(PreOrderPage.class.getName());

    @FindBy(id = "huc-v2-confirm-text-container")
    private WebElement addedItemConfirm;

    @FindBy(css = "#hlb-subcart .a-color-price")
    private WebElement itemPrice;

    /**
     * Constructor method.
     */
    public PreOrderPage() {
    }

    public boolean isDisplayed() {
        return CommonActions.isElementPresent(addedItemConfirm);
    }

    public String getItemPriceWithoutSymbol() {
        String priceValueUI = CommonActions.getText(itemPrice);
        return priceValueUI.replace("$", "").trim();
    }
}

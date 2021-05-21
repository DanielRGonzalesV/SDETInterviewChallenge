package us.challenge.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import us.challenge.web.utils.CommonActions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String finalValue = "";
        Pattern p = Pattern.compile("(\\d+).");
        Matcher m = p.matcher(CommonActions.getText(itemPrice));
        if (m.find()) {
            finalValue = m.toString();
        }
        return finalValue;
    }
}

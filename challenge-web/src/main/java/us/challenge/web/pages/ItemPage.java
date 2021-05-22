package us.challenge.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import us.challenge.web.utils.CommonActions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemPage extends BasePage {

    private static final Logger LOG = Logger.getLogger(ItemPage.class.getName());

    @FindBy(id = "productTitle")
    private WebElement itemTitle;

    @FindBy(id = "priceblock_ourprice")
    private WebElement itemPrice;

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCart;

    /**
     * Constructor method.
     */
    public ItemPage() {
    }

    public boolean isDisplayed() {
        return CommonActions.isElementPresent(itemTitle);
    }

    public String getItemPriceWithoutSymbol() {
        String finalValue = "";
        Pattern p = Pattern.compile("(\\d+\\.\\d+)");
        Matcher m = p.matcher(CommonActions.getText(itemPrice));
        if (m.find()) {
            finalValue = String.valueOf(m.group(0));
        }
        return finalValue;
    }

    public void addItemToCart() {
        CommonActions.clickWebElement(addToCart);
    }
}

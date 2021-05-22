package us.challenge.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import us.challenge.core.constants.EnvConstants;
import us.challenge.web.utils.CommonActions;

import java.util.List;
import java.util.stream.Collectors;

public class ItemsResultsPage extends BasePage {

    private static final Logger LOG = Logger.getLogger(ItemsResultsPage.class.getName());
    private static final String ITEM_FOUND = ".s-search-results [data-index='%s'][data-component-type='s-search-result']";
    private static final String ITEM_IMAGE = "  [data-component-type='s-product-image'] a";
    private static final String ITEM_WHOLE_PRICE = " .a-price-whole";
    private static final String ITEM_FRACTION_PRICE = " .a-price-fraction";
    public static final String DECIMAL_DOT = ".";

    @FindBy(css = "[data-component-type='s-result-info-bar']")
    private WebElement resultsComponent;

    @FindBy(css = ".a-link-normal .a-text-normal")
    private List<WebElement> itemsTextFound;

    @FindBy(css = "[data-component-type='s-search-result']")
    private List<WebElement> allItemsFound;


    /**
     * Constructor method.
     */
    public ItemsResultsPage() {
    }

    public boolean isDisplayed() {
        return CommonActions.isElementPresent(resultsComponent);
    }

    public boolean isItemOnResultsDisplayed(String keyNameItem) {
        String dataValue = EnvConstants.get(keyNameItem);
        List<String> results = CommonActions.getListStringForAllElements(itemsTextFound);
        return results.stream().filter(element -> element.contains(dataValue)).collect(Collectors.toList()).size() > 0;
    }

    public void saveDataValue(String keyNameItem) {
        String dataValue = EnvConstants.get(keyNameItem);
        String itemIndex = this.getIndexFirstElementFound(dataValue);
        String completeItemPriceFound = this.getCompletePrice(itemIndex);
        EnvConstants.set(keyNameItem.concat("Price"), completeItemPriceFound);
    }

    private WebElement getItemElement(String itemIndex, String elementValue) {
        return CommonActions.getWebElementWithCss(String.format(ITEM_FOUND.concat(elementValue), itemIndex));
    }

    public void selectFirstItem(String keyNameItem) {
        String dataValue = EnvConstants.get(keyNameItem);
        ;
        this.clickOnFirstItemWithCriteria(dataValue);
    }

    private void clickOnFirstItemWithCriteria(String dataValue) {
        String itemIndex = this.getIndexFirstElementFound(dataValue);
        WebElement itemFound = this.getItemElement(itemIndex, ITEM_IMAGE);
        CommonActions.clickWebElement(itemFound);
    }

    private String getIndexFirstElementFound(String dataValue) {
        WebElement elementFound = allItemsFound.stream().filter(item -> item.getText().contains(dataValue))
                .findFirst().orElse(null);
        return CommonActions.getAttribute(elementFound, "data-index");
    }

    private String getCompletePrice(String itemIndex) {
        String itemWholePriceFound = CommonActions.getText(this.getItemElement(itemIndex, ITEM_WHOLE_PRICE));
        String itemFractionPriceFound = CommonActions.getText(this.getItemElement(itemIndex, ITEM_FRACTION_PRICE));
        return itemWholePriceFound.concat(DECIMAL_DOT).concat(itemFractionPriceFound);
    }
}

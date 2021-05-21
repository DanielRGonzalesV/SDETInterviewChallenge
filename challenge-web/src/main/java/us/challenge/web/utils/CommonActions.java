package us.challenge.web.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import us.challenge.web.webDriver.DriverManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * This class handles selenium common actions.
 */
public final class CommonActions {
    private static final Logger LOGGER = Logger.getLogger(CommonActions.class.getSimpleName());
    private static final WebDriver WEB_DRIVER = DriverManager.getInstance().getDriver();
    private static Actions actionsInstance = null;

    /**
     * Constructor method.
     */
    private CommonActions() {
        getActions();
    }

    /**
     * This method retrieves actions.
     *
     * @return Actions
     */
    private static Actions getActions() {
        if (actionsInstance == null) {
            actionsInstance = new Actions(WEB_DRIVER);
        }
        return actionsInstance;
    }

    /**
     * This method validates whether a WebElement is present or not on the WebApplication.
     *
     * @param webElement to find
     * @return true if WebElement is present or false if not.
     */
    public static boolean isElementPresent(final WebElement webElement) {
        try {
            webElement.getTagName();
            return true;
        } catch (WebDriverException e) {
            LOGGER.warn("Web element not found " + e.getMessage());
            return false;
        }
    }

    /**
     * This method checks if element is present with css.
     *
     * @param cssLocator to use.
     * @return true if present, false if not.
     */
    public static boolean isElementPresentWithCssLocator(final String cssLocator) {
        try {
            WebElement element = getWebElementWithCss(cssLocator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    /**
     * This method checks if element is displayed.
     *
     * @param webElement to find.
     * @return true if displayed, false if not.
     */
    public static boolean isElementDisplayed(final WebElement webElement) {
        try {
            webElement.isDisplayed();
            return true;
        } catch (WebDriverException e) {
            LOGGER.warn("Web element not displayed" + e.getMessage());
            return false;
        }
    }

    /**
     * This method checks if element is displayed.
     *
     * @param locator to find.
     * @return true if displayed, false if not.
     */
    public static boolean isElementNotDisplayed(final By locator) {
        try {
            DriverManager.getInstance().getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
            return true;
        } catch (WebDriverException e) {
            LOGGER.warn("Web element is displayed" + e.getMessage());
            return false;
        }
    }

    /**
     * This method is going to click a WebElement in the WebApplication.
     *
     * @param webElement to be clicked.
     */
    public static void clickWebElement(final WebElement webElement) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * This method is going to check a CheckBox WebElement in the WebApplication.
     *
     * @param webElement checkbox to be checked.
     * @param enable     true to check or false to uncheck the Checkbox WebElement.
     */
    public static void setCheckBox(final WebElement webElement, final boolean enable) {
        if (enable) {
            unCheckBox(webElement);
        } else {
            checkBox(webElement);
        }
    }

    /**
     * This method is going to uncheck the CheckBox WebElement.
     *
     * @param webElement CheckBox to be unchecked.
     */
    private static void unCheckBox(final WebElement webElement) {
        if (!webElement.isSelected()) {
            webElement.click();
        }
    }

    /**
     * This method is going to check the CheckBox WebElement.
     *
     * @param webElement CheckBox to be checked.
     */
    private static void checkBox(final WebElement webElement) {
        if (webElement.isSelected()) {
            webElement.click();
        }
    }

    /**
     * This method is going to select an option from a ComboBox WebElement in the WebApplication.
     *
     * @param webElementSelect ComboBox WebElement.
     * @param element          to be selected from the ComboBox WebElement.
     */
    public static void selectAElementComboBox(final WebElement webElementSelect, final String element) {
        Select oSelect = new Select(webElementSelect);
        oSelect.selectByValue(element);
    }

    /**
     * This method is going to set a text box field in the WebApplication.
     *
     * @param webElement Field WebElement
     * @param text       to insert on field.
     */
    public static void setWebElement(final WebElement webElement, final String text) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    /**
     * This method switch to tab that has a specific title.
     *
     * @param title of the window.
     */
    public static void switchBrowserWindow(final String title) {
        WebDriver currentWebDriver = DriverManager.getInstance().getDriver();
        Set<String> browserWindows = currentWebDriver.getWindowHandles();
        LOGGER.info("tabs are " + browserWindows.size());
        browserWindows.forEach(LOGGER::info);
        for (String browserWindowTitle : browserWindows) {
            currentWebDriver.switchTo().window(browserWindowTitle);
            LOGGER.info(currentWebDriver.getTitle() + " current window ");
            if (currentWebDriver.getTitle().equalsIgnoreCase(title)) {
                LOGGER.info(currentWebDriver.getTitle() + " == " + title);
                LOGGER.info("Switch window to " + currentWebDriver.getTitle());
                return;
            }
        }
    }

    /**
     * This method waits until specific web element is not displayed.
     *
     * @param element to wait.
     */
    public static void waitUntilElementNotDisplayed(final WebElement element) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * This method waits until specific web element is clickable.
     *
     * @param element to wait.
     */
    public static void waitUntilElementToBeClickable(final WebElement element) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * This method waits until specific web element is displayed.
     *
     * @param element to wait.
     */
    public static void waitUntilElementIsDisplayed(final WebElement element) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * This method will double click a web element.
     *
     * @param webElement to be double clicked
     */
    public static void doubleClickWebELement(final WebElement webElement) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(webElement));
        getActions().doubleClick(webElement);
    }

    /**
     * This method will compare display text on web element.
     *
     * @param webElement to find.
     * @param message    to compare.
     * @return true if display text is equal to message and false if not equal.
     */
    public static boolean isTextPresentOnWebElement(final WebElement webElement, final String message) {
        String actualText = webElement.getText();
        LOGGER.info(actualText.concat(" == ").concat(message));
        return actualText.equals(message);
    }

    /**
     * This method executes js script.
     *
     * @param jsScript to execute.
     */
    public static void runJsScript(final String jsScript) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getInstance().getDriver();
        js.executeScript(jsScript);
    }

    /**
     * This method checks if element is displayed with css.
     *
     * @param cssLocator to find.
     * @return true if displayed, false if not.
     */
    public static boolean isElementDisplayedWithCss(final String cssLocator) {
        boolean isDisplayed = false;
        try {
            isDisplayed = getWebElementWithCss(cssLocator).isDisplayed();
        } catch (NoSuchElementException e) {
            LOGGER.info(cssLocator.concat(" is not displayed"));
        }
        return isDisplayed;
    }

    /**
     * This method returns the text present in the web element.
     *
     * @param webElement to be used.
     * @return text.
     */
    public static String getText(final WebElement webElement) {
        return webElement.getText();
    }

    /**
     * This method is going to switch a toggle WebElement in the WebApplication.
     *
     * @param webElement toggle to be switch.
     * @param enable     true to toggle ON or false to toggle OFF the toggle WebElement.
     */
    public static void toggleSwitch(final WebElement webElement, boolean enable) {
        if (!(enable == webElement.isSelected())) {
            webElement.click();
        }
    }

    /**
     * This method will return a string list of the received list of webelements.
     *
     * @param webElements with all elements.
     * @return list of strings for all elements in the list.
     */
    public static List<String> getListStringForAllElements(final List<WebElement> webElements) {
        List<String> myList = new ArrayList<>();
        for (WebElement element : webElements) {
            myList.add(element.getText().trim());
        }

        return myList;
    }

    /**
     * This method hovers the mouse pointer over the web element.
     *
     * @param graphicElement to hover over.
     */
    public static void hoverOverWebElement(final WebElement graphicElement) {
        getActions().moveToElement(graphicElement).perform();
    }

    /**
     * This method retrieves a web element using css.
     *
     * @param cssLocator to find.
     * @return WebElement.
     */
    public static WebElement getWebElementWithCss(final String cssLocator) {
        return DriverManager.getInstance().getDriver().findElement(By.cssSelector(cssLocator));
    }

    /**
     * This method retrieves web elements using css.
     *
     * @param cssLocator to find.
     * @return WebElements list.
     */
    public static List<WebElement> getWebElementsWithCss(final String cssLocator) {
        return DriverManager.getInstance().getDriver().findElements(By.cssSelector(cssLocator));
    }

    /**
     * This method retrieves a web element using xpath.
     *
     * @param xpath to find.
     * @return WebElement.
     */
    public static WebElement getWebElementWithXpath(final String xpath) {
        return DriverManager.getInstance().getDriver().findElement(By.xpath(xpath));
    }

    /**
     * This method checks if element is present with xpath.
     *
     * @param xpathLocator to find.
     * @return true if present, false if not.
     */
    public static boolean isElementPresentWithXpathLocator(final String xpathLocator) {
        try {
            WebElement element = getWebElementWithXpath(xpathLocator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    /**
     * This method gets attribute from webelement.
     *
     * @param webElement webelement.
     * @param attribute  attribute to retrieve.
     * @return webelement's attribute retrieved.
     */
    public static String getAttribute(final WebElement webElement, final String attribute) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getAttribute(attribute);
    }

    /**
     * Method to find element inside WebElement.
     *
     * @param webElement to find inside.
     * @param locator    web element locator.
     * @return webElement found.
     */
    public static WebElement findElementIntoWebElement(final WebElement webElement, final By locator) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(webElement));
        return webElement.findElement(locator);
    }

    /**
     * This method checks if element is displayed with xpath.
     *
     * @param xpathLocator to find.
     * @return true if displayed, false if not.
     */
    public static boolean isElementDisplayedWithXpath(final String xpathLocator) {
        boolean isDisplayed = false;
        try {
            isDisplayed = getWebElementWithXpath(xpathLocator).isDisplayed();
        } catch (NoSuchElementException e) {
            LOGGER.info(xpathLocator.concat(" is not displayed"));
        }
        return isDisplayed;
    }
}

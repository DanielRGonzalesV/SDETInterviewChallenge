package us.challenge.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import us.challenge.core.utils.PropertiesInfo;

/**
 * This class represents Polls page.
 */
public class HomePage extends BasePage {

    private static final Logger LOG = Logger.getLogger(HomePage.class.getName());

    @FindBy(css = "#nav-cart-count-container .nav-cart-icon")
    private WebElement cartIcon;

    /**
     * Constructor method.
     */
    public HomePage() {
    }

    public void navigateToPage() {
        this.navigateToUrl(PropertiesInfo.getInstance().getUrl());
    }
}

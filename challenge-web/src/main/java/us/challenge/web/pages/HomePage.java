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

    private NavBarPage navBarPage;

    /**
     * Constructor method.
     */
    public HomePage() {
        this.navBarPage = new NavBarPage();
    }

    public void searchItem(String keyNameItem) {
        this.navBarPage.searchItem(keyNameItem);
    }
}

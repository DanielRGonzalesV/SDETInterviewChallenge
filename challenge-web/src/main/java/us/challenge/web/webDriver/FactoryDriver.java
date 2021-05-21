package us.challenge.web.webDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * This is the Factory Driver class.
 */
public final class FactoryDriver {
    private static final Map<Browser, Supplier<IDriver>> DRIVER_MAP = new HashMap<>();

    static {
        DRIVER_MAP.put(Browser.CHROME, Chrome::new);
    }

    /**
     * Constructor to prevent instantiation.
     */
    private FactoryDriver() {
    }

    /**
     * This Factory method is going to retrieve an instance of the required WebDriver.
     *
     * @param browser is the name of the required WebDriver to use.
     * @return WebDriver instance.
     */
    public static IDriver getDriver(final String browser) {
        return DRIVER_MAP.getOrDefault(Browser.valueOf(browser.toUpperCase()), Chrome::new).get();
    }
}

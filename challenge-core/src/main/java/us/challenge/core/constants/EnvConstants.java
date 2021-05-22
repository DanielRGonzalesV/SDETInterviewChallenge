package us.challenge.core.constants;

import org.apache.log4j.Logger;
import us.challenge.core.utils.PropertiesInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * This class holds values used in testing.
 */
public final class EnvConstants {
    private static final Logger LOGGER = Logger.getLogger(EnvConstants.class.getSimpleName());
    private static final Map<String, String> CONSTANTS_MAP = new HashMap<>();

    static {
        initSLConstants();
    }

    /**
     * Private constructor that prevents instantiation of the class.
     */
    private EnvConstants() {
    }

    /**
     * This method retrieves a value for a key.
     *
     * @param key to get
     * @return the value of a key
     */
    public static String get(final String key) {
        if (CONSTANTS_MAP.size() == 0) {
            initSLConstants();
        }
        return CONSTANTS_MAP.get(key);
    }

    /**
     * This method adds the constants values to the map.
     */
    private static void initSLConstants() {
        CONSTANTS_MAP.put("actualPhone", PropertiesInfo.getInstance().actualPhone());
        CONSTANTS_MAP.put("AdminUserEmail", PropertiesInfo.getInstance().getEmail());
    }

    /**
     * This method adds new constant value to the map.
     *
     * @param key   of the constant
     * @param value of the constant
     */
    public static void set(final String key, final String value) {
        LOGGER.info(String.format("New entry: [%s, %s]", key, value));
        CONSTANTS_MAP.put(key, value);
    }
}

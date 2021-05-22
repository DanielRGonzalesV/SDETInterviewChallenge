package us.challenge.core.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is going to handle all the properties that are set on the gradle.properties file.
 */
public final class PropertiesInfo {
    private static final String CONFIG_PROPERTIES = PathUtils.buildPath("gradle.properties");
    private static final String URL = "url";
    private static final String BROWSER = "browser";
    private static final String EMAIL = "email";
    private static final String ACTUAL_PHONE = "actualPhone";
    private static final String BASE_API = "urlApi";
    private static final String PASSWORD = "password";

    private static PropertiesInfo instance;
    private Properties properties;

    /**
     * Constructor method.
     */
    private PropertiesInfo() {
        loadProperties();
    }

    /**
     * This method is going to retrieve just one instance of the PropertiesInfo class.
     *
     * @return PropertiesInfo instance.
     */
    public static PropertiesInfo getInstance() {
        if (instance == null) {
            instance = new PropertiesInfo();
        }
        return instance;
    }

    /**
     * Method to load properties with general and particular information from properties files.
     */
    private void loadProperties() {
        try {
            FileInputStream generalProperties = readProperties(CONFIG_PROPERTIES);
            properties = new Properties();
            properties.load(generalProperties);
        } catch (IOException e) {
            throw new ClassCastException("A problem of type \n" + e.getMessage());
        }
    }

    /**
     * This method is going to read properties file.
     *
     * @param file path to read properties File.
     * @return new file Input Stream.
     */
    private FileInputStream readProperties(final String file) {
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("The properties file couldn't be found \n" + e.getMessage());
        }
    }

    /**
     * This method is going to retrieve the required property.
     *
     * @param propertyKey to be used.
     * @return value of the propertyKey.
     */
    private String getProperty(final String propertyKey) {
        String propertyValue = System.getProperty(propertyKey);
        if (propertyValue == null) {
            propertyValue = properties.getProperty(propertyKey);
        }
        return propertyValue;
    }

    /**
     * This method retrieves the name of the WebBrowser to be used.
     *
     * @return the name of the WebBrowser.
     */
    public String getBrowser() {
        return getProperty(BROWSER);
    }

    /**
     * This method gets email.
     *
     * @return email.
     */
    public String getEmail() {
        return getProperty(EMAIL);
    }

    /**
     * This method get api email.
     *
     * @return api email.
     */
    public String actualPhone() {
        return getProperty(ACTUAL_PHONE);
    }

    /**
     * This method get base api.
     *
     * @return base api.
     */
    public String getBaseApi() {
        return getProperty(BASE_API);
    }


    /**
     * This method retrieves the URL of the WebApplication to be used.
     *
     * @return the url of the WebApplication.
     */
    public String getUrl() {
        return getProperty(URL);
    }

    /**
     * This method retrieves the Password to use for Employees
     *
     * @return the employees password.
     */
    public String getPassword() {
        return getProperty(PASSWORD);
    }
}

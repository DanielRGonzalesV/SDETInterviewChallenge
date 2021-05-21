package us.challenge.api.client;

import io.restassured.response.Response;
import org.apache.log4j.Logger;

/**
 * This class manages rest requests.
 */
public final class RequestManager {
    private static final Logger LOGGER = Logger.getLogger(RequestManager.class.getSimpleName());
    private static RequestManager requestManager = null;
    private static RequestHandler requestHandler = null;

    /**
     * This constructor prevents instantiation.
     */
    private RequestManager() {
    }

    /**
     * This is a singleton method that retrieves RequestManager instance.
     *
     * @return RequestManager instance.
     */
    public static RequestManager getInstance() {
        if (requestManager == null) {
            requestManager = new RequestManager();
        }
        return requestManager;
    }

    /**
     * This method performs get request.
     *
     * @param endpoint url.
     * @return request response.
     */
    public Response sendGet(final String endpoint) {
        RequestHandler.setHeader("Content-Type", "application/json");
        Response response = RequestHandler.getRequest(endpoint);
        if (response.statusCode() != 200) {
            LOGGER.error("Failed to GET request: " + endpoint + " Status Code " + response.statusCode()
                    + " Body " + response.getBody().asString());
        }
        return response;
//        LOGGER.info("Response login API status Code: " + response.statusCode());
//        LOGGER.info("Response login API as String: " + response.asString());
    }
}

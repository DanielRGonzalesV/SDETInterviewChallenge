package us.challenge.api.services;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import us.challenge.api.client.RequestManager;
import us.challenge.core.constants.EnvConstants;
import us.challenge.core.utils.PropertiesInfo;


import java.util.List;
import java.util.Map;

/**
 * This class handles users crud.
 */
public final class UsersService {
    private static final Logger LOGGER = Logger.getLogger(UsersService.class.getSimpleName());
    private static final String BASE_API = PropertiesInfo.getInstance().getBaseApi();
    private static String getUsersEndpoint = BASE_API.concat("/employees");

    private static RequestManager requestManager = RequestManager.getInstance();

    /**
     * Constructor to prevent initialization.
     */
    private UsersService() {
    }

    /**
     * This method gets a specific employee.
     *
     * @param index to search employee.
     * @return employee Name.
     */
    public static String getEmployeeNameByIndex(final String index){
        Response response = requestManager.sendGet(getUsersEndpoint.concat(String.format("/%s", index)));
        LOGGER.info("Employee found:\n".concat(response.getBody().asString()));
        ResponseBody body = response.getBody();
        Map<String, String> data = body.jsonPath().get("data");
        LOGGER.info("Data body response: " + data);
        String employeeName = data.get("employee_name");
        EnvConstants.set("employee".concat(index), employeeName);
        return employeeName;
    }
}

package us.challenge.web.utils;

import us.challenge.api.services.UsersService;
import us.challenge.core.constants.EnvConstants;
import us.challenge.core.utils.PropertiesInfo;

/**
 * This class is going to handle constants to be used on the automation framework.
 */
public final class ParseEmployeeInformation {
    public static final String FAKE_EMAIL = PropertiesInfo.getInstance().getEmail();
    public static final String PASSWORD = PropertiesInfo.getInstance().getPassword();

    /**
     * Constructor to prevent instantiation.
     */
    private ParseEmployeeInformation() {
    }

    public static void loadInformationFromApi(String indexEmployee){
        String nameEmployeeFromApi = UsersService.getEmployeeNameByIndex(indexEmployee);
        EnvConstants.set("employeeNameAPI".concat(indexEmployee), nameEmployeeFromApi);
        EnvConstants.set("employeeEmailAPI".concat(indexEmployee), nameEmployeeFromApi
                .replaceAll(" ", "").concat(FAKE_EMAIL));
        EnvConstants.set("employeePasswordAPI".concat(indexEmployee), PASSWORD);
    }
}

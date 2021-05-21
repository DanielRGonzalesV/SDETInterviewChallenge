package us.challenge.api.stepdefs;

import io.cucumber.java.en.When;
import us.challenge.api.services.UsersService;
import us.challenge.core.constants.EnvConstants;

/**
 * This class represents user api steps.
 */
public class UsersApiStepdefs {
    private String employeeName;

    @When("I get employee number {string} from api")
    public void iGetEmployeeNumberFromApi(String indexEmployee) {
        employeeName = UsersService.getEmployeeNameByIndex(indexEmployee);
    }
}

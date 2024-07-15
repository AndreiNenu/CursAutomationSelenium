package stepDefinition;

import Actions.Dashboard;
import Actions.Login;
import Actions.Register;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utile.BaseTest;
import utile.ConfigLoader;

public class CalendarSteps extends BaseTest {

    @Before
    public void beforeScenario(){
        setupClass();
        initTest("Cucumber Calendar Test");
    }

    @After
    public void afterScenario(){
        tearDown();
    }

    private Login login = null;
    private Dashboard dashboard = null;
    private Register register = null;
    private ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser.properties");
    private ConfigLoader configLoaderDate = new ConfigLoader("src/test/resources/proprietati/CalendarData.properties");




    @Given("User is logged in with email {string}, password {string} and phone number {string}")
    public void user_is_logged_in_with_email_password_and_phone_number(String email, String password, String phoneNumber) {

        login = new Login(driver);
        dashboard = new Dashboard(driver);
        register = new Register(driver);

        login(email, password);

    }
    @When("User navigates to the specific day {string}")
    public void user_navigates_to_the_specific_day(String date) {

        dashboard.clickSpecificDay(date);

    }
    @And("User creates a new event {string}")
    public void user_creates_a_new_event(String eventText) {

        dashboard.sendEventText(eventText);

        dashboard.clickCreateEventButton();

    }
    @Then("The event {string} is present in the calendar")
    public void the_event_is_present_in_the_calendar(String eventText) {

        Assert.assertTrue(dashboard.isEventPresent(eventText), "Event text is not the same!");

    }

    public void login(String email, String password) {
        loginActions(email, password);
        if(login.errorForbiddenAccessText()){
            login.clickRegisterButton();
            register.registerUser(true);

            loginActions(email, password);
        }

        Assert.assertTrue(dashboard.getUserEmailFromDashboard().equalsIgnoreCase(email));

    }

    private void loginActions(String email, String password) {
        login.enterUsername(email);
        login.enterPassword(password);
        login.clickSubmitButton();
    }
}

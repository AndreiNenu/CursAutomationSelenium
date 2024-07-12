package tests;

import Actions.Dashboard;
import Actions.Login;
import Actions.Register;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

public class CalendarTest extends BaseTest {

    private Login login = null;
    private Dashboard dashboard = null;
    private Register register = null;
    private ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser.properties");
    private ConfigLoader configLoaderDate = new ConfigLoader("src/test/resources/proprietati/CalendarData.properties");


    @Test
    public void openDashboard(){

        initTest("Training program");
        login = new Login(driver);
        dashboard = new Dashboard(driver);
        register = new Register(driver);
        String eventText = configLoaderDate.getProperty("eventText");
        String date = configLoaderDate.getProperty("date");

        login();

        dashboard.clickSpecificDay(date);

        dashboard.sendEventText(eventText);

        dashboard.clickCreateEventButton();

        Assert.assertTrue(dashboard.isEventPresent(eventText));

    }

    public void login() {

        String email = configLoader.getProperty("email");
        String password = configLoader.getProperty("password");

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

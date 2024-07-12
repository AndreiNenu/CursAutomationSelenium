package tests;

import Actions.Dashboard;
import Actions.Login;
import Actions.Register;
import Actions.Training;
import WebElements.TrainingElements;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

public class TrainingProgram extends BaseTest {

    private Login login = null;
    private Dashboard dashboard = null;
    private Register register = null;
    private ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser.properties");
    private ConfigLoader configLoaderCalendar = new ConfigLoader("src/test/resources/proprietati/CalendarData.properties");


    @Test
    public void openTrainingTab(){

        initTest("Training program");
        login = new Login(driver);
        dashboard = new Dashboard(driver);
        Training training = new Training(driver);
        register = new Register(driver);

        login();

        dashboard.clickTrainingButton();

        training.clickGenerateProgramButton();

        training.dragAndDropTrainingProgram(configLoaderCalendar.getProperty("weekDay"),
                configLoaderCalendar.getProperty("trainingProgram"));

        Assert.assertTrue(training.trainingProgramOnWeekday(configLoaderCalendar.getProperty("weekDay"), "legs").
                equalsIgnoreCase("legs"));
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

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
    private RegisterUser registerUser = null;
    private Training training;
    private Register register = null;
    private ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser.properties");

    @BeforeTest
    public void setup(){


    }

    @Test
    public void openTrainingTab(){

        initTest("Training program");
        login = new Login(driver);
        dashboard = new Dashboard(driver);
        training = new Training(driver);
        registerUser = new RegisterUser();
        register = new Register(driver);

        login();

        dashboard.clickTrainingButton();

        training.clickGenerateProgramButton();

        training.dragAndDropTrainingProgram(configLoader.getProperty("weekDay"),
                configLoader.getProperty("trainingProgram"));

        Assert.assertTrue(training.trainingProgramOnWeekday(configLoader.getProperty("weekDay"), "legs").
                equalsIgnoreCase("legs"));
    }

    private void login() {

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

package tests;

import Actions.Dashboard;
import Actions.Login;
import Actions.Register;
import Actions.Training;
import WebElements.TrainingElements;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

public class TrainingProgram extends BaseTest {

    private Login login = null;
    private Dashboard dashboard = null;
    private RegisterUser registerUser = null;
    private Training training;
    private ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser.properties");

    @Test
    public void openTrainingTab(){

        initTest("Training program");
        login = new Login(driver);
        dashboard = new Dashboard(driver);
        training = new Training(driver);
        registerUser = new RegisterUser();

        login();
    }

    private void login() {

        String email = configLoader.getProperty("email");
        String password = configLoader.getProperty("password");

        login.enterUsername(email);
        login.enterPassword(password);
        login.clickSubmitButton();

        dashboard.clickTrainingButton();

        training.clickGenerateProgramButton();

    }
}

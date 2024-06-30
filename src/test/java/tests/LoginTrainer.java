package tests;

import Actions.Dashboard;
import Actions.Login;
import Actions.Register;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

import java.time.Duration;

public class LoginTrainer extends BaseTest {

    private Login login = null;
    private Dashboard dashboard = null;
    private Register register = null;
    private ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser.properties");

    @Test
    public void loginTrainer(){

        initTest("Login trainer");
        login = new Login(driver);
        dashboard = new Dashboard(driver);

        String email = configLoader.getProperty("email");
        String password = configLoader.getProperty("password");

        login.enterUsername(email);
        login.enterPassword(password);
        login.clickSubmitButton();

        if(login.errorForbiddenAccessText()){
            login.clickRegisterButton();
            register.registerUser(false);
        }

        Assert.assertTrue(dashboard.getUserEmailFromDashboard().equalsIgnoreCase(email));
    }
}

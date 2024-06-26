package tests;

import Actions.Dashboard;
import Actions.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;

import java.time.Duration;

public class LoginTrainer extends BaseTest {

    private Login login = null;
    private Dashboard dashboard = null;

    @Test
    public void loginTrainer(){

        initTest("Login trainer");
        login = new Login(driver);
        dashboard = new Dashboard(driver);

        login.enterUsername("andrei@andrei.com");
        login.enterPassword("1111");
        login.clickSubmitButton();

        WebDriverWait waitTime = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitTime.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='navigation__link userName']")));

        Assert.assertTrue(dashboard.getUserEmailFromDashboard().equalsIgnoreCase("andrei@andrei.com"));
    }
}

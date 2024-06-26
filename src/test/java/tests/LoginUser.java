package tests;

import Actions.Login;
import Actions.Register;
import org.testng.annotations.Test;
import utile.BaseTest;

public class LoginUser extends BaseTest {

    private Login login = null;
    private Register register = null;

    @Test
    public void loginUser(){

        initTest("Login User");

        driver.get("http://apptest.go.ro:9999/login");
        login = new Login(driver);

        login.setLoginUserEmail("andrei@andrei.com");
        login.setLoginUserPassword("1111");
        login.loginSubmitButton();


    }
}

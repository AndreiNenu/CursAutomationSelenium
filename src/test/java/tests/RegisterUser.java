package tests;

import Actions.Login;
import Actions.Register;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;

public class RegisterUser extends BaseTest {

    private Login login = null;
    private Register register = null;

    @Test
    public void registerUser(){

            initTest("Register User");

            driver.get("http://apptest.go.ro:9999/login");
            login = new Login(driver);
            register = new Register(driver);

            login.clickRegisterButton();

            Assert.assertTrue(register.getSignUpText().equalsIgnoreCase( "Sign Up"));

            register.setFirstName("Andrei");
            register.setLastName("Nenu");
            register.setPhoneNumber("072324");
            register.setEmail("andrei@andrei.com");
            register.setPassword("1111");
            register.setCity("Brasov");
            //register.customer();
            register.trainer();
            register.submit();

    }
}

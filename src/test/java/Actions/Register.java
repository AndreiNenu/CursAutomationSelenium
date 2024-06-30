package Actions;

import WebElements.RegisterElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utile.ConfigLoader;

import java.time.Duration;

public class Register {

    private RegisterElements elements = null;
    private Wait<WebDriver> wait;
    private ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser.properties");

    public Register(WebDriver driver){
        elements = new RegisterElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getSignUpText(){
        return elements.signUpText().getText();
    }

    public void setFirstName(String firstname){
        elements.firstName().sendKeys(firstname);
    }

    public void setLastName(String lastname){
        elements.lastName().sendKeys(lastname);
    }

    public void setPhoneNumber(String phoneNumber){
        elements.phoneNumber().sendKeys(phoneNumber);
    }

    public void setEmail(String email){
        elements.email().sendKeys(email);
    }

    public void setPassword(String password){
        elements.password().sendKeys(password);
    }

    public void setCity(String city){
        elements.city().sendKeys(city);
    }

    public void customer(){
        elements.customer().click();
    }

    public void trainer(){
        elements.trainer().click();;
    }

    public void clickSubmitButton(){
        elements.submit().click();
    }

    public void registerUser(boolean isTrainer){

        String firstName = configLoader.getProperty("firstName");
        String lastName = configLoader.getProperty("lastName");
        String phoneNumber = configLoader.getProperty("phoneNumber");
        String email = configLoader.getProperty("email");
        String password = configLoader.getProperty("password");
        String city = configLoader.getProperty("city");

        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setEmail(email); //andrei@andrei.com //andre1@andrei.com - works
        setPassword(password); //1111 - works
        setCity(city);
        if(isTrainer){
            trainer();
        }else{
            customer();
        }
        clickSubmitButton();
    }
}

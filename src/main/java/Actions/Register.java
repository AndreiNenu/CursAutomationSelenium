package Actions;

import WebElements.RegisterElements;
import org.openqa.selenium.WebDriver;

public class Register {

    private RegisterElements elements = null;

    public Register(WebDriver driver){
        elements = new RegisterElements(driver);
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
        setFirstName("Andrei");
        setLastName("Nenu");
        setPhoneNumber("07212345");
        setEmail("andrei2@andrei.com"); //andrei@andrei.com //andre1@andrei.com - works
        setPassword("1111"); //1111 - works
        setCity("Brasov");
        if(isTrainer){
            trainer();
        }else{
            customer();
        }
        clickSubmitButton();
    }
}

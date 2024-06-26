package Actions;

import WebElements.LoginElements;
import org.openqa.selenium.WebDriver;

public class Login {

    private LoginElements elements;

    public Login(WebDriver driver){
        this.elements = new LoginElements(driver);
    }

    public void clickRegisterButton(){
        elements.registerButton().click();
    }

    public void setLoginUserEmail (String userEmail){
        elements.userEmail().sendKeys(userEmail);
    }

    public void setLoginUserPassword(String userPassword){
        elements.userPassword().sendKeys(userPassword);
    }

    public void loginSubmitButton(){
        elements.submitButton().click();
    }

}

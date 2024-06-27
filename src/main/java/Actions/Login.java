package Actions;

import WebElements.LoginElements;
import org.openqa.selenium.WebDriver;

public class Login {

    private LoginElements element;

    public Login(WebDriver driver){
        this.element = new LoginElements(driver);
    }

    public void clickRegisterButton(){
        element.registerButton().click();
    }

    public void enterUsername(String userEmail){
        element.userEmail().sendKeys(userEmail);
    }

    public void enterPassword(String userPassword){
        element.userPassword().sendKeys(userPassword);
    }

    public void clickSubmitButton(){
        element.submitButton().click();
    }

    public String errorForbiddenAccessText(){
        return element.errorForbiddenAccess().getText();
    }

}

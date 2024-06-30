package Actions;

import WebElements.SimpleElements;
import org.openqa.selenium.WebDriver;

public class SimpleActions {

    private SimpleElements element;

    public SimpleActions(WebDriver driver){
        this.element = new SimpleElements(driver);
    }

    public String getLoginText(){
        return element.loginText().getText();
    }


}

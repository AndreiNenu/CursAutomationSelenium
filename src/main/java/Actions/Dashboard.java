package Actions;

import WebElements.DashboardElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dashboard {

    private DashboardElements elements = null;

    public Dashboard(WebDriver driver ){
        elements = new DashboardElements(driver);
    }

    public String getUserEmailFromDashboard(){
        return elements.userNameDisplay().getText();
    }

    public WebElement getWebElement(){
        return elements.userNameDisplay();
    }

}

package Actions;

import WebElements.DashboardElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Dashboard {

    private DashboardElements elements = null;
    private Wait<WebDriver> wait;
    private Actions builder;

    public Dashboard(WebDriver driver ){
        elements = new DashboardElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        builder = new Actions(driver);
    }

    public String getUserEmailFromDashboard(){
        wait.until(d -> elements.userNameDisplay().isDisplayed());
        return elements.userNameDisplay().getText();
    }

    public void clickTrainingButton(){
        wait.until(d -> elements.trainingButton().isDisplayed());
        elements.trainingButton().click();
    }

    public void clickSpecificDay(String date){
        wait.until(d -> elements.calendarDays().get(10).isDisplayed());
        for(WebElement element:elements.calendarDays()){
            if(element.getAttribute("data-date").equals(date)){
                int height = element.getSize().getHeight();
                System.out.println(height);
                Action clickPrecise = builder.moveToElement(element).moveByOffset(0, height-2).click().build();
                clickPrecise.perform();
                //element.click();
            }
        }
    }

    public void sendEventText(String eventText){
        wait.until(d -> elements.eventTitle().isDisplayed());
        elements.eventTitle().sendKeys(eventText);
    }

    public void clickCreateEventButton(){
        elements.createEventButton().click();
    }

    public boolean isEventPresent(String event){
        for(WebElement element:elements.events()){
            if(element.getText().equalsIgnoreCase(event)){
                return true;
            }
        }
        return false;
    }
}

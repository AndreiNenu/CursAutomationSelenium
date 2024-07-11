package Actions;

import WebElements.TrainingElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Training {

    private TrainingElements elements = null;
    private Wait<WebDriver> wait;
    private Actions builder;

    public Training(WebDriver driver ){
        elements = new TrainingElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        builder = new Actions(driver);
    }

    public void clickGenerateProgramButton(){
        wait.until(d -> elements.generateProgram().isDisplayed());
        elements.generateProgram().click();
    }

    public void dragAndDropTrainingProgram(String dayNumber, String trainingProgram){
        wait.until(d -> elements.trainingPrograms().get(0).isDisplayed());
        Action dragAndDrop = builder.clickAndHold(getTrainingProgram(trainingProgram))
            .moveToElement(elements.weekDay(dayNumber))
            .release(elements.weekDay(dayNumber))
            .build();

         dragAndDrop.perform();
    }

    private WebElement getTrainingProgram(String trainingProgram){
        wait.until(d -> elements.trainingPrograms().get(0).isDisplayed());
        WebElement element2 = null;
        for(WebElement element: elements.trainingPrograms()){
            if(element.getText().equalsIgnoreCase(trainingProgram)){
                element2 = element;
            }
        }
        return element2;
    }

}

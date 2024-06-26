package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterElements {

    private WebDriver driver;

    public RegisterElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement signUpText(){
        return driver.findElement(By.xpath("//h2"));
    }

    public WebElement firstName(){
        return driver.findElement(By.id("firstName"));
    }

    public WebElement lastName(){
        return driver.findElement(By.id("lastName"));
    }

    public WebElement phoneNumber(){
        return  driver.findElement(By.cssSelector("#phoneNumber"));
    }

    public WebElement email(){
        return  driver.findElement(By.cssSelector("#email"));
    }

    public WebElement password(){
        return  driver.findElement(By.cssSelector("#password"));
    }

    public WebElement city(){
        return  driver.findElement(By.cssSelector("#city"));
    }

    public WebElement customer(){
        return  driver.findElement(By.cssSelector("#customer"));
    }

    public WebElement trainer(){
        return  driver.findElement(By.cssSelector("#trainer"));
    }

    public WebElement submit(){
        return  driver.findElement(By.cssSelector("#submit"));
    }

}

package utile;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    private WebDriver driver;
    private ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/applicationsURLs.properties");

    public ScreenshotUtils(WebDriver driverFromBaseTestClass){
        this.driver = driverFromBaseTestClass;
    }

    public void captureAndSaveScreenshots(String testName){

        try {
            String dateFormat = configLoader.getProperty("dateFormat");
            String screenshotDirectory = configLoader.getProperty("screenshotDirectory");
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timeStamp = new SimpleDateFormat(dateFormat).format(new Date());
            String screenshotName = testName + "_" + timeStamp + ".png";
            //String screenshotDirectory = "Screenshots";

            File targetFile = new File(screenshotDirectory, screenshotName);
            FileUtils.copyFile(screenshotFile, targetFile);

            System.out.println("Screenshot saved to: " + targetFile.getAbsolutePath());
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
}

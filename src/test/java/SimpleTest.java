import Actions.SimpleActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;

public class SimpleTest extends BaseTest {

    @Test
    public void firstTest(){

        initTest("Simple test");

        String expectedText = "Login";

        SimpleActions simpleActions = new SimpleActions(driver);
        String loginText = simpleActions.getLoginText();

        //Assert.assertEquals(loginText.toLowerCase(), expectedText.toLowerCase());
        Assert.assertTrue(loginText.equalsIgnoreCase(expectedText));

        System.out.println("Actual text: " + loginText);
        System.out.println("Expected text: " + expectedText);
    }
}

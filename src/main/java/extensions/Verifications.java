package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class Verifications extends CommonOps {

    @Step("Verify display of an element")
    public static void isDisplayed(WebElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertTrue(elem.isDisplayed());
    }

    @Step("Verify if element is displayed")
    public static void isExists(List <AndroidElement> elem, int expected){
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        assertTrue(elem.size() == expected);
    }

    @Step("Verify text in element")
    public static void verifyTextInElement(WebElement elem, String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);
    }


    @Step("Verify number of elements")
    public static void numberOfElements(List<WebElement>elems,int expected){
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        assertEquals(elems.size(), expected);
    }

    @Step("Verify visibility of elements using soft assertion")
    public static void visibilityOfElements(List<WebElement> elems){
        wait.until(ExpectedConditions.visibilityOfAllElements(elems));
        for(WebElement iterate : elems){
            softAssert.assertTrue(iterate.isDisplayed());
        }
        softAssert.assertAll("It seems like some elements were not displayed :(");

    }

    @Step("Verify double vs. double")
    public static void verifyDoubleEquals(double total, double expected){
        assertEquals(total,expected);
    }

    @Step("Verify element visually")
    public static void visualElement(String expectedImgName) throws FindFailed {
        try {
            Thread.sleep(15000);
            screen.find(getData("ImageRepo") + expectedImgName + ".png");
        }
        catch (FindFailed | InterruptedException findFailed){
            System.out.println("Error comparing image file: " + findFailed);
            fail("Error comparing image file: " + findFailed);
        }
    }

    @Step("Verify String vs. String")
    public static void verifyText(String actual, String expected){
        assertEquals(actual, expected);
    }

    @Step("Verify int vs. int")
    public static void verifyNumber (int actual, int expected){
        assertEquals(actual,expected);
    }





}


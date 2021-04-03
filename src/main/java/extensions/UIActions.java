package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

public class UIActions extends CommonOps {

    @Step("Click on element")
    public static void click(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Clear fields")
    public static void clear(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.clear();
    }


    @Step("Update text element")
    public static void updateText(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("Insert Key")
    public static void insertKey(WebElement elem, Keys value){
        //wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(value);
    }


    @Step("Update Drop-Down element")
    public static void updateDropDown(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        sort = new Select(elem);
        sort.selectByVisibleText(text);
    }

    @Step("Update Mouse Hover element")
    public static void mouseHover(WebElement elem) {
        action.moveToElement(elem).click().build().perform();
    }

/*
###########################################################################
Method name : convertToDouble
Method description : This method converts WebElement containing the text of price number + dollar sign '$' into double
using split method to separate between the two
Method parameters : WebElement
Method return : double
###########################################################################
*/

    @Step("Converts element to double")
    public static double convertToDouble(WebElement elem){
        String[] array = elem.getText().split("\\$");
        String price = array[1];
        double priceNumber = Double.parseDouble(price);
        return priceNumber;
    }

/*
###########################################################################
Method name : total
Method description : This method returns the total value of two WebElements converted to doubles using
 convertToDouble method above.
the method calls DecimalFormat class's method 'format' which formats double into string according to pattern
defined in commonOps class. ("###.##")

Also, the method uses Double.valueOf(string) method which returns a Double
object holding the value represented by the String argument created by 'format'.
Method parameters : Two WebElements
Method return : double
###########################################################################
*/

    @Step("sums price of items including tax")
    public static double total(WebElement itemTotal, WebElement tax)
    {
        return Double.valueOf(df2.format(convertToDouble(itemTotal) + convertToDouble(tax) ) );
    }

    @Step("get price of items including tax")
    public static double getTotalPrice(){
        return UIActions.total(swagLabsOverview.getNum_itemTotal(), swagLabsOverview.getNum_tax());
    }
}

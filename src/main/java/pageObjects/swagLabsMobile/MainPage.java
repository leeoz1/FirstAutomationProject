package pageObjects.swagLabsMobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class MainPage {

    private AppiumDriver mobileDriver;

    public MainPage(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, 3, TimeUnit.SECONDS),this);
    }

    @AndroidFindBy(xpath = "//*[@text='ADD TO CART' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@text='Sauce Labs Backpack']]]")
    private AndroidElement btn_add;

    @AndroidFindBy(xpath = "//*[@text='Sauce Labs Backpack']")
    private AndroidElement txt_item;

    @AndroidFindBy(xpath = "//*[@text='$29.99']")
    private AndroidElement txt_price;

    @AndroidFindBy(xpath = "//*[@text='PRODUCTS']")
    private AndroidElement txt_header;

/*
Getters:
==============================================
*/

    public AndroidElement getBtn_add()
    {
        return btn_add;
    }

    public AndroidElement getTxt_item()
    {
        return txt_item;
    }

    public AndroidElement getTxt_price()
    {
        return txt_price;
    }

    public AndroidElement getTxt_header()
    {
        return txt_header;
    }

}

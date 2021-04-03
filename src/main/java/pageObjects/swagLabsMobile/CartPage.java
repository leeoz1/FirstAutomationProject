package pageObjects.swagLabsMobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class CartPage {

    private AppiumDriver mobileDriver;

    public CartPage(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, 3, TimeUnit.SECONDS),this);
    }

    @AndroidFindBy(xpath = "//*[@text='Sauce Labs Backpack']")
    private AndroidElement txt_product;

    @AndroidFindBy(xpath = "//*[@text='REMOVE']")
    private AndroidElement btn_remove;

    @AndroidFindBy(xpath = "//*[@text='CONTINUE SHOPPING']")
    private AndroidElement btn_continue;

    @AndroidFindBy(xpath = "//*[@text='󰩺']")
    private AndroidElement icon_remove;

/*
Getters:
==============================================
*/

    public AndroidElement getTxt_product()
    {
        return txt_product;
    }

    public AndroidElement getBtn_remove()
    {
        return btn_remove;
    }

    public AndroidElement getBtn_continue()
    {
        return btn_continue;
    }

    public AndroidElement getIcon_remove()
    {
        return icon_remove;
    }
}

package pageObjects.swagLabsMobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ProductPage {

    private AppiumDriver mobileDriver;

    public ProductPage(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, 3, TimeUnit.SECONDS),this);
    }

    @AndroidFindBy(xpath = "//*[@text='REMOVE']")
    private AndroidElement btn_remove;

    @AndroidFindBy(xpath = "//*[@text='BACK TO PRODUCTS']")
    private AndroidElement btn_back;

    @AndroidFindBy(xpath = "//*[@text='ADD TO CART']")
    private AndroidElement btn_AddItem;

/*
Getters:
==============================================
*/

    public AndroidElement getBtn_remove()
    {
        return btn_remove;
    }

    public AndroidElement getBtn_back()
    {
        return btn_back;
    }

    public AndroidElement getBtn_AddItem()
    {
        return btn_AddItem;
    }
}

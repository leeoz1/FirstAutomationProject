package pageObjects.swagLabsMobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class MenuPage {

    private AppiumDriver mobileDriver;

    public MenuPage(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, 3, TimeUnit.SECONDS),this);
    }

    @AndroidFindBy(xpath = "//*[@class='android.view.ViewGroup' and ./parent::*[@contentDescription='test-Menu']]")
    private AndroidElement btn_menu;

    @AndroidFindBy(xpath = "//*[@class='android.view.ViewGroup' and ./parent::*[@contentDescription='test-Cart']]")
    private AndroidElement btn_cart;

    @AndroidFindBy(xpath = "//*[@text='1']")
    private List<AndroidElement> badge_notification;

/*
Getters:
==============================================
*/

    public AndroidElement getBtn_menu()
    {
        return btn_menu;
    }

    public AndroidElement getBtn_cart()
    {
        return btn_cart;
    }

    public List<AndroidElement> getBadge_notification()
    {
        return badge_notification;
    }
}

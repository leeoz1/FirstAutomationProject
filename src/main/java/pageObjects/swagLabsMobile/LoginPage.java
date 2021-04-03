package pageObjects.swagLabsMobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class LoginPage {

    private AppiumDriver mobileDriver;

    public LoginPage(AppiumDriver mobileDriver){
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, 3, TimeUnit.SECONDS),this);
    }

    @AndroidFindBy(xpath = "//*[@text='Username']")
    private AndroidElement txt_username;

    @AndroidFindBy(xpath = "//*[@text='Password']")
    private AndroidElement txt_password;

    @AndroidFindBy(xpath = "//*[@contentDescription='test-LOGIN']")
    private AndroidElement btn_login;

/*
Getters:
==============================================
*/

    public AndroidElement getTxt_username()
    {
        return txt_username;
    }

    public AndroidElement getTxt_password()
    {
        return txt_password;
    }

    public AndroidElement getBtn_login()
    {
        return btn_login;
    }
}


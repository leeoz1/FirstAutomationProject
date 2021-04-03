package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.swagLabsWeb.*;

public class ManagePages extends Base{
    //Web - Initiate page objects
    public static void initSwagLabs(){
        swagLabsLogin = PageFactory.initElements (driver, LoginPage.class);
        swagLabsMain = PageFactory.initElements(driver, MainPage.class);
        swagLabsMenu = PageFactory.initElements(driver, MenuPage.class);
        swagLabsCart = PageFactory.initElements(driver, CartPage.class);
        swagLabsCheckout = PageFactory.initElements(driver, CheckoutPage.class);
        swagLabsOverview = PageFactory.initElements(driver, OverviewPage.class);
        swagLabsFinish = PageFactory.initElements(driver, FinishOrderPage.class);
    }

    //Mobile - Initiate page objects
    public static void initSwagLabsMobile(){

        swagLabsMobileCart = new pageObjects.swagLabsMobile.CartPage(mobileDriver);
        swagLabsMobileLogin = new pageObjects.swagLabsMobile.LoginPage(mobileDriver);
        swagLabsMobileMain = new pageObjects.swagLabsMobile.MainPage(mobileDriver);
        swagLabsMobileMenu = new pageObjects.swagLabsMobile.MenuPage(mobileDriver);
        swagLabsMobileProduct = new pageObjects.swagLabsMobile.ProductPage(mobileDriver);
    }

    //Electron - Initiate page objects
    public static void initTodo(){
        todoMain = PageFactory.initElements (driver, pageObjects.todo.MainPage.class);

    }

}

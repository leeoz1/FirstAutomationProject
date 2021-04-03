package utilities;

import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.swagLabsWeb.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;

public class Base {

/*
Various objects used in the project
=================================
*/

    //General:
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static Select sort;
    protected static SoftAssert softAssert;
    protected static DecimalFormat df2;
    protected static Screen screen;
    protected static String platform;


    //Web:
    protected static WebDriver driver;

    //Mobile:
    protected static AppiumDriver mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();

    //Rest Assured API

    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;

    //Database

    protected static Connection con;
    protected static Statement state;
    protected static ResultSet resultSet;



    //Page objects - Web:
    protected static LoginPage swagLabsLogin;
    protected static MainPage swagLabsMain;
    protected static MenuPage swagLabsMenu;
    protected static CartPage swagLabsCart;
    protected static CheckoutPage swagLabsCheckout;
    protected static OverviewPage swagLabsOverview;
    protected static FinishOrderPage swagLabsFinish;

    //Page objects - Mobile:
    protected static pageObjects.swagLabsMobile.CartPage swagLabsMobileCart;
    protected static pageObjects.swagLabsMobile.LoginPage swagLabsMobileLogin;
    protected static pageObjects.swagLabsMobile.MainPage swagLabsMobileMain;
    protected static pageObjects.swagLabsMobile.MenuPage swagLabsMobileMenu;
    protected static pageObjects.swagLabsMobile.ProductPage swagLabsMobileProduct;

    //Page objects - Electron:
    protected static pageObjects.todo.MainPage todoMain;







}

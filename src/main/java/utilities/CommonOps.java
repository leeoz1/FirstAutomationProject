package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import workflows.ElectronFlows;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base{

/*
###########################################################################
Method name : getData
Method description : This method gets the data from xml configuration file
Method parameters : String
Method return : String
###########################################################################
*/

    public static String getData(String nodeName)
    {
            File fXmlFile;
            DocumentBuilder dBuilder;
            Document doc = null;
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            try {
                fXmlFile = new File("./Configurations/DataConfig.xml");
                dBuilder = dbFactory.newDocumentBuilder();
                doc = dBuilder.parse(fXmlFile);
                doc.getDocumentElement().normalize();
            }
            catch (Exception e) {
                System.out.println("Exception in reading XML file: " + e);
            }
            finally{
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
    }

/*
###########################################################################
Method name : initBrowser
Method description : This method initiate different drivers defined by config file (BrowserName).
    Called by startSession method when PlatformName value is 'web' according to testNG suite.
Method parameters : String
Method return : N/A

Note: this method calls for init*Driver methods e.g. initChromeDriver, initFirefoxDriver etc.
 and initiates objects relevant for browser initialization
###########################################################################
*/


    public static void initBrowser(String browserType){
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else
            throw new RuntimeException("Unsupported browser");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        driver.get(getData("url"));
        ManagePages.initSwagLabs();
        df2 = new DecimalFormat("###.##");
        action = new Actions(driver);

    }

        public static WebDriver initChromeDriver(){
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            return driver;
        }

        public static WebDriver initFirefoxDriver(){
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();
            return driver;
        }

        public static WebDriver initIEDriver(){
            WebDriverManager.iedriver().setup();
            WebDriver driver = new InternetExplorerDriver();
            return driver;
        }

/*
###########################################################################
Method name : initMobile
Method description : This method initiates android driver and the app's details defined by config file parameters
udid, AppPackage etc. and called by startSession method when PlatformName value is 'mobile'
according to config file.
Method parameters : N/A
Method return : N/A

Note: this method calls for managePages's method and includes implicitly and explicitly waits
###########################################################################
*/

    public static void initMobile(){
        dc.setCapability(MobileCapabilityType.UDID, getData("udid"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try {
            mobileDriver = new AndroidDriver(new URL(getData("AppiumServer")), dc);
        } catch (Exception e) {
            System.out.println("Couldn't connect to appium server, see details: " + e);
        }
        ManagePages.initSwagLabsMobile();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("Timeout")));
    }

/*
###########################################################################
Method name : initAPI
Method description : This method initiates rest assured objects.
Method parameters : N/A
Method return : N/A
###########################################################################
*/

    public static void initAPI(){
        RestAssured.baseURI = getData("url_api");
        httpRequest = RestAssured.given();
    }

/*
###########################################################################
Method name : initElectron
Method description : This method initiates chrome driver from path defined by config file.
Method parameters : N/A
Method return : N/A
###########################################################################
*/

    public static void initElectron(){
        System.setProperty("webdriver.chrome.driver", getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        ManagePages.initTodo();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        action = new Actions(driver);

    }


/*
###########################################################################
Method name : startSession
Method description : This method start sessions, according to data retrieved from TestNG suites and config xml files
Method parameters : String
Method return : N/A

Note: this method calls for init* methods: initBrowser, initMobile etc. and initiate objects relevant for session run
###########################################################################
*/

    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName){
        platform = PlatformName;
        if (platform.equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
            else if (platform.equalsIgnoreCase("mobile"))
                initMobile();
            else if (platform.equalsIgnoreCase("api"))
            initAPI();
        else if (platform.equalsIgnoreCase("electron"))
            initElectron();
                else
                    throw new RuntimeException("invalid platform name");

        softAssert = new SoftAssert();
        screen = new Screen();
        ManageDB.openConnection(getData("DBURL"), getData("DBUser"), getData("DBPassword"));
    }


/*
###########################################################################
Method name : closeSession
Method description : This method closing drivers of different platforms.
Method parameters : N/A
Method return : N/A
###########################################################################
*/

    @AfterClass
    public void closeSession()
    {
        ManageDB.closeConnection();
        if (!platform.equalsIgnoreCase("api")) {
            if (!platform.equalsIgnoreCase("mobile"))
                driver.quit();
            else
                mobileDriver.quit();
        }
    }

/*
###########################################################################
Method name : beforeMethod
Method description : This method start recordings of different tests from different platforms using MonteScreenRecorder.
Method parameters : Method
Method return : N/A
###########################################################################
*/

    @BeforeMethod
    public void beforeMethod(Method method){
        if (!platform.equalsIgnoreCase("api")) {
            try {
                MonteScreenRecorder.startRecord(method.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

/*
###########################################################################
Method name : afterMethod
Method description : This method calls emptyList method, recurring after every test.
Method parameters : N/A
Method return : N/A
###########################################################################
*/

    @AfterMethod
    public void AfterMethod() {
        if (platform.equalsIgnoreCase("electron")) {
            ElectronFlows.emptyList();
        }
    }
}



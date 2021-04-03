package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class swagLabsDB extends CommonOps{
    @Test(description = "test 01 - Login to swag labs via DB credentials")
    @Description("This test login the system using db and verifies the main page's header")
        public void test01_loginDBAndVerifyHeader(){
            WebFlows.loginDB();
            Verifications.verifyTextInElement(swagLabsMain.getHead_Products(),"PRODUCTS");
        }
    }

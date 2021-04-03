package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;


@Listeners(utilities.Listeners.class)
public class SwagLabsWebLogin extends CommonOps {

    

    @Test(description = "test 01 - Verify Header")
    @Description ("This test login the system and verifies the main page's header")
    public void test01_verifyHeader(){
        WebFlows.login("standard_user","secret_sauce");
        Verifications.verifyTextInElement(swagLabsMain.getHead_Products(),"PRODUCTS");
    }

    @Test(description = "test 02 - Login via different users", dataProvider = "data-provider-users", dataProviderClass = utilities.ManageDDT.class)
    @Description ("This test verifies login with different users using data driven testing")
    public void test02_VerifyMultipleLogins(String user, String pass, String isValid)  {
        driver.get("https://www.saucedemo.com/");
        WebFlows.loginDifferentUsers(user, pass, isValid);
    }
}


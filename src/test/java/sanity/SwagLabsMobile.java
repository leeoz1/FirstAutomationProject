package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;

@Listeners(utilities.Listeners.class)
public class SwagLabsMobile extends CommonOps {

        @Test(description = "test 01 - Verify Header")
        @Description("This test login the system and verifies the main page's header")
        public void test01_verifyHeader(){
            MobileFlows.login("standard_user","secret_sauce");
            Verifications.verifyTextInElement(swagLabsMobileMain.getTxt_header(),"PRODUCTS");
        }

    @Test(description = "test 02 - Verify added item")
    @Description("This test adds an item and check if it's added")
    public void test02_verifyAddedItem(){
            MobileFlows.selectItemAndAddToCart();
            Verifications.isExists(swagLabsMobileMenu.getBadge_notification(), 1);
    }

    @Test(description = "test 03 - Verify removed item")
    @Description("This test removes an item and check if it's removed")
    public void test03_verifyRemovedItem(){
        MobileFlows.removeItem();
        Verifications.isExists(swagLabsMobileMenu.getBadge_notification(), 0);
    }


}

package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.sikuli.script.FindFailed;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

public class SwagLabsWebProducts extends CommonOps {

    @BeforeClass(description = "Login")
    @Description("Login to the system")
    public void login() {
        WebFlows.login("standard_user", "secret_sauce");
    }

    @Test(description = "test 04 - Verify Number Of Items in Main page")
    @Description("This test verifies all items in the screen")
    public void test04_verifyNumberOfItems() {
        Verifications.numberOfElements(swagLabsMain.getTxt_all_items(), 6);
    }

    @Test(description = "test 05 - Verify Added item")
    @Description("This test adds an item and verify notification cart displays 1 item")
    public void test05_verifyAddedItem() {
        WebFlows.addItem();
        Verifications.verifyTextInElement(swagLabsMenu.getNotification_cart(), "1");
        WebFlows.removeItem();
    }

    @Test(description = "test 06 - Verify sorted items")
    @Description("This test sorts item from z to a and verifies the newly sorted first item's price")
    public void test06_VerifyChangeSort() {
        WebFlows.sorting();
        Verifications.verifyTextInElement(swagLabsMain.getTxt_priceFirstItem(), "$15.99");
    }

    @Test(description = "test 07 - Verify Number Of Menu Items")
    @Description("This test opens the menu button, verifies via softAssert that the menu displays 4 items and then closes menu")
    public void test07_VerifyNumberOfMenuItems() {
        WebFlows.openMenu();
        Verifications.visibilityOfElements(swagLabsMenu.getMenuItems());
        WebFlows.closeMenu();
    }

    @Test(description = "test 06 - Verify Prices")
    @Description("This test complete the order flow: adding of second item, filling customer details and verify prices of items")
    public void test06_VerifyPricesAndCompleteOrder() {
        WebFlows.addItem();
        WebFlows.sorting();
        WebFlows.addSecondItem();
        WebFlows.overviewOrderFlow("Lioz", "Elinger", "902010");
        Verifications.verifyDoubleEquals(UIActions.getTotalPrice(), UIActions.convertToDouble(swagLabsOverview.getNum_total()));
        WebFlows.finishOrder();
    }

/*
The following visual test FAILS only when running via Jenkins, due to compatible issues
with sikulix (visual testing api).
Test successes when running through Maven via Terminal/TestNG suite xml file directly from intellij.
*/

    @Test(description = "test 07 - Verify Logo")
    @Description("This test verifies the web's logo using sikulix tool and logout")
    public void test07_VerifyWebLogo() throws FindFailed {
        Verifications.visualElement("SwagLabsLogo");
    }
}

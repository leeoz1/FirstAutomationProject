package workflows;

import extensions.MobileActions;
import extensions.UIActions;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class MobileFlows extends CommonOps {

    @Step("Business flow: login standard user")
    public static void login(String user, String pass){
        MobileActions.updateText(swagLabsMobileLogin.getTxt_username(), user);
        MobileActions.updateText(swagLabsMobileLogin.getTxt_password(), pass);
        MobileActions.tap(1, swagLabsMobileLogin.getBtn_login(), 500);
    }

    @Step("Business flow: Click and add an item,")
    public static void selectItemAndAddToCart(){
        MobileActions.tap(1, swagLabsMobileMain.getTxt_price(), 500);
        //Swipe - down:
        MobileActions.swipe(540,1850,540, 850, 200);

        MobileActions.tap(1, swagLabsMobileProduct.getBtn_AddItem(), 500);
    }


    @Step("Business flow: Remove item from cart")
    public static void removeItem(){
        //Click on cart:
        MobileActions.tap(1, swagLabsMobileMenu.getBtn_cart(), 500);
        //Swipe - left:
        MobileActions.swipe(1050,1065,210,1065, 200);
        MobileActions.tap(1, swagLabsMobileCart.getIcon_remove(), 500);
    }






}

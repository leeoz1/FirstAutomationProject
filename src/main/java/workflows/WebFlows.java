package workflows;

import extensions.DBActions;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import utilities.CommonOps;

import java.util.List;

public class WebFlows extends CommonOps {

    @Step("Business flow: login standard user")
    public static void login(String user, String pass){
        UIActions.updateText(swagLabsLogin.getTxt_username(), user);
        UIActions.updateText(swagLabsLogin.getTxt_password(), pass);
        UIActions.click(swagLabsLogin.getBtn_login());
    }

    @Step("Business flow: login standard user using mysql db")
    public static void loginDB(){
        String query = "SELECT name, password FROM Users WHERE id = 3";
        List<String> cred =  DBActions.getCredentials(query);
        UIActions.updateText(swagLabsLogin.getTxt_username(), cred.get(0));
        UIActions.updateText(swagLabsLogin.getTxt_password(), cred.get(1));
        UIActions.click(swagLabsLogin.getBtn_login());
    }

        @Step("Business flow: Verify valid user")
    public static void loginDifferentUsers(String user, String pass, String shouldExists){
        UIActions.updateText(swagLabsLogin.getTxt_username(), user);
        UIActions.updateText(swagLabsLogin.getTxt_password(), pass);
        UIActions.click(swagLabsLogin.getBtn_login());

        if(shouldExists.equalsIgnoreCase("valid")){
            Verifications.isDisplayed(swagLabsMenu.getLogo());
            openMenu();
            logout();
        }
        else if(shouldExists.equalsIgnoreCase("invalid")) {
            Verifications.isDisplayed(swagLabsLogin.getLogo_login());
            driver.navigate().refresh();

        }
        else
            throw new RuntimeException(("Invalid expected output option in data driven testing, should be exists or not-exists"));

    }

    @Step("Business flow: Add item")
    public static void addItem(){
        UIActions.click(swagLabsMain.getBtn_add());
    }

    @Step("Business flow: Remove item")
    public static void removeItem(){
        UIActions.click(swagLabsMain.getBtn_remove());
    }


    @Step("Business flow: Add second item")
    public static void addSecondItem(){
        UIActions.click(swagLabsMain.getBtn_addNoTwo());
    }

    @Step("Business flow: Open menu")
    public static void openMenu() {
        UIActions.click(swagLabsMenu.getBtn_menu());
    }

    @Step("Business flow: Close menu")
    public static void closeMenu() {
        UIActions.click(swagLabsMenu.getBtn_close());
    }

    @Step("Business flow: Complete checkout")
    public static void overviewOrderFlow(String firstName, String lastName, String zipcode){
    UIActions.click(swagLabsMenu.getLink_cart());
    UIActions.click(swagLabsCart.getBtn_checkout());
    UIActions.updateText(swagLabsCheckout.getTxt_firstName(), firstName);
    UIActions.updateText(swagLabsCheckout.getTxt_lastName(), lastName);
    UIActions.updateText(swagLabsCheckout.getTxt_postalCode(), zipcode);
    UIActions.click(swagLabsCheckout.getBtn_continue());

    }

    @Step("Business flow: Order exit")
    public static void finishOrder(){
        UIActions.click(swagLabsOverview.getBtn_finish());
        UIActions.click(swagLabsMenu.getBtn_menu());
        UIActions.click(swagLabsMenu.getLink_all_items());
    }

    @Step("Business flow: Sort items")
    public static void sorting(){
        UIActions.updateDropDown(swagLabsMain.getDropdownSort(),swagLabsMain.getSort02().getText());
    }

    @Step("Business flow: Logout from the website")
    public static void logout(){
        UIActions.click(swagLabsMenu.getLink_logout());
    }


}

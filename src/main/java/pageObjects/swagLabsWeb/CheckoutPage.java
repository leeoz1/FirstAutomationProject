package pageObjects.swagLabsWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckoutPage {


    @FindBy(how = How.CLASS_NAME, using = "subheader")
    private WebElement txt_checkout;

    @FindBy(how = How.ID, using = "first-name")
    private WebElement txt_firstName;

    @FindBy(how = How.ID, using = "last-name")
    private WebElement txt_lastName;

    @FindBy(how = How.ID, using = "postal-code")
    private WebElement txt_postalCode;

    @FindBy(how = How.CSS, using = "a[class='cart_cancel_link btn_secondary']")
    private WebElement btn_cancel;

    @FindBy(how = How.ID, using = "continue")
    private WebElement btn_continue;

/*
Getters:
==============================================
*/

    public WebElement getTxt_checkout()
    {
        return txt_checkout;
    }

    public WebElement getTxt_firstName()
    {
        return txt_firstName;
    }

    public WebElement getTxt_lastName()
    {
        return txt_lastName;
    }

    public WebElement getTxt_postalCode()
    {
        return txt_postalCode;
    }

    public WebElement getBtn_cancel()
    {
        return btn_cancel;
    }

    public WebElement getBtn_continue()
    {
        return btn_continue;
    }





}

package pageObjects.swagLabsWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartPage {

    @FindBy(how = How.CLASS_NAME, using = "subheader")
    private WebElement txt_cart;


    @FindBy(how = How.CLASS_NAME, using = "cart_quantity_label")
    private WebElement txt_quantity;

    @FindBy(how = How.CLASS_NAME, using = "cart_desc_label")
    private WebElement txt_description;

    @FindBy(how = How.LINK_TEXT, using = "Continue Shopping")
    private WebElement btn_continue;

    @FindBy(how = How.ID, using = "checkout")
    private WebElement btn_checkout;

/*
Getters:
==============================================
*/

    public WebElement getTxt_cart()
    {
        return txt_cart;
    }

    public WebElement getTxt_quantity()
    {
        return txt_quantity;
    }

    public WebElement getTxt_description()
    {
        return txt_description;
    }

    public WebElement getBtn_continue()
    {
        return btn_continue;
    }

    public WebElement getBtn_checkout()
    {
        return btn_checkout;
    }



}


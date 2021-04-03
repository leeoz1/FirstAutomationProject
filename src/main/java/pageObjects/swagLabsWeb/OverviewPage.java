package pageObjects.swagLabsWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OverviewPage {
    @FindBy(how = How.XPATH, using = "subheader")
    private WebElement txt_overview;

    @FindBy(how = How.XPATH, using = "//div[@class='summary_info']/div[1]")
    private WebElement txt_paymentInfoTitle;

    @FindBy(how = How.XPATH, using = "//div[@class='summary_info']/div[2]")
    private WebElement txt_cardNumber;

    @FindBy(how = How.XPATH, using = "//div[@class='summary_info']/div[3]")
    private WebElement txt_shippingInfoTitle;

    @FindBy(how = How.XPATH, using = "//div[@class='summary_info']/div[4]")
    private WebElement txt_shippingInfo;

    @FindBy(how = How.XPATH, using = "//div[@class='summary_subtotal_label']")
    private WebElement num_itemTotal;


    @FindBy(how = How.XPATH, using = "//div[@class='summary_tax_label']")
    private WebElement num_tax;

    @FindBy(how = How.XPATH, using = "//div[@class='summary_total_label']")
    private WebElement num_total;

    @FindBy(how = How.CSS, using = "a[class='cart_cancel_link btn_secondary']")
    private WebElement btn_cancel;

    @FindBy(how = How.ID, using = "finish")
    private WebElement btn_finish;

/*
Getters:
==============================================
*/

    public WebElement getTxt_overview()
    {
        return txt_overview;
    }

    public WebElement getTxt_paymentInfoTitle()
    {
        return txt_paymentInfoTitle;
    }

    public WebElement getTxt_cardNumber()
    {
        return txt_cardNumber;
    }

    public WebElement getTxt_shippingInfoTitle()
    {
        return txt_shippingInfoTitle;
    }

    public WebElement getTxt_shippingInfo()
    {
        return txt_shippingInfo;
    }

    public WebElement getNum_itemTotal()
    {
        return num_itemTotal;
    }

    public WebElement getNum_tax()
    {
        return num_tax;
    }

    public WebElement getNum_total()
    {
        return num_total;
    }

    public WebElement getBtn_cancel()
    {
        return btn_cancel;
    }

    public WebElement getBtn_finish()
    {
        return btn_finish;
    }
}

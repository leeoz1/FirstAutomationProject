package pageObjects.swagLabsWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



import java.util.List;

public class MainPage
{
    @FindBy(how = How.CLASS_NAME, using = "title")
    private WebElement head_Products;


    @FindBy(how = How.CLASS_NAME, using = "product_sort_container")
    private  WebElement dropdownSort;


    @FindBy(how = How.CSS, using = "option[value=za]")
    private WebElement sort02;
    

    @FindBy(how = How.XPATH, using = "//div[@class='inventory_item_price']")
    private WebElement txt_priceFirstItem;


    @FindBy(how = How.XPATH, using = "//div[@id='inventory_container']/div/div[2]/div/div[2]/div[@class='pricebar']/div")
    private WebElement txt_priceSecondItem;

    //Add to cart:
    @FindBy(how = How.XPATH, using = "//button[@class='btn btn_primary btn_small btn_inventory']")
    private WebElement btn_add;

    //Add to card 2nd item
    @FindBy(how = How.ID, using = "add-to-cart-sauce-labs-bike-light")
    private WebElement btn_addNoTwo;


    //All add to cart
    @FindBy(how = How.CLASS_NAME, using = "inventory_item")
    private List<WebElement> txt_all_items;

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn_secondary btn_small btn_inventory']")
    private WebElement btn_remove;

    @FindBy(how = How.XPATH, using = "//div[@class='inventory_item_name']")
    private WebElement txt_product_name;

/*
Getters:
==============================================
*/

    public WebElement getHead_Products()
    {
        return head_Products;
    }

    public WebElement getDropdownSort()
    {
        return dropdownSort;
    }

    public WebElement getSort02()
    {
        return sort02;
    }

    public WebElement getTxt_priceFirstItem()
    {
        return txt_priceFirstItem;
    }

    public WebElement getTxt_priceSecondItem()
    {
        return txt_priceSecondItem;
    }

    public WebElement getBtn_add()
    {
        return btn_add;
    }

    public WebElement getBtn_addNoTwo()
    {
        return btn_addNoTwo;
    }

    public List<WebElement> getTxt_all_items()
    {
        return txt_all_items;
    }

    public WebElement getBtn_remove()
    {
        return btn_remove;
    }

    public WebElement getTxt_product_name()
    {
        return txt_product_name;
    }
}




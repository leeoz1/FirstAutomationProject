package pageObjects.swagLabsWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

public class MenuPage {
    @FindBy(how = How.CLASS_NAME, using = "app_logo")
    private WebElement logo;

    @FindBy(how = How.CLASS_NAME, using = "bm-burger-button")
    private WebElement btn_menu;

    @FindBy(how = How.XPATH, using = "//div/nav[@class = 'bm-item-list']/a")
    private List<WebElement> menuItems;

    //Menu items:
    @FindBy(how = How.ID, using = "inventory_sidebar_link")
    private WebElement link_all_items;

    @FindBy(how = How.ID, using = "about_sidebar_link")
    private WebElement link_about;

    @FindBy(how = How.ID, using = "logout_sidebar_link")
    private WebElement link_logout;

    @FindBy(how = How.ID, using = "reset_sidebar_link")
    private WebElement link_reset;

    @FindBy(how = How.ID, using = "react-burger-cross-btn")
    private WebElement btn_close;

    //checkout cart:
    @FindBy(how = How.CSS, using = "a[class = 'shopping_cart_link']")
    private WebElement link_cart;

    @FindBy(how = How.CSS, using = "span[class = 'shopping_cart_badge']")
    private WebElement notification_cart;


/*
Getters:
==============================================
*/

    public WebElement getLogo()
    {
        return logo;
    }

    public WebElement getBtn_menu()
    {
        return btn_menu;
    }

    public List<WebElement> getMenuItems()
    {
        return menuItems;
    }

    public WebElement getLink_all_items()
    {
        return link_all_items;
    }

    public WebElement getLink_about()
    {
        return link_about;
    }

    public WebElement getLink_logout()
    {
        return link_logout;
    }

    public WebElement getLink_reset()
    {
        return link_reset;
    }

    public WebElement getBtn_close()
    {
        return btn_close;
    }

    public WebElement getLink_cart()
    {
        return link_cart;
    }

    public WebElement getNotification_cart()
    {
        return notification_cart;
    }
}

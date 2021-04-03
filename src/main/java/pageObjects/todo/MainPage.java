package pageObjects.todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {
    @FindBy(how = How.CSS, using = "input[placeholder='Create a task']")
    private WebElement txt_addTask;

    @FindBy(how = How.CLASS_NAME, using = "view_1G-sh")
    private List<WebElement> list_tasks;


    @FindBy(how = How.CLASS_NAME, using = "destroy_2eVT9")
    private WebElement btn_remove;

    @FindBy(how = How.CLASS_NAME, using = "toggleVisibilityPanel_rW8qw")
    private WebElement menu_collapse;

    @FindBy(how = How.CLASS_NAME, using = "downArrowIcon_3rC4T")
    private WebElement btn_colors;


    @FindBy(how = How.XPATH, using = "(//span[@style='background: rgb(255, 103, 93);'])[1]")
    private WebElement item_red;

    @FindBy(how = How.XPATH, using = "//span[@style='background: rgb(249, 167, 77);']")
    private WebElement item_orange;

    @FindBy(how = How.CLASS_NAME, using = "emptyState_hUuBN")
    private WebElement txt_empty;

/*
Getters:
==============================================
*/

    public WebElement getTxt_addTask()
    {
        return txt_addTask;
    }

    public List<WebElement> getList_tasks()
    {
        return list_tasks;
    }

    public WebElement getBtn_remove()
    {
        return btn_remove;
    }

    public WebElement getMenu_collapse()
    {
        return menu_collapse;
    }

    public WebElement getBtn_colors()
    {
        return btn_colors;
    }

    public WebElement getItem_red()
    {
        return item_red;
    }

    public WebElement getItem_orange()
    {
        return item_orange;
    }

    public WebElement getTxt_empty()
    {
        return txt_empty;
    }
}

package pageObjects.swagLabsWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FinishOrderPage {

    @FindBy(how = How.XPATH, using = "subheader")
    private WebElement txt_finish;

    @FindBy(how = How.CLASS_NAME, using = "complete-header")
    private WebElement txt_completeHeader;

    @FindBy(how = How.XPATH, using = "//div[@class='complete-text']/text()")
    private WebElement txt_complete;

/*
Getters:
==============================================
*/

    public WebElement getTxt_finish()
    {
        return txt_finish;
    }

    public WebElement getTxt_completeHeader()
    {
        return txt_completeHeader;
    }

    public WebElement getTxt_complete()
    {
        return txt_complete;
    }
}

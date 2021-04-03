package pageObjects.swagLabsWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    @FindBy(how = How.ID, using = "user-name")
    private WebElement txt_username;

    @FindBy(how = How.CLASS_NAME, using = "login_logo")
    private WebElement logo_login;

    @FindBy(how = How.ID, using = "password")
    private WebElement txt_password;

    @FindBy(how = How.ID, using = "login-button")
    private WebElement btn_login;

    @FindBy(how = How.XPATH, using = "//div[@id='login_credentials']/h4[1]")
    private WebElement user_credentials;

    @FindBy(how = How.XPATH, using = "//div[@id='login_credentials']/h4[2]")
    private WebElement pass_credentials;


    @FindBy(how = How.XPATH, using = "//div[@id='login_credentials']/text()[2]")
    private WebElement user_standard_user;

    @FindBy(how = How.XPATH, using = "//div[@id='login_credentials']/text()[3]")
    private WebElement user_locked_user;

    @FindBy(how = How.XPATH, using = "//div[@id='login_credentials']/text()[4]")
    private WebElement user_problem_user;

    @FindBy(how = How.XPATH, using = "//div[@id='login_credentials']/text()[5]")
    private WebElement user_glitch_user;

    @FindBy(how = How.XPATH, using = "//div[@class='login_password']/text()")
    private WebElement pass_secret_sauce;

/*
Getters:
==============================================
*/

    public WebElement getTxt_username()
    {
        return txt_username;
    }

    public WebElement getLogo_login()
    {
        return logo_login;
    }

    public WebElement getTxt_password()
    {
        return txt_password;
    }

    public WebElement getBtn_login()
    {
        return btn_login;
    }

    public WebElement getUser_credentials()
    {
        return user_credentials;
    }

    public WebElement getPass_credentials()
    {
        return pass_credentials;
    }

    public WebElement getUser_standard_user()
    {
        return user_standard_user;
    }

    public WebElement getUser_locked_user()
    {
        return user_locked_user;
    }

    public WebElement getUser_problem_user()
    {
        return user_problem_user;
    }

    public WebElement getUser_glitch_user()
    {
        return user_glitch_user;
    }

    public WebElement getPass_secret_sauce()
    {
        return pass_secret_sauce;
    }
}

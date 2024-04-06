package US_503;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utility.BaseDriverSimple;


public class US_503_Elements extends BaseDriverSimple {
    public US_503_Elements() {
        PageFactory.initElements(BaseDriverSimple.driver, this);
    }

    @FindBy(linkText = "Log in")
    public WebElement loginStart;
    @FindBy(id = "Email")
    public WebElement emailField;

    @FindBy(id = "Password")
    public WebElement passwordField;

    @FindBy(xpath = "//*[@class='button-1 login-button']")
    public WebElement loginButton2;

    @FindBy(css = "div.message-error")
    public WebElement errorMessage;

    @FindBy(xpath = "//*[@id='Email-error']")
    public WebElement emailErrorMessage;


    @FindBy(xpath = "//*[@class='ico-account']")
    public WebElement myAccount;

}




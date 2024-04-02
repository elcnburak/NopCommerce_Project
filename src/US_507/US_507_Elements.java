package US_507;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US_507_Elements extends BaseDriver {
    public US_507_Elements(){
        PageFactory.initElements(BaseDriver.driver,this);
    }

    //*[@class='ico-login']
    @FindBy(xpath = "//*[@class='ico-login']")
    public WebElement loginTab;

    @FindBy(xpath = "//*[@id='Email']")
    public WebElement emailLogin;

    @FindBy(xpath = "//*[@id='Password']")
    public WebElement passwordLogin;

    @FindBy(xpath = "//*[@class='button-1 login-button']")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[@class='ico-account']")
    public WebElement myAccountElement;
    @FindBy(xpath = "//*[@class='top-menu notmobile']")
    public WebElement tabMenu;

    @FindBy(xpath = "(//*[text()='Computers '])[1]")
    public WebElement ComputersTab;






}

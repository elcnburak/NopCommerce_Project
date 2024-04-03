package US_507;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class US_507_Elements extends BaseDriver {
    public US_507_Elements(){
        PageFactory.initElements(BaseDriver.driver,this);
    }

    @FindBy(xpath = "//*[@class='top-menu notmobile']")
    public WebElement tabMenu;

    @FindBy(xpath = "(//*[text()='Computers '])[1]")
    public WebElement computersTab;

    @FindBy(linkText = "Desktops")
    public WebElement descktopsTab;

    @FindBy(xpath = "//*[@class='page-title']/h1")
    public WebElement descktopsPageTitle;

    @FindBy(xpath = "//*[text()='Build your own computer']")
    public WebElement buildOwnPC;

    @FindBy(xpath = "//*[@id='add-to-cart-button-1']")
    public WebElement addToCart;

    @FindBy(xpath = "//*[text()='The product has been added to your ']")
    public WebElement confirmationOfAddingToCart;

    @FindBy(xpath = "(//*[@name='product_attribute_2']/option)[2]")
    public WebElement ram2GB;

    @FindBy(xpath = "(//*[@name='product_attribute_2']/option)[3]")
    public WebElement ram4GB;

    @FindBy(xpath = "(//*[@name='product_attribute_2']/option)[4]")
    public WebElement ram8GB;

















}

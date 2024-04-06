package US_505;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US_505_Elements {


    @FindBy(xpath="//a[@href='/computers']")
    public WebElement computerLink;

    @FindBy(css = ".top-menu.notmobile > li > a")
    public List<WebElement> mainMenuItems;

    @FindBy(xpath = "//a[@href='/computers']/following-sibling::ul[@class='sublist']//a")
    public List<WebElement> subMenuItems;
    @FindBy(xpath ="//input[@id='small-searchterms']")
    public WebElement search;




    public US_505_Elements() {
        PageFactory.initElements(BaseDriver.driver, this);
    }


}

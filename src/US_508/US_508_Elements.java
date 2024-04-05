package US_508;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_508_Elements extends BaseDriver {
    US_508_Elements() {PageFactory.initElements(BaseDriver.driver,this);}

    @FindBy(xpath = "//*[@placeholder='Search store']")
    public WebElement searchField;

    @FindBy(xpath = "//*[@class='product-title']/a")
    public WebElement productTitleAfterSearch;







}

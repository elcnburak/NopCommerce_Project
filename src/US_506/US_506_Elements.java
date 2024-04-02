package US_506;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_506_Elements {

    @FindBy(xpath="//a[@href='/gift-cards']")
    public WebElement giftCardLink;

    public US_506_Elements() {
        PageFactory.initElements(BaseDriver.driver, this);
    }
}

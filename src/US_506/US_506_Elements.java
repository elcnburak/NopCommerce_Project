package US_506;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_506_Elements {

    @FindBy(xpath="//a[@href='/gift-cards']")
    public WebElement giftCardLink;

    @FindBy(xpath = "//img[@alt='Picture of $100 Physical Gift Card']")
    public WebElement giftCard;

    @FindBy(xpath ="//input[@class='recipient-name']")
    public WebElement recipientName;

    @FindBy(xpath = "//input[contains(@class, 'sender-name')]")
    public WebElement yourName;

    @FindBy(xpath = "//textarea[@class='message']")
    public WebElement message;

    @FindBy(xpath = "//button[@id='add-to-cart-button-45']")
    public WebElement AddToCartButon;

    @FindBy(xpath = "//p[@class='content']")
    public WebElement addedMessage;


    public US_506_Elements() {
        PageFactory.initElements(BaseDriver.driver, this);
    }
}

package US_504;


import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_504 extends BaseDriver {

    @Test(priority = 4, dataProvider = "tabMenuData", groups = {"UITesting", "TAB Menu"})
    public void US_504_2(String tabXpath, String subMenuXpath, String expectedUrl) throws InterruptedException {
        WebElement tab = driver.findElement(By.xpath(tabXpath));
        Actions action = new Actions(driver);
        action.moveToElement(tab).perform();
        Thread.sleep(1000);

        if(subMenuXpath != null && !subMenuXpath.isEmpty()) {

            WebElement subMenu = driver.findElement(By.xpath(subMenuXpath));
            subMenu.click();
        } else {

            tab.click();
        }

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl, "URL does not match expected.");

    }


    @DataProvider(name = "tabMenuData")
    public Object[][] provideData() {
        return new Object[][]{
                {"//a[@href='/computers']", "//a[@href='/desktops']", "https://demo.nopcommerce.com/desktops"},
                {"//a[@href='/computers']", "//a[@href='/notebooks']", "https://demo.nopcommerce.com/notebooks"},
                {"//a[@href='/computers']", "//a[@href='/software']", "https://demo.nopcommerce.com/software"},
                {"//a[@href='/electronics']", "//a[@href='/camera-photo']", "https://demo.nopcommerce.com/camera-photo"},
                {"//a[@href='/electronics']", "//a[@href='/cell-phones']", "https://demo.nopcommerce.com/cell-phones"},
                {"//a[@href='/electronics']", "//a[@href='/others']", "https://demo.nopcommerce.com/others"},
                {"//a[@href='/apparel']", "//a[@href='/shoes']", "https://demo.nopcommerce.com/shoes"},
                {"//a[@href='/apparel']", "//a[@href='/clothing']", "https://demo.nopcommerce.com/clothing"},
                {"//a[@href='/apparel']", "//a[@href='/accessories']", "https://demo.nopcommerce.com/accessories"},
                {"//a[@href='/digital-downloads']","", "https://demo.nopcommerce.com/digital-downloads"},
                {"//a[@href='/books']","", "https://demo.nopcommerce.com/books"},
                {"//a[@href='/jewelry']","", "https://demo.nopcommerce.com/jewelry"},
                {"//a[@href='/gift-cards']","", "https://demo.nopcommerce.com/gift-cards"},
        };
    }
}


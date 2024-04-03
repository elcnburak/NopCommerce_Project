package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Tools extends BaseDriver {
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        public static void Bekle(int sn) {
            try {
                Thread.sleep(3000);//bekleme
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public static void SuccessMessageValidation() {
            WebElement msgLabel = BaseDriver.driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
            Assert.assertTrue(msgLabel.getText().toLowerCase().contains("success"));
        }

        public static void JSClick(WebElement e) {
            JavascriptExecutor js = (JavascriptExecutor) BaseDriver.driver;
            js.executeScript("arguments[0].click();", e); // js click : sayfanın içinden click
        }

        public static int randomGenerator(int sinir) {
            return (int) (Math.random() * sinir);
        }

        public static boolean ListContainsString(List<WebElement> list, String aranacak) {
            boolean bulundu = false;
            for (WebElement e : list) {
                if (e.getText().toLowerCase().equals(aranacak.toLowerCase()))
                    bulundu = true;
            }

            return bulundu;

        }
    public static void myClick(WebElement element) {
        scrollToElement(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public static void mySendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

//This method is used for the Action class
    public static void ActionHoveOver(WebElement e){
            Actions actions=new Actions(BaseDriver.driver);
            new Actions(BaseDriver.driver)
                    .moveToElement(e)
                    .build()
                    .perform();
        }
}

package US_506;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class US_506 extends BaseDriver {

    @Test
    public void US_506TestCase() {

        US_506_Elements elements= new US_506_Elements();

        elements.giftCardLink.click();// Menüden giftcard link tıklandı
        elements.giftCard.click();// gift card seçildi
        elements.recipientName.sendKeys("Elcin");// recipient name gönderildi
        elements.yourName.clear();// your name temizlendi
        elements.yourName.sendKeys("Elcin");// name gönderildi
        elements.message.sendKeys("Gift hediye kartı istiyorum");// mesaj yazıldı
        elements.AddToCartButon.click();// sepete eklendi

        // Doğrulama
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));
        String actualMessage = message.getText();
        String expectedMessage = "The product has been added to your shopping cart";
        Assert.assertTrue(actualMessage.contains(expectedMessage), "Mesaj görünmedi veya beklenen metni içermiyor.");


    }


}

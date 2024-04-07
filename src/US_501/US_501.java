package US_501;

public class US_501 {

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

    public class NopCommerceRegistrationTest {
        public static void main(String[] args) {
            // WebDriver'ı kullanmak için ChromeDriver'ı yükleyin ve yolunu belirtin
            System.setProperty("webdriver.chrome.driver", "path_to_chromedriver/chromedriver.exe");

            // WebDriver örneğini oluşturun
            WebDriver driver = new ChromeDriver();

            // Test sitesine gidin
            driver.get("https://demo.nopcommerce.com/");

            // Kayıt sayfasına gitmek için Register bağlantısını bulun ve tıklayın
            WebElement registerLink = driver.findElement(By.linkText("Register"));
            registerLink.click();

            // Kullanıcı bilgilerini doldurun
            driver.findElement(By.id("FirstName")).sendKeys("Team One");
            String lastName = "Techno" + (int)(Math.random() * 1000); // Random soyad oluşturun
            driver.findElement(By.id("LastName")).sendKeys(lastName);
            driver.findElement(By.id("Email")).sendKeys("t.one.techno@gmail.com");
            driver.findElement(By.id("Password")).sendKeys("TOtechno1");

            // Doğum tarihini seçin
            WebElement dateOfBirthDropdown = driver.findElement(By.name("DateOfBirthDay"));
            Select dateOfBirthSelect = new Select(dateOfBirthDropdown);
            dateOfBirthSelect.selectByVisibleText("5");

            WebElement monthOfBirthDropdown = driver.findElement(By.name("DateOfBirthMonth"));
            Select monthOfBirthSelect = new Select(monthOfBirthDropdown);
            monthOfBirthSelect.selectByVisibleText("May");

            WebElement yearOfBirthDropdown = driver.findElement(By.name("DateOfBirthYear"));
            Select yearOfBirthSelect = new Select(yearOfBirthDropdown);
            yearOfBirthSelect.selectByVisibleText("2005");

            // Kaydol düğmesine tıklayın
            driver.findElement(By.id("register-button")).click();

            // Kayıt başarılı mesajını kontrol edin
            WebElement successMessage = driver.findElement(By.className("result"));
            String message = successMessage.getText();
            if (message.contains("Your registration completed")) {
                System.out.println("Kayıt başarıyla tamamlandı.");
            } else {
                System.out.println("Kayıt tamamlanamadı!");
            }

            // Tarayıcıyı kapatın
            driver.quit();
        }
    }


}

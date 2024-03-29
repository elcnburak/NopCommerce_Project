package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

import static Utility.BaseDriver.logTutma;

public class BaseDriverParameter {

    public WebDriver driver; // WebDriver tipinde değişken tanımlayın
    public WebDriverWait wait;

    @BeforeClass
    @Parameters("browserTipi")
    public void BaslangicIslemleri(String browserTipi) {
        switch (browserTipi.toLowerCase()) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                driver = new ChromeDriver();
        }

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        Tools.Bekle(2);
        LoginTest();
    }

    public void LoginTest() {
        System.out.println("Login Test başladı");
        logTutma.info("Log işlemi başladı");
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
        Tools.Bekle(2);

        WebElement email=driver.findElement(By.xpath("//*[@id='Email']"));
        email.sendKeys("elcnburak@gmail.com");

        WebElement password=driver.findElement(By.xpath("//*[@id='Password']"));
        password.sendKeys("Admin123**");

        WebElement loginBtn=driver.findElement(By.xpath("body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[3]/button[1]")); //By.cssSelector("[value='Login']")
        loginBtn.click();

        wait.until(ExpectedConditions.titleIs("My Account"));
        Assert.assertTrue(driver.getTitle().equals("My Account"));
        System.out.println("Login Test bitti");

        logTutma.info("Log işlemi tamamlandı"); // normal bir bilgi
    }

    @AfterClass
    public void KapanisIslemleri() {
        System.out.println("Kapanış işlemleri yapılıyor");
        Tools.Bekle(3);
        driver.quit();
    }
}

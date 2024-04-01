package Utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; // Logger paketi değiştirildi
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseDriver {

    public static Logger logTutma = LogManager.getLogger(); // Logger nesnesi düzeltildi

    public static WebDriver driver;
    public static WebDriverWait wait;
    @BeforeClass
    public void BaslangicIslemleri(){ // TearStart

        driver=new ChromeDriver();

        //driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // 20 sn mühlet: elementi bulma mühleti
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        Tools.Bekle(2);
        LoginTest();
    }

    public void LoginTest(){
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
    public void KapanisIslemleri(){  // TearDown
        Tools.Bekle(3);
        driver.quit();
        logTutma.info("Driver kapatıldı");
    }

    @BeforeMethod
    public void BeforeMetod(){
        logTutma.info("Metod başladı");
        logTutma.warn("WARN : Metod başladı, hata oluşmuş olsa idi");
    }

    @AfterMethod
    public void AfterMetod(ITestResult sonuc){ // tesin sonuç ve isim bilgisini olduğu değişkeni
        logTutma.info(sonuc.getName()+  " Metod bitti "+ (sonuc.getStatus() ==1 ? "Passed" : "failed"));

        logTutma.warn("WARN : Metod bitti, hata oluşmuş olsa idi");
    }
}

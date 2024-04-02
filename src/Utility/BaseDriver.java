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
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Random;

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
        RegisterAndLogin();
    }

    public void RegisterAndLogin() {
        System.out.println("Register ve Login işlemi başladı");
        logTutma.info("Log işlemi başladı");
        driver.get("https://demo.nopcommerce.com/");

        Tools.Bekle(2);

        // Register işlemleri burada başlıyor
        WebElement register = driver.findElement(By.xpath("//a[@class='ico-register']"));
        register.click(); // Register butonuna tıklandı

        WebElement registerName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        registerName.sendKeys(generateRandomString());// Name bilgisi random gönderildi

        WebElement registerSurname = driver.findElement(By.xpath("//input[@id='LastName']"));
        registerSurname.sendKeys(generateRandomString()); // Surname bilgisi random gönderildi

        String loginEmail = generateRandomEmail(); // Random e-posta oluşturuldu
        WebElement registerEmail = driver.findElement(By.xpath("//input[@id='Email']"));
        registerEmail.sendKeys(loginEmail); // Oluşturulan random e-posta adresi kullanıldı

        Tools.Bekle(30);

        WebElement RegisterPassword = driver.findElement(By.xpath("//input[@id='Password']"));
        RegisterPassword.sendKeys("Techno123"); // sabit password seçildi

        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmPassword.sendKeys("Techno123");//sabit password seçildi

        WebElement registerButon=driver.findElement(By.id("register-button"));
        registerButon.click(); // Register butona tıklandı

        WebElement continueButon=driver.findElement(By.xpath("//a[@class='button-1 register-continue-button']"));
        continueButon.click(); // continue button tıklandı

        /// Login işlemeleri burada başlıyor

        WebElement LogIn=driver.findElement(By.xpath("//a[@href='/login?returnUrl=%2F' and contains(text(),'Log in')]"));
        LogIn.click();

        WebElement email=driver.findElement(By.xpath("//input[@id='Email']"));
        email.sendKeys(loginEmail); // Oluşturulan random e-posta adresi kullanıldı

        WebElement password=driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("Techno123");

        WebElement LoginButton=driver.findElement(By.xpath("//button[@class='button-1 login-button' and text()='Log in']"));
        LoginButton.click();

        System.out.println("Register ve Login işlemi tamamlandı");
        logTutma.info("Log işlemi tamamlandı");
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

        logTutma.warn("WARN : Metod bitti,. hata oluşmuş olsa idi");
    }

    public String generateRandomString() {
        Random random = new Random();
        return "kullanici" + random.nextInt(1000);
    }

    public String generateRandomEmail() {
        Random random = new Random();
        return "kullanici" + random.nextInt(1000) + "@technostudy.com";
    }
}

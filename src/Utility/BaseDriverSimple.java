package Utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Random;

    public class BaseDriverSimple {
        public static Logger logTutma = LogManager.getLogger();

        public static WebDriver driver;
        public static WebDriverWait wait;

        @BeforeClass
        public void setUpProcessOpenWebsite(){
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            System.out.println("Website is openning");
            logTutma.info("Website is openning");
            driver.get("https://demo.nopcommerce.com/");


        }

        @AfterClass
        public void tearDownProcess(){
            Tools.Bekle(3);
            driver.quit();
            logTutma.info("Driver is closed");
        }

        @BeforeMethod
        public void BeforeMetod(){
            logTutma.info("Method is started ");
            logTutma.warn("WARN : Method is started, if an error had occurred");
        }

        @AfterMethod
        public void AfterMetod(ITestResult sonuc){ // tesin sonuç ve isim bilgisini olduğu değişkeni
            logTutma.info(sonuc.getName()+  " Method is finished "+ (sonuc.getStatus() ==1 ? "Passed" : "failed"));
            logTutma.warn("WARN : Metod bitti,. if an error had occurred");
        }


    }


















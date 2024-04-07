package US_502;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

    public class NopCommerceLoginTest {
        private WebDriver driver;
        private String baseUrl = "https://demo.nopcommerce.com/";

        @BeforeClass
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "path_to_chromedriver/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(baseUrl);
        }

        @Test(priority = 1)
        public void testLoginPage() {
            WebElement loginLink = driver.findElement(By.linkText("Log in"));
            loginLink.click();
            String actualUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualUrl, baseUrl + "login");
        }

        @Test(priority = 2, dependsOnMethods = "testLoginPage")
        public void testLogin() {
            String email = "your_email@example.com";
            String password = "your_password";

            WebElement emailField = driver.findElement(By.id("Email"));
            WebElement passwordField = driver.findElement(By.id("Password"));
            WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log in']"));

            emailField.sendKeys(email);
            passwordField.sendKeys(password);
            loginButton.click();

            // Check if login is successful by verifying presence of logout link
            WebElement logoutLink = driver.findElement(By.linkText("Log out"));
            Assert.assertTrue(logoutLink.isDisplayed());
        }

        @AfterClass
        public void tearDown() {
            driver.quit();
        }
    }



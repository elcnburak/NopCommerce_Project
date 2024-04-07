package US_503;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Utility.BaseDriverSimple;
import Utility.Tools;

import static Utility.Tools.myClick;


public class US_503 extends BaseDriverSimple {

    @Test(priority = 1, dataProvider = "credentials")
    public void testInvalidLogin(String email, String password) {
        US_503_Elements elementler = new US_503_Elements();


        myClick(elementler.loginStart);
        Tools.mySendKeys(elementler.emailField, email);
        Tools.mySendKeys(elementler.passwordField, password);
        myClick(elementler.loginButton2);
        Tools.Bekle(2);



    }

    @DataProvider(name = "credentials")
    public Object[][] provideCredentials() {
        return new Object[][]{
                {"", ""},
                {"blblb@gmail.com", ""},
                {"", "56778"},
                {"blblb@gmail.com", "56778"},
                {"wiesbaden@gmail.com", "56778"},
                {"blblb@gmail.com", "Cokkolaysifre"},
                {"wiesbaden@gmail.com", "Cokkolaysifre"}
        };

    }
}








































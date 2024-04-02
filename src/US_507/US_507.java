package US_507;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_507 extends BaseDriver {

    @Test
    public void TestComputersOrder(){
        US_507_Elements elems=new US_507_Elements();
        Tools.myClick(elems.ComputersTab);
//        Tools.myClick(elems.ComputersTab);


        //Assert.assertTrue(elems.tabMenu.isDisplayed(),"Tab menu is not visible");
//        Actions actions=new Actions(driver);
//        new Actions(driver)
//                .moveToElement(elems.ComputersTab)
//                .build()
//                .perform();

    }
}

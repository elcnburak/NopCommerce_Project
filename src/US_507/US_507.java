package US_507;

import Utility.BaseDriver;
import Utility.Tools;
import org.testng.Assert;
import org.testng.annotations.Test;



public class US_507 extends BaseDriver {

    @Test (priority = 2, groups ={"UITesting", "TAB Menu", "Order"})
    public void TestComputersOrder(){
        US_507_Elements elems=new US_507_Elements();
        Assert.assertTrue(elems.tabMenu.isDisplayed(),"Tab menu is not visible");
        Tools.ActionHoveOver(elems.computersTab);
        Tools.ActionHoveOverClick(elems.descktopsTab);
        Assert.assertTrue(elems.descktopsPageTitle.isDisplayed(),"The Desktops page is not opened");
        Tools.myClick(elems.buildOwnPC);
        Tools.RandomRAM();
        Tools.RandomHDD();
        Tools.myClick(elems.addToCart);
        Assert.assertTrue(elems.confirmationOfAddingToCart.getText().toLowerCase().contains("added"), "There is no added item to the shopping cart");




    }
}

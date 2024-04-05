package US_508;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class US_508 extends BaseDriver {
    @Test (priority = 2, groups ={"UITesting", "Search", "Smoke", "Regression"})
    @Parameters("searchItem")
    public void ParameterizedSearchProcessTest(String searchItem){
        US_508_Elements elems=new US_508_Elements();
        Assert.assertTrue(elems.searchField.isDisplayed(), "The search box is not displayed");
        Tools.mySendKeys(elems.searchField, searchItem+ Keys.ENTER);
        Assert.assertTrue(elems.productTitleAfterSearch.getText().equalsIgnoreCase("Adobe Photoshop CS4"));

    }
}

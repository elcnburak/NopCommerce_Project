package US_505;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Utility.BaseDriver;
import java.util.List;

public class US_505 extends BaseDriver {

    @Test
    public void TabMenuControl() {
        US_505_Elements elements = new US_505_Elements();
        List<WebElement> mainMenuItems = elements.mainMenuItems;

        System.out.println("Ana Menü İsimleri:");
        for (WebElement menuItem : mainMenuItems) {
            System.out.println(menuItem.getText().trim());
        }
    }

    @Test
    public void SubMenuControl() {
        US_505_Elements elements = new US_505_Elements();
        elements.computerLink.click();

        List<WebElement> subMenuItems = elements.subMenuItems;

        if (subMenuItems.isEmpty()) {
            System.out.println("Alt menü öğeleri bulunamadı.");
        } else {
            System.out.println("Alt Menü İsimleri:");
            for (WebElement menuItem : subMenuItems) {
                System.out.println(menuItem.getText().trim());
            }
        }
    }

    @Test
    @Parameters("searchText")
    public void testRandomProductSelection(String searchText) {

        }
    }



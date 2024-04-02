package US_506;

import Utility.BaseDriver;
import org.testng.annotations.Test;

public class US_506 extends BaseDriver {

    @Test
    public void US_506TestCase() {

        US_506_Elements elements= new US_506_Elements();

        elements.giftCardLink.click();

    }


}

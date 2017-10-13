package all_tests.TestFromSelenide;

import all_tests.init.SimpleTestsInit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.site.JDIExampleSite.*;
import static org.mytests.uiobjects.example.enums.HeaderMenu.DATES;
import static org.mytests.uiobjects.example.enums.HeaderMenu.HEADER_SERVICE;

/**
 * Created by X240 on 10/10/2017.
 */
public class DragAndDrop extends SimpleTestsInit {

    @DataProvider(parallel = true)
    public Object[][] dragAndDropProvider(){
        return new Object[][]{
                {0, 0},
                {30, 70},
                {100, 100},
                {0, 100}
        };
    }

    @Test(dataProvider = "dragAndDropProvider", groups = "Regression")
    public void testCF(int left, int right) {
        //Open login form and perform login
        homePage.open();
        login();
        homePage.checkOpened();

        header.open(HEADER_SERVICE, DATES);

        dates.setSliders(left,right);
        dates.checkSliders(left, right);

    }
}

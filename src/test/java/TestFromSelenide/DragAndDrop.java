package TestFromSelenide;

import init.SimpleTestsInit;
import org.mytests.uiobjects.example.entities.SummeryInfo;
import org.mytests.uiobjects.example.enums.HeaderMenu;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.JDIExampleSite.*;
import static org.mytests.uiobjects.example.enums.EvenNumbers.EIGHT;
import static org.mytests.uiobjects.example.enums.EvenNumbers.FOUR;
import static org.mytests.uiobjects.example.enums.HeaderMenu.DATES;
import static org.mytests.uiobjects.example.enums.HeaderMenu.DIFFERENT_ELEMENTS;
import static org.mytests.uiobjects.example.enums.HeaderMenu.HEADER_SERVICE;
import static org.mytests.uiobjects.example.enums.OddNumbers.SEVEN;
import static org.mytests.uiobjects.example.enums.OddNumbers.THREE;

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

    @Test(dataProvider = "dragAndDropProvider")
    public void testCF(int left, int right) {
        //Open login form and perform login
        homePage.open();
        login();
        homePage.checkOpened();

        header.open(HEADER_SERVICE, DATES);

        dates.setSliders(left,right);


    }
}

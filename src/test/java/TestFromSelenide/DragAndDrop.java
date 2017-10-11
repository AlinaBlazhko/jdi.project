package TestFromSelenide;

import init.SimpleTestsInit;
import org.mytests.uiobjects.example.enums.HeaderMenu;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.JDIExampleSite.*;
import static org.mytests.uiobjects.example.enums.HeaderMenu.DATES;
import static org.mytests.uiobjects.example.enums.HeaderMenu.DIFFERENT_ELEMENTS;
import static org.mytests.uiobjects.example.enums.HeaderMenu.HEADER_SERVICE;

/**
 * Created by X240 on 10/10/2017.
 */
public class DragAndDrop extends SimpleTestsInit {



    @Test
    public void testCF() {
        //Open login form and perform login
        homePage.open();
        login();
        homePage.checkOpened();

        header.open(HEADER_SERVICE, DATES);

        dates.setSliders(0,0);
        dates.setSliders(30, 70);
        dates.setSliders(100, 100);
    }
}

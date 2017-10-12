package dates_form_tests;

import init.SimpleTestsInit;
import org.mytests.uiobjects.example.entities.DatesInfo;
import org.mytests.uiobjects.example.enums.DragAndDrop;
import org.mytests.uiobjects.example.enums.HeaderMenu;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.JDIExampleSite.*;
import static org.mytests.uiobjects.example.enums.DatesInfoEnum.*;
import static org.mytests.uiobjects.example.enums.HeaderMenu.DATES;
import static org.mytests.uiobjects.example.enums.HeaderMenu.HEADER_SERVICE;

/**
 * Created by X240 on 10/11/2017.
 */
public class ResultsTest extends SimpleTestsInit{
//    @DataProvider(parallel = true)
//    public Object[][] datesProvider(){
//        return new Object[][]{
//                {new DatesInfo(NAME.element, LAST_NAME.element, DESCRIPTION.element, FROM.element, TO.element, DATE_PICKER.element, TIME_PICKER.element, 0, 0)},
//                {new DatesInfo(NAME.element, LAST_NAME.element, DESCRIPTION.element, FROM.element, TO.element, DATE_PICKER.element, TIME_PICKER.element, 100, 100)},
//                {new DatesInfo(NAME.element, LAST_NAME.element, DESCRIPTION.element, FROM.element, TO.element, DATE_PICKER.element, TIME_PICKER.element, 30, 70)}
//        };
//    }
//
//    @Test(dataProvider = "datesProvider")
//    public void resultsTest(DatesInfo datesInfo){
//        homePage.open();
//        login();
//
//        header.open(HEADER_SERVICE, DATES);
//
//        dates.setSliders(datesInfo.slider1, datesInfo.slider2);
//        dates.submit(datesInfo);
//    }
}

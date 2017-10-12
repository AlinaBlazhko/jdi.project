package dates_form_tests;

import init.SimpleTestsInit;
import org.mytests.uiobjects.example.entities.DatesInfo;
import org.mytests.uiobjects.example.entities.Range1;
import org.mytests.uiobjects.example.entities.Range2;
import org.mytests.uiobjects.example.enums.HeaderMenu;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.epam.web.matcher.testng.Assert;

import java.util.Objects;

import static org.mytests.uiobjects.example.JDIExampleSite.*;
import static org.mytests.uiobjects.example.enums.DatesInfoEnum.*;
import static org.mytests.uiobjects.example.enums.HeaderMenu.HEADER_SERVICE;
import static org.mytests.uiobjects.example.enums.Status.*;

/**
 * Created by X240 on 10/11/2017.
 */
public class MandatoryAndOptionalFields extends SimpleTestsInit {
    @DataProvider(parallel = true)
    public Object[][] dataProvider(){
        return new Object[][]{
                {new DatesInfo(NAME.element, LAST_NAME.element, DESCRIPTION.element, new Range1(20, 30), DATE_PICKER.element, TIME_PICKER.element, new Range2(0, 0)), ALL.status, true},
                {new DatesInfo(NAME.element, LAST_NAME.element, DESCRIPTION.element, new Range1(20, 30), DATE_PICKER.element, TIME_PICKER.element, new Range2(100, 100)), MANDATORY.status, false},
                {new DatesInfo(NAME.element, LAST_NAME.element, DESCRIPTION.element, new Range1(20, 30), DATE_PICKER.element, TIME_PICKER.element, new Range2(30, 70)), OPTIONAL.status, true},
                {new DatesInfo(NAME.element, LAST_NAME.element, DESCRIPTION.element, new Range1(20, 30), DATE_PICKER.element, TIME_PICKER.element, new Range2(30, 70)), NOTHING.status, true}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void testMandatoryField(DatesInfo datesInfo, String status, boolean submit){
        homePage.open();
        login();

        header.open(HEADER_SERVICE, HeaderMenu.DATES);

        if (Objects.equals(status, NOTHING.status) && (submit)){
            dates.submit.click();
        }else {
            dates.submit(datesInfo);
        }

        if (Objects.equals(status, ALL.status) && submit){
            Assert.contains(rightSection.results.get(0).getText(), datesInfo.name);
            Assert.contains(rightSection.results.get(1).getText(), datesInfo.lastName);
            Assert.contains(rightSection.results.get(2).getText(), datesInfo.description);
            Assert.contains(rightSection.results.get(3).getText(), datesInfo.datePicker);
            Assert.contains(rightSection.results.get(4).getText(), datesInfo.timePicker);
            Assert.contains(rightSection.results.get(5).getText(), String.valueOf(datesInfo.range1.to));
            Assert.contains(rightSection.results.get(5).getText(), String.valueOf(datesInfo.range1.from));
            Assert.contains(rightSection.results.get(6).getText(), String.valueOf(datesInfo.range2.to));
            Assert.contains(rightSection.results.get(6).getText(), String.valueOf(datesInfo.range2.from));
        }else {
            if (Objects.equals(status, NOTHING.status) && submit){
                Assert.contains(rightSection.results.get(0).getText(), "Time");
                Assert.contains(rightSection.results.get(1).getText(), "from 20 to 100");
            }
        }


//
//        if (Objects.equals(status, OPTIONAL.status) && submit){
//            Assert.assertTrue(dates.name.getText().isEmpty()&&dates.lastName.getText().isEmpty());
//        }


    }
}
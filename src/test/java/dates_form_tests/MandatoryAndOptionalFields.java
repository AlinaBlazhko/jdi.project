package dates_form_tests;

import init.SimpleTestsInit;
import org.mytests.uiobjects.example.entities.DatesInfo;
import org.mytests.uiobjects.example.entities.Range1;
import org.mytests.uiobjects.example.entities.Range2;
import org.mytests.uiobjects.example.enums.HeaderMenu;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.epam.web.matcher.testng.Assert;

import java.util.Objects;

import static org.mytests.uiobjects.example.site.JDIExampleSite.*;
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

    @BeforeMethod
    public void beforeTest() {
        homePage.open();
        login();
    }

    @Test(dataProvider = "dataProvider")
    public void testMandatoryField(DatesInfo datesInfo, String status, boolean submit) {
        header.open(HEADER_SERVICE, HeaderMenu.DATES);

        if (Objects.equals(status, MANDATORY.status)) {
            dates.onlyMandatory().fill(datesInfo);
            dates.fillRange(datesInfo);
        }

        if (Objects.equals(status, OPTIONAL.status)) {
            dates.onlyOptional().fill(datesInfo);
            dates.setSliders(datesInfo.range1.from, datesInfo.range2.to);
        }

        if (Objects.equals(status, ALL.status) && submit) {
            dates.submit(datesInfo);
            dates.verifyResultForAll(datesInfo);
        }

        if (Objects.equals(status, NOTHING.status) && submit) {
            dates.submit.click();
            Assert.contains(rightSection.results.get(0).getText(), "Time");
            Assert.contains(rightSection.results.get(1).getText(), "from 20 to 100");
        }


    }
}

import init.SimpleTestsInit;
import org.mytests.uiobjects.example.entities.DatesInfo;
import org.mytests.uiobjects.example.entities.Range1;
import org.mytests.uiobjects.example.enums.HeaderMenu;
import org.mytests.uiobjects.example.enums.Status;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.Test;

import java.util.Objects;

import static org.mytests.uiobjects.example.JDIExampleSite.*;
import static org.mytests.uiobjects.example.enums.DatesInfoEnum.*;
import static org.mytests.uiobjects.example.enums.DatesInfoEnum.DESCRIPTION;
import static org.mytests.uiobjects.example.enums.DatesInfoEnum.TO;
import static org.mytests.uiobjects.example.enums.HeaderMenu.HEADER_SERVICE;
import static org.mytests.uiobjects.example.enums.Status.*;

/**
 * Created by X240 on 10/11/2017.
 */
public class MandatoryAndOptionalFields extends SimpleTestsInit {
    @DataProvider(parallel = true)
    public Object[][] dataProvider(){
        return new Object[][]{
                {new DatesInfo(NAME.element, LAST_NAME.element, DESCRIPTION.element, FROM.element, TO.element, DATE_PICKER.element, TIME_PICKER.element), ALL.status, true},
                {new DatesInfo(NAME.element, LAST_NAME.element, DESCRIPTION.element, FROM.element, TO.element, DATE_PICKER.element, TIME_PICKER.element), MANDATORY.status, false},
                {new DatesInfo(NAME.element, LAST_NAME.element, DESCRIPTION.element, FROM.element, TO.element, DATE_PICKER.element, TIME_PICKER.element), OPTIONAL.status, true},
                {new DatesInfo("", "", "", "", "", "", ""), NOTHING.status, true}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void testMandatoryField(DatesInfo datesInfo, String status, boolean submit){
        homePage.open();
        login();

        header.open(HEADER_SERVICE, HeaderMenu.DATES);

        if (Objects.equals(status, ALL.status) && submit){
            dates.submit(datesInfo);
        }

        if (Objects.equals(status, MANDATORY.status) && (!submit)){
            dates.onlyMandatory().fill(datesInfo);
            Assert.assertTrue(dates.description.getText().isEmpty()&&dates.datePicker.getText().isEmpty());
        }

        if (Objects.equals(status, OPTIONAL.status) && submit){
            dates.onlyOptional().submit(datesInfo);
            Assert.assertTrue(dates.name.getText().isEmpty()&&dates.lastName.getText().isEmpty());
        }

        if (Objects.equals(status, NOTHING.status) && submit){
            dates.submit(datesInfo);
        }
    }
}

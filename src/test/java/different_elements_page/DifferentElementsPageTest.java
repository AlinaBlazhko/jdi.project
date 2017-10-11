package different_elements_page;

import com.epam.jdi.uitests.web.selenium.elements.common.DatePicker;
import init.SimpleTestsInit;
import org.mytests.uiobjects.example.enums.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.JDIExampleSite.*;
import static org.mytests.uiobjects.example.enums.CheckBoxes.*;
import static org.mytests.uiobjects.example.enums.Colors.*;
import static org.mytests.uiobjects.example.enums.HeaderMenu.*;
import static org.mytests.uiobjects.example.enums.Metals.*;
import static org.mytests.uiobjects.example.enums.Status.*;

/**
 * Created by X240 on 10/6/2017.
 */
public class DifferentElementsPageTest extends SimpleTestsInit {
    @Test
    public void testDE() {
        //Open login form and perform login
        homePage.open();
        login();
        homePage.checkOpened();

        //open Different elements page
        header.open(HEADER_SERVICE, DIFFERENT_ELEMENTS);

        //Select some checkboxes, radioButton and element from dropdown
        selectAndCheckCheckbox(WATER);
        Assert.assertTrue((rightSection.logs.get(0).getText().contains(WATER.element)&&(rightSection.logs.get(0).getText().contains(TRUE.status))));

        selectAndCheckCheckbox(WIND);
        Assert.assertTrue((rightSection.logs.get(0).getText().contains(WIND.element)&&(rightSection.logs.get(0).getText().contains(TRUE.status))));

        selectMetal(SILVER);
        Assert.assertTrue((rightSection.logs.get(0).getText().contains(SILVER.element))&&(rightSection.logs.get(0).getText().contains(METAL.status)));

        selectColor(BLUE);
        Assert.assertTrue((rightSection.logs.get(0).getText().contains(BLUE.getElement()))&&(rightSection.logs.get(0).getText().contains(COLORS.status)));

        submitFromDifferentElements();
        Assert.assertTrue(rightSection.logs.get(0).getText().contains("button clicked"));
    }
}

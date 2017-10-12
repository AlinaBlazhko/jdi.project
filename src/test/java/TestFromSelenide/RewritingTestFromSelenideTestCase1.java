package TestFromSelenide;

import init.SimpleTestsInit;
import org.mytests.uiobjects.example.enums.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.JDIExampleSite.*;
import static org.mytests.uiobjects.example.enums.CheckBoxes.*;
import static org.mytests.uiobjects.example.enums.Colors.YELLOW;
import static org.mytests.uiobjects.example.enums.HeaderMenu.DIFFERENT_ELEMENTS;
import static org.mytests.uiobjects.example.enums.HeaderMenu.HEADER_HOME;
import static org.mytests.uiobjects.example.enums.HeaderMenu.HEADER_SERVICE;
import static org.mytests.uiobjects.example.enums.LeftSectionMenu.LEFT_SERVICE;
import static org.mytests.uiobjects.example.enums.Metals.SELEN;
import static org.mytests.uiobjects.example.enums.Status.*;

/**
 * Created by X240 on 10/8/2017.
 */
public class RewritingTestFromSelenideTestCase1 extends SimpleTestsInit {

    @Test
    public void rewritingTest(){
        homePage.open();

        //Perform login and assert Username
        login();

        homePage.checkOpened();

        //Check interface from Home page
        checkExistenceOfElements();

        //Check dropdown menu on left section
        containingElementLeftSection();

        //Check dropdown menu on header
        containingElementHeader();

        //Return from Home page
        header.open(HEADER_HOME);

        //Check interface on Different elements page
        leftSection.open(LEFT_SERVICE, LeftSectionMenu.DIFFERENT_ELEMENTS);
        containingElementDifferentElements();

        //Select and assert checkboxes
        selectAndCheckCheckbox(WATER);
        Assert.assertTrue((rightSection.logs.get(0).getText().contains(WATER.element))&&(rightSection.logs.get(0).getText().contains(TRUE.status)));
        selectAndCheckCheckbox(WIND);
        Assert.assertTrue((rightSection.logs.get(0).getText().contains(WIND.element))&&(rightSection.logs.get(0).getText().contains(TRUE.status)));

        //Select radio
        selectMetal(SELEN);
        Assert.assertTrue((rightSection.logs.get(0).getText().contains(SELEN.element))&&(rightSection.logs.get(0).getText().contains(METAL.status)));


        //Silect in DropDown
        selectColor(YELLOW);
        Assert.assertTrue((rightSection.logs.get(0).getText().contains(YELLOW.getElement()))&&(rightSection.logs.get(0).getText().contains(COLORS.status)));

        //Unselect checkbox
        unselectAndCheckCheckbox(WATER);
        Assert.assertTrue((rightSection.logs.get(0).getText().contains(WATER.element))&&(rightSection.logs.get(0).getText().contains(FALSE.status)));

    }
}

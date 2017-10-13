package all_tests.different_elements_page;

import all_tests.init.SimpleTestsInit;
import org.mytests.uiobjects.example.enums.CheckBoxes;
import org.mytests.uiobjects.example.enums.Colors;
import org.mytests.uiobjects.example.enums.Metals;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Objects;

import static org.mytests.uiobjects.example.site.JDIExampleSite.*;
import static org.mytests.uiobjects.example.enums.CheckBoxes.*;
import static org.mytests.uiobjects.example.enums.Colors.GREEN;
import static org.mytests.uiobjects.example.enums.Colors.RED;
import static org.mytests.uiobjects.example.enums.Colors.YELLOW;
import static org.mytests.uiobjects.example.enums.HeaderMenu.DIFFERENT_ELEMENTS;
import static org.mytests.uiobjects.example.enums.HeaderMenu.HEADER_SERVICE;
import static org.mytests.uiobjects.example.enums.Metals.*;
import static org.mytests.uiobjects.example.enums.Status.*;

/**
 * Created by X240 on 10/12/2017.
 */
public class DifferentElementsTest extends SimpleTestsInit{
    @DataProvider(parallel = true)
    public Object[][] elementsProvider(){
        return new Object[][]{
                {EARTH, SELEN, YELLOW},
                {WIND, SILVER, GREEN},
                {WIND, SILVER, YELLOW},
                {WIND, BRONZE, RED}
        };
    }

    @Test(dataProvider = "elementsProvider", groups = "Different elements")
    public void elementsTest(CheckBoxes checkbox, Metals metal, Colors color){
        homePage.open();
        login();

        header.open(HEADER_SERVICE, DIFFERENT_ELEMENTS);

        selectAndCheckCheckbox(checkbox);
        selectMetal(metal);
        selectColor(color);

        if (!Objects.equals(RED.getElement(), color.getElement())) {
            Assert.assertTrue((rightSection.logs.get(0).getText().contains(color.getElement())));
            Assert.assertTrue((rightSection.logs.get(0).getText().contains(COLORS.status)));
            Assert.assertTrue((rightSection.logs.get(1).getText().contains(metal.getElement())));
            Assert.assertTrue((rightSection.logs.get(1).getText().contains(METAL.status)));
            Assert.assertTrue((rightSection.logs.get(2).getText().contains(checkbox.element)));
            Assert.assertTrue((rightSection.logs.get(2).getText().contains(TRUE.status)));
        }else {
            Assert.assertTrue((rightSection.logs.get(0).getText().contains(metal.getElement())));
            Assert.assertTrue((rightSection.logs.get(0).getText().contains(METAL.status)));
            Assert.assertTrue((rightSection.logs.get(1).getText().contains(checkbox.element)));
            Assert.assertTrue((rightSection.logs.get(1).getText().contains(TRUE.status)));
        }

        unselectAndCheckCheckbox(checkbox);
        Assert.assertTrue((rightSection.logs.get(0).getText().contains(checkbox.element)));
        Assert.assertTrue((rightSection.logs.get(0).getText().contains(FALSE.status)));
    }
}

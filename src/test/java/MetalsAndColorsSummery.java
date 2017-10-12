import init.SimpleTestsInit;
import org.junit.Assert;
import org.mytests.uiobjects.example.entities.MetalsAndColorsInfo;
import org.mytests.uiobjects.example.enums.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.JDIExampleSite.*;
import static org.mytests.uiobjects.example.enums.CheckBoxes.EARTH;
import static org.mytests.uiobjects.example.enums.Colors.BLUE;
import static org.mytests.uiobjects.example.enums.EvenNumbers.EIGHT;
import static org.mytests.uiobjects.example.enums.EvenNumbers.SIX;
import static org.mytests.uiobjects.example.enums.OddNumbers.FIVE;

/**
 * Created by X240 on 10/10/2017.
 */
public class MetalsAndColorsSummery extends SimpleTestsInit{

    @DataProvider(parallel = true)
    public Object[][] metalsAndColorsProvider(){
        return new Object[][]{
                {new MetalsAndColorsInfo(FIVE.element, EIGHT.element, BLUE.getElement(), Vegetables.TOMATO.element, EARTH.element)},
                {new MetalsAndColorsInfo(FIVE.element, "", BLUE.getElement(), Vegetables.TOMATO.element, EARTH.element)},
                {new MetalsAndColorsInfo("", SIX.element, BLUE.getElement(), Vegetables.TOMATO.element, EARTH.element)}
        };
    }

    @Test(dataProvider = "metalsAndColorsProvider")
    public void sumTest(MetalsAndColorsInfo info){
        homePage.open();
        login();
        homePage.checkOpened();

        header.open(HeaderMenu.HEADER_METALS_AND_COLORS);

        metalsAndColorsForm.submit(info);

        //Assert.assertTrue(rightSection.results.get(1).getText().contains(info.color));
        //Assert.assertTrue(rightSection.results.get(3).getText().contains(Vegetables.CUCUMBER.element));
        //Assert.assertTrue(rightSection.results.get(3).getText().contains(info.vegetable));
        Assert.assertTrue(rightSection.results.get(4).getText().contains(info.element));

    }
}

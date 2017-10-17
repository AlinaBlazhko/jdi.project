package all_tests.metals_and_colors_page;

import all_tests.init.SimpleTestsInit;
import org.mytests.uiobjects.example.entities.MetalsAndColorsInfo;
import org.mytests.uiobjects.example.enums.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Objects;

import static com.epam.web.matcher.testng.Assert.*;
import static org.mytests.uiobjects.example.site.JDIExampleSite.*;
import static org.mytests.uiobjects.example.enums.CheckBoxes.EARTH;
import static org.mytests.uiobjects.example.enums.CheckBoxes.WIND;
import static org.mytests.uiobjects.example.enums.Colors.BLUE;
import static org.mytests.uiobjects.example.enums.Colors.RED;
import static org.mytests.uiobjects.example.enums.Colors.YELLOW;
import static org.mytests.uiobjects.example.enums.EvenNumbers.EIGHT;
import static org.mytests.uiobjects.example.enums.EvenNumbers.SIX;
import static org.mytests.uiobjects.example.enums.OddNumbers.FIVE;
import static org.mytests.uiobjects.example.enums.Vegetables.*;
import static org.testng.Assert.*;

/**
 * Created by X240 on 10/10/2017.
 */
public class MetalsAndColorsSummery extends SimpleTestsInit {

    @DataProvider(parallel = true)
    public Object[][] metalsAndColorsProvider() {
        return new Object[][]{
                {new MetalsAndColorsInfo(FIVE.element, EIGHT.element, BLUE.getElement(), TOMATO.element, EARTH.element), true, true},
                {new MetalsAndColorsInfo(FIVE.element, "", YELLOW.getElement(), ONION.element, EARTH.element), true, false},
                {new MetalsAndColorsInfo("", SIX.element, BLUE.getElement(), TOMATO.element, EARTH.element), false, true},
                {new MetalsAndColorsInfo("", "", RED.getElement(), CUCUMBER.element, WIND.element), false, false},
                {new MetalsAndColorsInfo("", "", RED.getElement(), SALAD.element, WIND.element), false, false}
        };
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        homePage.open();
        login();
        header.open(HeaderMenu.HEADER_METALS_AND_COLORS);
    }

    @Test(dataProvider = "metalsAndColorsProvider", groups = "Metals and colors")
    public void sumTest(MetalsAndColorsInfo info, boolean odd, boolean even) {
        metalsAndColorsForm.submit(info);


        contains(rightSection.results.get(0).getText(), String.valueOf(getSum(info.odd, info.even, odd, even)));
        //contains(rightSection.results.get(1).getText(), "Colors");

        if (!Objects.equals(info.vegetable, SALAD.element)) {
            contains(rightSection.results.get(3).getText(), info.vegetable);
        } else {
            assertEquals(rightSection.results.get(3).getText(), "Vegetables:");
        }

    }

    private Integer getSum(String oddNumber, String evenNumber, boolean odd, boolean even) {
        int sum = 3;
        if (odd && even) {
            sum = Integer.parseInt(evenNumber) + Integer.parseInt(oddNumber);
        }

        if (odd && !even) {
            sum = Integer.parseInt(oddNumber) + 2;
        }

        if (!odd && even) {
            sum = Integer.parseInt(evenNumber) + 1;
        }
        return sum;
    }

}

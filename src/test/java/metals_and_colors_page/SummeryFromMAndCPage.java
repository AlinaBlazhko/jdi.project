package metals_and_colors_page;

import init.SimpleTestsInit;
import org.mytests.uiobjects.example.entities.SummeryInfo;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.site.JDIExampleSite.*;
import static org.mytests.uiobjects.example.enums.EvenNumbers.EIGHT;
import static org.mytests.uiobjects.example.enums.EvenNumbers.FOUR;
import static org.mytests.uiobjects.example.enums.HeaderMenu.HEADER_METALS_AND_COLORS;
import static org.mytests.uiobjects.example.enums.OddNumbers.SEVEN;
import static org.mytests.uiobjects.example.enums.OddNumbers.THREE;

/**
 * Created by X240 on 10/12/2017.
 */
public class SummeryFromMAndCPage extends SimpleTestsInit{

    @DataProvider(parallel = true)
    public Object[][] summeryProvider(){
        return new Object[][]{
                {new SummeryInfo("", ""), false, false},
                {new SummeryInfo(THREE.element, EIGHT.element), true, true},
                {new SummeryInfo("", FOUR.element), false, true},
                {new SummeryInfo(SEVEN.element, ""), true, false}
        };
    }

    @BeforeMethod
    public void beforeTest() {
        homePage.open();
        login();
    }

    @Test(dataProvider = "summeryProvider")
    public void summeryTest(SummeryInfo summeryInfo, boolean odd, boolean even){
        header.open(HEADER_METALS_AND_COLORS);

        summery.submit(summeryInfo, odd, even);


        Assert.assertTrue(rightSection.results.get(0).getText().contains(String.valueOf(summery.getSum(summeryInfo, odd, even))));
    }
}

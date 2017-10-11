import init.SimpleTestsInit;
import org.mytests.uiobjects.example.enums.HeaderMenu;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.JDIExampleSite.*;

/**
 * Created by X240 on 10/10/2017.
 */
public class MetalsAndColorsSummery extends SimpleTestsInit{
//    @DataProvider(parallel = true)
//    public Object[][] numbers() {
//        return new Object[][]{
//                //{new SumOfNumbers(ONE.element, TWO.element)},
//                {THREE, EIGHT}
//        };
//    }

    @Test//(dataProvider = "numbers")
    public void sumTest(){
        homePage.open();
        login();
        homePage.checkOpened();

        header.open(HeaderMenu.HEADER_METALS_AND_COLORS);

        metalsAndColors.odds.isDisplayed(1);
        //metalsAndColors.odds.select(THREE.ordinal());

    }
}

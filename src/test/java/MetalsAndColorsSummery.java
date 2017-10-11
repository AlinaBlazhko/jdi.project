import init.SimpleTestsInit;
import org.mytests.uiobjects.example.enums.HeaderMenu;
import org.mytests.uiobjects.example.enums.OddNumbers;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.JDIExampleSite.*;

/**
 * Created by X240 on 10/10/2017.
 */
public class MetalsAndColorsSummery extends SimpleTestsInit{

    @Test//(dataProvider = "numbers")
    public void sumTest(){
        homePage.open();
        login();
        homePage.checkOpened();

        header.open(HeaderMenu.HEADER_METALS_AND_COLORS);

        metalsAndColors.odds.select(OddNumbers.THREE.element);
    }
}

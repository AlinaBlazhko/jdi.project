package pagination;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import init.SimpleTestsInit;
import org.mytests.uiobjects.example.enums.LeftSectionMenu;
import org.mytests.uiobjects.example.enums.Pages;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.mytests.uiobjects.example.enums.HeaderMenu.*;
import static org.mytests.uiobjects.example.enums.Pages.*;
import static org.mytests.uiobjects.example.site.JDIExampleSite.*;

/**
 * Created by X240 on 10/13/2017.
 */
public class PaginationTestPrev extends SimpleTestsInit {
    @DataProvider(parallel = true)
    public Object[][] pagesProvider() {
        return new Object[][]{
                {THREE, FOUR, FIVE},
                {ONE, TWO, THREE},
                {FIVE, SIX, SEVEN},
                {SIX, SEVEN, EIGHT}
        };
    }

    @BeforeMethod
    public void beforeTest(){
        homePage.open();
        login();
    }

    @Test(dataProvider = "pagesProvider", groups = "Smoke")
    public void previousPageTest(Pages prev, Pages current, Pages next){
        switch (current.getIndex()) {
            case 1: contactPage.open();
            break;
            case 2: supportPage.open();
            break;
            case 3: datesPage.open();
            break;
            case 4: complexTablePage.open();
            break;
            case 5: simpleTablePage.open();
                break;
            case 6: tableWithPage.open();
                break;
            case 7: differentElementsPage.open();
                break;
            case 8: metalsAndColorsPage.open();
                break;
        }

        paginator.previous();
        Assert.assertEquals(WebPage.getTitle(), prev.getName());
    }

}

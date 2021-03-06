package all_tests.pagination;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import all_tests.init.SimpleTestsInit;
import org.mytests.uiobjects.example.enums.Pages;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.enums.Pages.*;
import static org.mytests.uiobjects.example.site.JDIExampleSite.*;
import static org.mytests.uiobjects.example.site.JDIExampleSite.paginator;

/**
 * Created by X240 on 10/13/2017.
 */
public class PaginationTestNext extends SimpleTestsInit{
    @DataProvider(parallel = true)
    public Object[][] pagesProvider() {
        return new Object[][]{
                {THREE, FOUR, FIVE},
                {ONE, TWO, THREE},
                {FIVE, SIX, SEVEN},
                {SIX, SEVEN, EIGHT}
        };
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(){
        homePage.open();
        login();
    }

    @Test(dataProvider = "pagesProvider", groups = "Pagination section")
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

        paginator.next();
        Assert.assertEquals(WebPage.getTitle(), next.getName());
    }
}

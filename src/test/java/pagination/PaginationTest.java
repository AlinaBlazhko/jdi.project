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
public class PaginationTest extends SimpleTestsInit {
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

    @Test(dataProvider = "pagesProvider")
    public void nextPageTest(Pages prev, Pages next){
        paginator.next();
        Assert.assertEquals(WebPage.getTitle(), next.getName());
    }

    @Test(dataProvider = "pagesProvider")
    public void previousPageTest(Pages prev, Pages current, Pages next){
        switch (current.getIndex()) {
            case 1:
        }
        paginator.previous();
        Assert.assertEquals(WebPage.getTitle(), prev.getName());
    }
}

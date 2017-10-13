package pagination;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import init.SimpleTestsInit;
import org.mytests.uiobjects.example.enums.Pages;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.site.JDIExampleSite.*;

/**
 * Created by X240 on 10/13/2017.
 */
public class PaginationTestFirstAndLast extends SimpleTestsInit{
    @BeforeMethod
    public void before(){
        homePage.open();
        login();
    }

    @Test(groups = "Smoke")
    public void lastFirstButtonTest(){
        complexTablePage.open();
        paginator.first();
        Assert.assertTrue(WebPage.getTitle().equals(Pages.ONE.getName()));
        paginator.last();
        Assert.assertTrue(WebPage.getTitle().equals(Pages.EIGHT.getName()));

    }
}

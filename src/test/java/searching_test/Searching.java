package searching_test;

import init.SimpleTestsInit;
import org.mytests.uiobjects.example.enums.HeaderMenu;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.mytests.uiobjects.example.JDIExampleSite.*;
import static org.mytests.uiobjects.example.enums.HeaderMenu.HEADER_SERVICE;
import static org.mytests.uiobjects.example.enums.HeaderMenu.TABLE_WITH_PAGES;


/**
 * Created by X240 on 10/11/2017.
 */
public class Searching extends SimpleTestsInit{
    @DataProvider(parallel = true)
    public Object[][] searchProvider() {
        return new Object[][]{
                {"LINQ", 2, "15"},
                {"MSTest", 2, "15"},
                {"Custom", 6, "15"},
                {"Custom", 5, "5"}
        };
    }
        @Test(dataProvider = "searchProvider")
    public void searchTest(String request, int responseCount, String rowCount){
        homePage.open();
        login();

        header.open(HEADER_SERVICE, TABLE_WITH_PAGES);

        search.countOfRows.select(rowCount);
        search.searchInput.input(request);
        Assert.assertEquals(search.rows.count(), responseCount);


    }

}

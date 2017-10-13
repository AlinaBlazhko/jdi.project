package simple_table_section;

import init.SimpleTestsInit;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.site.JDIExampleSite.*;
import static org.mytests.uiobjects.example.enums.HeaderMenu.HEADER_SERVICE;
import static org.mytests.uiobjects.example.enums.HeaderMenu.SIMPLE_TABLE;

/**
 * Created by X240 on 10/12/2017.
 */
public class SimpleTableTest extends SimpleTestsInit{
    @Test
    public void test(){
        homePage.open();
        login();

        header.open(HEADER_SERVICE, SIMPLE_TABLE);

        //simpleTable.table.get(3).click();
    }
}

import init.SimpleTestsInit;
import org.mytests.uiobjects.example.enums.HeaderMenu;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.JDIExampleSite.*;
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

        simpleTable.table.cell(1, 2).click();
    }
}

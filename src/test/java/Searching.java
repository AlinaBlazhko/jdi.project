import init.SimpleTestsInit;
import org.testng.annotations.Test;
import static org.mytests.uiobjects.example.JDIExampleSite.*;


/**
 * Created by X240 on 10/11/2017.
 */
public class Searching extends SimpleTestsInit{

    @Test
    public void searchTest(){
        homePage.open();
        login();


    }

}

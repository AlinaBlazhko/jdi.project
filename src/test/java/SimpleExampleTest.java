import init.SimpleTestsInit;
import org.testng.annotations.Test;

import static com.epam.commons.LinqUtils.select;
import static org.mytests.uiobjects.example.JDIExampleSite.*;
import static org.mytests.uiobjects.example.enums.CheckBoxes.WATER;
import static org.mytests.uiobjects.example.enums.CheckBoxes.WIND;
import static org.mytests.uiobjects.example.enums.Colors.BLUE;
import static org.mytests.uiobjects.example.enums.HeaderMenu.*;
import static org.mytests.uiobjects.example.enums.Metals.SILVER;

/**
 * Created by Roman_Iovlev on 5/26/2017.
 */
public class SimpleExampleTest extends SimpleTestsInit {

    @Test
    public void loginExample() {

        //Open login form and perform login
        homePage.open();
        login();
        homePage.checkOpened();

        //Check that elements from Home are visible
        checkExistenceOfElements();

        //Open contact form and fill in a fields
        contactPage.open();
        writingContactInfo();

        //open Different elements page
        header.open(HEADER_SERVICE, DIFFERENT_ELEMENTS);

        //Select some checkboxes, radioButton and element from dropdown
        selectAndCheckCheckbox(WATER);
        selectAndCheckCheckbox(WIND);
        selectMetal(SILVER);
        selectColor(BLUE);

        header.open(HEADER_SERVICE, DATES);

        //writingDatesForm();

    }
}

package contact_form_page;

import init.SimpleTestsInit;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.JDIExampleSite.*;
import static org.mytests.uiobjects.example.JDIExampleSite.writingContactInfo;

/**
 * Created by X240 on 10/7/2017.
 */
public class ContactForm extends SimpleTestsInit {
    @Test
    public void TestCF(){
        //Open login form and perform login
        homePage.open();
        login();
        homePage.checkOpened();

        //Check that elements from Home are visible
        checkExistenceOfElements();

        //Open contact form and fill in a fields
        contactPage.open();
        writingContactInfo();

    }
}

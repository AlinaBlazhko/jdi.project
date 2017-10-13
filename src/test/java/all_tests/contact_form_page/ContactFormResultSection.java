package all_tests.contact_form_page;

import all_tests.init.SimpleTestsInit;
import org.mytests.uiobjects.example.entities.ContactInfo;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.site.JDIExampleSite.*;
import static org.mytests.uiobjects.example.enums.DatesInfoEnum.*;
import static org.mytests.uiobjects.example.enums.EvenNumbers.FOUR;
import static org.mytests.uiobjects.example.enums.HeaderMenu.HEADER_CONTACT_FORM;
import static org.mytests.uiobjects.example.enums.Numbers.*;
import static org.mytests.uiobjects.example.enums.Numbers.EIGHT;
import static org.mytests.uiobjects.example.enums.OddNumbers.THREE;

/**
 * Created by X240 on 10/7/2017.
 */
public class ContactFormResultSection extends SimpleTestsInit {
    @DataProvider(parallel = true)
    public Object[][] contactProvider(){
        return new Object[][]{
                {new ContactInfo(NAME.element, LAST_NAME.element, DESCRIPTION.element, FIVE.element, FOUR.element)},
                {new ContactInfo(NAME.element, LAST_NAME.element, "", "", "")},
                {new ContactInfo(NAME.element, LAST_NAME.element, DESCRIPTION.element, "", EIGHT.element)},
                {new ContactInfo(NAME.element, LAST_NAME.element, DESCRIPTION.element, THREE.element, "")}
        };
    }

    @BeforeMethod
    public void beforeTest() {
        homePage.open();
        login();
    }

    @Test(dataProvider = "contactProvider", groups = "Contact form")
    public void TestCF(ContactInfo contactInfo){
        header.open(HEADER_CONTACT_FORM);

        int sum = 3;

        if (!contactInfo.odd.isEmpty() && !contactInfo.even.isEmpty()){
            sum = Integer.parseInt(contactInfo.odd) + Integer.parseInt(contactInfo.even);
        }

        if (contactInfo.odd.isEmpty() && !contactInfo.even.isEmpty()){
            sum = Integer.parseInt(contactInfo.even) + 1;
        }

        if (!contactInfo.odd.isEmpty() && contactInfo.even.isEmpty()){
            sum = Integer.parseInt(contactInfo.odd) + 2;
        }


        contactForm.submit(contactInfo);

        Assert.assertTrue(rightSection.results.get(0).getValue().contains(String.valueOf(sum)));
        Assert.assertTrue(rightSection.results.get(1).getValue().contains(String.valueOf(contactInfo.name)));
        Assert.assertTrue(rightSection.results.get(2).getValue().contains(String.valueOf(contactInfo.lastName)));
        if (!contactInfo.description.isEmpty()){
            Assert.assertTrue(rightSection.results.get(3).getValue().contains(String.valueOf(contactInfo.description)));
        }
    }
}

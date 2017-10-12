package contact_form_page;

import init.SimpleTestsInit;
import org.mytests.uiobjects.example.entities.ContactInfo;
import org.mytests.uiobjects.example.enums.EvenNumbers;
import org.mytests.uiobjects.example.enums.Numbers;
import org.mytests.uiobjects.example.enums.OddNumbers;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.JDIExampleSite.*;
import static org.mytests.uiobjects.example.enums.DatesInfoEnum.*;
import static org.mytests.uiobjects.example.enums.EvenNumbers.FOUR;
import static org.mytests.uiobjects.example.enums.OddNumbers.THREE;

/**
 * Created by X240 on 10/7/2017.
 */
public class ContactFormResultSection extends SimpleTestsInit {
    @DataProvider(parallel = true)
    public Object[][] contactProvider(){
        return new Object[][]{
                {new ContactInfo(NAME.element, LAST_NAME.element, DESCRIPTION.element, Numbers.FIVE.element, Numbers.FOUR.element)},
                {new ContactInfo(NAME.element, LAST_NAME.element, DESCRIPTION.element, "", "")},
        };
    }

    @Test(dataProvider = "contactProvider")
    public void TestCF(ContactInfo contactInfo){
        //Open login form and perform login
        homePage.open();
        login();

        //Open contact form and fill in a fields
        contactPage.open();

        int sum;

        //Submit form
        if (contactInfo.odd.isEmpty()&&contactInfo.even.isEmpty()){
            sum = 3;
        }else {
            contactForm.numbers.select(contactInfo.odd);
            contactForm.numbers.select(contactInfo.even);
            sum = Integer.parseInt(contactInfo.even) + Integer.parseInt(contactInfo.odd);
        }

        contactForm.submit(contactInfo);

        Assert.assertTrue(rightSection.results.get(0).getValue().contains(String.valueOf(sum)));
        Assert.assertTrue(rightSection.results.get(1).getValue().contains(String.valueOf(contactInfo.name)));
        Assert.assertTrue(rightSection.results.get(2).getValue().contains(String.valueOf(contactInfo.lastName)));
        Assert.assertTrue(rightSection.results.get(3).getValue().contains(String.valueOf(contactInfo.description)));
    }
}

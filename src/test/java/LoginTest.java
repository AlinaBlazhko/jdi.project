import init.SimpleTestsInit;
import org.mytests.uiobjects.example.entities.User;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.JDIExampleSite.*;
import static org.mytests.uiobjects.example.enums.LeftSectionMenu.LEFT_CONTACT_FORM;
import static org.mytests.uiobjects.example.enums.UserName.PITER_CHAILOVSKII;

/**
 * Created by X240 on 10/6/2017.
 */
public class LoginTest extends SimpleTestsInit {

    @DataProvider(parallel = true)
    public Object[][] loginProvider(){
        return new Object[][]{
                {new User("login", "password"), false},
                {new User("epam", "1234"), true},
                {new User("", ""), false},
                {new User("epam", "abcd"), false}

        };
    }

    @Test(dataProvider = "loginProvider")
    public void loginTest(User user, Boolean checkDates) {
        homePage.open();
        homePage.checkOpened();

        profilePhoto.click();
        loginForm.loginAs(user);

        if (checkDates) {
            Assert.assertEquals(profilePhoto.getText(), PITER_CHAILOVSKII.getName());
        } else {
            Assert.assertTrue(loginForm.faildText.isDisplayed());
        }
    }
}

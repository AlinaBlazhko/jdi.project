package org.mytests.uiobjects.example;

import com.epam.jdi.uitests.web.selenium.elements.common.Image;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import org.mytests.uiobjects.example.entities.ContactInfo;
import org.mytests.uiobjects.example.entities.User;
import org.mytests.uiobjects.example.enums.CheckBoxes;
import org.mytests.uiobjects.example.enums.Colors;
import org.mytests.uiobjects.example.enums.Metals;
import org.mytests.uiobjects.example.pages.*;
import org.mytests.uiobjects.example.section_and_form.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import static org.mytests.uiobjects.example.enums.HeaderMenu.HEADER_SERVICE;
import static org.mytests.uiobjects.example.enums.LeftSectionMenu.LEFT_SERVICE;
import static org.mytests.uiobjects.example.enums.UserName.PITER_CHAILOVSKII;

/**
 * Created by Roman_Iovlev on 8/30/2015.
 */
@JSite(domain = "https://epam.github.io/JDI/")
public class JDIExampleSite extends WebSite {

    public static HomePage homePage;

    public static LoginForm loginForm;

    public static ContactPage contactPage;

    private static ContactForm contactForm;

    public static DifferentElements differentElements;

    public static MetalsAndColors metalsAndColors;

    public static Header header;

    public static RightSection rightSection;

    public static LeftSection leftSection;

    public static Dates dates;

    public static TableWithPagesSearch search;

    public static DatesPage datesPage;

    @FindBy(css = ".profile-photo")
    public static Label profilePhoto;

    @Step("Perform login")
    public static void login() {
        profilePhoto.click();
        loginForm.loginAs(new User());
        Assert.assertEquals(profilePhoto.getText(), PITER_CHAILOVSKII.getName());
    }

    @Step
    public  static void search(){
        search.searchInput.input("Assert");

    }


    @Step("Check interface on Home page")
    public static void checkExistenceOfElements(){

        homePage.mainTitle.isDisplayed();
        homePage.mainText.isDisplayed();

        for (Image i: homePage.icons) {
            i.isDisplayed();
        }

        for (Text i: homePage.texts) {
            i.isDisplayed();
        }
    }
    @Step
    public static void writingContactInfo(){
        contactForm.submit(new ContactInfo());
    }

    @Step("Select and assert checkboxes")
    public static void selectAndCheckCheckbox(CheckBoxes checkBoxes){
        differentElements.checkBoxes.get(checkBoxes.ordinal()).check();
        differentElements.checkBoxes.get(checkBoxes.ordinal()).isChecked();
    }

    @Step("Unselect and assert checkboxes")
    public static void unselectAndCheckCheckbox(CheckBoxes checkBoxes){
        differentElements.checkBoxes.get(checkBoxes.ordinal()).uncheck();
    }

    @Step("Select and assert radio button")
    public static void selectMetal(Metals metal){
        differentElements.radioButtons.select(metal.ordinal() + 1);
        differentElements.radioButtons.isSelected(metal.name());
    }



    @Step("Select in dropdown")
    public static void selectColor(Colors color){
        differentElements.colors.select(color.ordinal()+1);
    }

    @Step
    public static void submitFromDifferentElements(){
        differentElements.button.click();
    }


    @Step("Check that dropdown on Left section contains all options")
    public static void containingElementLeftSection(){
            leftSection.open(LEFT_SERVICE);
            leftSection.serviceMenu.isDisplayed();
    }

    @Step("Check that dropdown on Left section contains all options")
    public static void containingElementHeader(){
        header.open(HEADER_SERVICE);
        header.serviceMenu.isDisplayed();
    }

    @Step("Check interface on Different elements page")
    public static void containingElementDifferentElements(){
        differentElements.checkBoxes.isDisplayed();
        differentElements.radioButtons.isDisplayed();
        differentElements.button.isDisplayed();
        differentElements.defaultButton.isDisplayed();
        rightSection.logs.isDisplayed();
        rightSection.results.isDisplayed();
    }
}

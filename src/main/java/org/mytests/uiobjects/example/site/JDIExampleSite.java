package org.mytests.uiobjects.example.site;

import com.epam.jdi.uitests.web.selenium.elements.common.Image;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import org.mytests.uiobjects.example.entities.User;
import org.mytests.uiobjects.example.enums.CheckBoxes;
import org.mytests.uiobjects.example.enums.Colors;
import org.mytests.uiobjects.example.enums.Metals;
import org.mytests.uiobjects.example.form.*;
import org.mytests.uiobjects.example.pages.*;
import org.mytests.uiobjects.example.sections.Header;
import org.mytests.uiobjects.example.sections.LeftSection;
import org.mytests.uiobjects.example.sections.RightSection;
import org.mytests.uiobjects.example.sections.SimpleTableSection;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import all_tests.pagination.JdiPaginator;
import ru.yandex.qatools.allure.annotations.Step;

import static org.mytests.uiobjects.example.enums.HeaderMenu.HEADER_SERVICE;
import static org.mytests.uiobjects.example.enums.LeftSectionMenu.LEFT_SERVICE;
import static org.mytests.uiobjects.example.enums.UserName.PITER_CHAILOVSKII;

/**
 * Created by Roman_Iovlev on 8/30/2015.
 */
@JSite(domain = "https://epam.github.io/JDI/")
public class JDIExampleSite extends WebSite{
    //pages
    public static HomePage homePage;
    public static ContactPage contactPage;
    public static SupportPage supportPage;
    public static DatesPage datesPage;
    public static ComplexTablePage complexTablePage;
    public static SimpleTable simpleTablePage;
    public static TableWithPages tableWithPage;
    public static DifferentElements differentElementsPage;
    public static MetalsAndColors metalsAndColorsPage;



    public static LoginForm loginForm;
    public static ContactForm contactForm;
    public static MetalsAndColorsForm metalsAndColorsForm;
    public static Header header;
    public static RightSection rightSection;
    public static LeftSection leftSection;
    public static DatesForm dates;
    public static TableWithPagesSearch search;
    public static Summery summery;
    public static SimpleTableSection simpleTable;
    public static JdiPaginator paginator;


    @FindBy(css = ".profile-photo")
    public static Label profilePhoto;

    @Step("Perform login")
    public static void login() {
        profilePhoto.click();
        loginForm.loginAs(new User());
        Assert.assertEquals(profilePhoto.getText(), PITER_CHAILOVSKII.getName());
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

    @Step("Select and assert checkboxes")
    public static void selectAndCheckCheckbox(CheckBoxes checkBoxes){
        differentElementsPage.checkBoxes.get(checkBoxes.ordinal()).check();
        //Assert.assertTrue(differentElementsPage.checkBoxes.get(checkBoxes.ordinal()).isChecked());
    }

    @Step("Unselect and assert checkboxes")
    public static void unselectAndCheckCheckbox(CheckBoxes checkBoxes){
        differentElementsPage.checkBoxes.get(checkBoxes.ordinal()).uncheck();
    }

    @Step("Select and assert radio button")
    public static void selectMetal(Metals metal){
        differentElementsPage.radioButtons.select(metal.ordinal() + 1);
    }

    @Step("Select in dropdown")
    public static void selectColor(Colors color){
        differentElementsPage.colors.select(color.ordinal()+1);
    }

    @Step
    public static void submitFromDifferentElements(){
        differentElementsPage.button.click();
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
        differentElementsPage.checkBoxes.isDisplayed();
        differentElementsPage.radioButtons.isDisplayed();
        differentElementsPage.button.isDisplayed();
        differentElementsPage.defaultButton.isDisplayed();
        rightSection.logs.isDisplayed();
        rightSection.results.isDisplayed();
    }
}

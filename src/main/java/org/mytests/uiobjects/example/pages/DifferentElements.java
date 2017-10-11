package org.mytests.uiobjects.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.web.selenium.elements.common.*;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.mytests.uiobjects.example.enums.DragAndDrop;
import org.mytests.uiobjects.example.enums.Metals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Period;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.actions;


/**
 * Created by X240 on 10/2/2017.
 */
@JPage(url = "/page8.htm")
public class DifferentElements extends WebPage {
    @FindBy(css = "label.label-checkbox input")
    public Elements<CheckBox> checkBoxes;

    @FindBy(css = "label.label-radio input")
    public RadioButtons<Metals> radioButtons;

    public IDropDown colors = new Dropdown<>(
            By.cssSelector("div.colors"),
            By.cssSelector("select.uui-form-element option")
    );

    @FindBy(css = "uui-button button")
    public Button defaultButton;

    @FindBy(css = "input.uui-button")
    public Button button;

}

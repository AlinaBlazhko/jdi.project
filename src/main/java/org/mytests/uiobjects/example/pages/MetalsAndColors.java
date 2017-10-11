package org.mytests.uiobjects.example.pages;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.CheckBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.ComboBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.mytests.uiobjects.example.enums.EvenNumbers;
import org.mytests.uiobjects.example.enums.OddNumbers;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

/**
 * Created by X240 on 10/3/2017.
 */

@JPage(url = "/page2.htm")
public class MetalsAndColors {
    @FindBy(css = "section.horizontal-group input")
    public RadioButtons<OddNumbers> odds;

    @FindBy(css = "#even-selector p")
    public RadioButtons<EvenNumbers> evens;

    @FindBy(id = "calculate-button")
    public IButton calculate;

    @FindBy(css = ".uui-form-element.blue")
    public Elements<CheckBox> power;

    @FindBy(css = "#submit-button")
    public Button submit;

    public IDropDown colors = new Dropdown<>(
            By.cssSelector("div.btn-group.bootstrap-select.uui-form-element.dropup"),
            By.xpath("//div[contains(@class, 'btn-group bootstrap-select uui-form-element open dropup')]/div[contains(@class, 'dropdown-menu open')]")
    );

//    public IDropDown vegetables = new Dropdown<>(
//            By.cssSelector("div.btn-group.bootstrap-select.uui-form-element.dropup"),
//            By.xpath("//div[contains(@class, 'btn-group bootstrap-select uui-form-element open dropup')]/div[contains(@class, 'dropdown-menu open')]")
//    );


    
}

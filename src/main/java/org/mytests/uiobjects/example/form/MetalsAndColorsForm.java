package org.mytests.uiobjects.example.form;

import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.CheckBox;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.mytests.uiobjects.example.entities.MetalsAndColorsInfo;
import org.mytests.uiobjects.example.enums.EvenNumbers;
import org.mytests.uiobjects.example.enums.OddNumbers;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

/**
 * Created by X240 on 10/12/2017.
 */
public class MetalsAndColorsForm extends Form<MetalsAndColorsInfo> {
    @FindBy(css = "#odds-selector label")
    private RadioButtons<OddNumbers> odds;

    @FindBy(css = "#even-selector label")
    private RadioButtons<EvenNumbers> evens;

    @FindBy(id = "calculate-button")
    public Button calculate;

    @FindBy(css = "div.form-group.colors")
    public Button color;

    @FindBy(css = "ul.dropdown-menu.inner.selectpicker li")
    public Elements<Label> colors;


    @FindBy(css = "div#salad-dropdown.dropdown.salad")
    public Label food;

    @FindBy(css = "ul.dropdown-menu label")
    public Elements<CheckBox> vegetables;

    @FindBy(css = "#submit-button")
    public Button submit;

    @Override
    public void submit(MetalsAndColorsInfo info) {
        if (!info.odd.isEmpty()) {
            odds.select(info.odd);
        }
        if (!info.even.isEmpty()) {
            evens.select(info.even);
        }
        color.click();
        colors.get(info.color).click();
        food.click();
        vegetables.get(info.vegetable).click();
        super.submit(info);
    }

}

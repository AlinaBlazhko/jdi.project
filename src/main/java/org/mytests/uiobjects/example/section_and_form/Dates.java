package org.mytests.uiobjects.example.section_and_form;

import com.epam.jdi.uitests.core.annotations.Mandatory;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextArea;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.mytests.uiobjects.example.entities.DatesInfo;
import org.openqa.selenium.support.FindBy;


/**
 * Created by X240 on 10/3/2017.
 */

//@JPage(url = "/page4.htm")
public class Dates extends Form<DatesInfo>{

    @Mandatory
    @FindBy(css = "#Name")
    public TextField name;

    @Mandatory
    @FindBy(css = "#LastName")
    public TextField lastName;

    @FindBy(css = "#Description")
    public TextArea description;

//    @Mandatory
//    @FindBy(css = "div.range-from.overflow>input")
//    public Elements<TextField> range1;

    @Mandatory
    @FindBy(xpath = "//div[contains(@class, 'range-from overflow')]/input[contains(@class, 'uui-form-element')][1]")
    public TextField from;

    @Mandatory
    @FindBy(xpath = "//div[contains(@class, 'range-from overflow')]/input[contains(@class, 'uui-form-element')][2]")
    public TextField to;

    //??
    @FindBy(css = "div.date.uui-datepicker.date-button.small input")
    public TextField datePicker;

    @FindBy(css = "div.input-append.bootstrap-timepicker.uui-timepicker.time-button input")
    public TextField timePicker;

    @FindBy(css = "button.uui-button.dark-blue.m-t35")
    public Button submit;
}

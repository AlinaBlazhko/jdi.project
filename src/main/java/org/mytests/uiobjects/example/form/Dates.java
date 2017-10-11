package org.mytests.uiobjects.example.form;

import com.codeborne.selenide.SelenideElement;
import com.epam.jdi.uitests.core.annotations.Mandatory;
import com.epam.jdi.uitests.web.selenium.elements.common.*;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextArea;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.mytests.uiobjects.example.entities.DatesInfo;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.actions;


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

    @FindBy(css = ".uui-slider.blue.range.ui-slider")
    private SelenideElement sliderTrack;

    @FindBy(css = ".ui-slider-handle")
    public Elements<Link> sliders;

    private Double getStepInPixels() {
        return sliderTrack.getSize().width / 100.0;
    }

    private Double getPosInPixels(Link slider) {
        return Double.parseDouble(slider.getWebElement().getCssValue("left")
                .replaceAll("px", "")) + slider.getWebElement().getSize().width / 2.0;
    }

    private int getSliderPosition(Link slider) {
        return new Integer(slider.getText());
    }

    private void correctPosition(Link slider, int position) {
        int currPos = getSliderPosition(slider);
        if (currPos == position)
            return;
        int xOffset = (int) Math.round(getStepInPixels());
        int yOffset = 0;
        if (currPos > position)
            xOffset *= -1;
        while (currPos != position) {
            slider.dragAndDropBy(xOffset, yOffset);
            currPos = getSliderPosition(slider);
        }
    }

    private void moveSliderToPos(Link slider, int position) {
        int xOffset = (int) Math.round(position * getStepInPixels() - getPosInPixels(slider));
        int yOffset = 0;
        slider.dragAndDropBy(xOffset, yOffset);
        correctPosition(slider, position);
    }

    public void setSliders(int leftSliderPos, int rightSliderPos) {
        if (rightSliderPos < leftSliderPos)
            return;
        sliderTrack.scrollTo();
        if (getSliderPosition(sliders.get(1)) <= leftSliderPos) {
            moveSliderToPos(sliders.get(1), rightSliderPos);
            moveSliderToPos(sliders.get(0), leftSliderPos);
        } else {
            moveSliderToPos(sliders.get(0), leftSliderPos);
            moveSliderToPos(sliders.get(1), rightSliderPos);
        }
    }
//    public void checkSliders(int leftSliderPos, int rightSliderPos) {
//        sliderTrack.scrollTo();
//        sliders.get(0).getWebElement().shouldHave(exactText(Integer.toString(leftSliderPos)));
//        sliders.get(1).shouldHave(exactText(Integer.toString(rightSliderPos)));
//    }


}

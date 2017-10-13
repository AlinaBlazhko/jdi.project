package org.mytests.uiobjects.example.form;

import com.codeborne.selenide.SelenideElement;
import com.epam.jdi.uitests.core.annotations.Mandatory;
import com.epam.jdi.uitests.core.interfaces.complex.FormFilters;
import com.epam.jdi.uitests.web.selenium.elements.common.*;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextArea;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.composite.Pagination;
import org.mytests.uiobjects.example.entities.DatesInfo;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.actions;
import static com.epam.jdi.uitests.core.interfaces.complex.FormFilters.ALL;
import static com.epam.jdi.uitests.core.interfaces.complex.FormFilters.MANDATORY;
import static com.epam.jdi.uitests.core.interfaces.complex.FormFilters.OPTIONAL;
import static org.mytests.uiobjects.example.site.JDIExampleSite.rightSection;
import static org.testng.Assert.assertEquals;


/**
 * Created by X240 on 10/3/2017.
 */

//@JPage(url = "/page4.htm")
public class DatesForm extends Form<DatesInfo>{

    @Mandatory
    @FindBy(css = "#Name")
    public TextField name;

    @Mandatory
    @FindBy(css = "#LastName")
    public TextField lastName;

    @FindBy(css = "#Description")
    public TextArea description;

    @Mandatory
    @FindBy(css = ".range-from input")
    private Elements<TextField> range1;

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

    public void fillRange1(DatesInfo info){
        if (currentFilter != MANDATORY){
            setSliders(info.range2.from, info.range2.to);
            range1.get(0).sendKeys(String.valueOf(info.range1.from));
            range1.get(1).sendKeys(String.valueOf(info.range1.to));
        }
        if (currentFilter != OPTIONAL){
            range1.get(0).sendKeys(String.valueOf(info.range1.from));
            range1.get(1).sendKeys(String.valueOf(info.range1.to));
        }
    }
    private Double getStepInPixels() {
        return sliderTrack.getSize().width / 100.0;
    }

    private Double getPosInPixels(Link slider) {
        return Double.parseDouble(slider.getWebElement().getCssValue("left")
                .replaceAll("px", "")) + slider.getWebElement().getSize().width / 2.0;
    }

    private FormFilters currentFilter = ALL;

    @Override
    public void filter(FormFilters filter){
        currentFilter = filter;
        super.filter(filter);
    }

    @Override
    public void submit(DatesInfo datesInfo){
        if (currentFilter != MANDATORY){
            setSliders(datesInfo.range2.from, datesInfo.range2.to);
        }
        if (currentFilter != OPTIONAL){
            range1.get(0).sendKeys(String.valueOf(datesInfo.range1.from));
            range1.get(1).sendKeys(String.valueOf(datesInfo.range1.to));
        }
        super.submit(datesInfo);
    }

    public void fillRange(DatesInfo datesInfo){
        if (currentFilter != OPTIONAL) {
            range1.get(0).sendKeys(String.valueOf(datesInfo.range1.from));
            range1.get(1).sendKeys(String.valueOf(datesInfo.range1.to));
        }
    }



    public void verifyResultForAll(DatesInfo datesInfo){
            Assert.assertTrue(rightSection.results.get(0).getText().contains(datesInfo.name));
            Assert.assertTrue(rightSection.results.get(1).getText().contains(datesInfo.lastName));
            Assert.assertTrue(rightSection.results.get(2).getText().contains(datesInfo.description));
            Assert.assertTrue(rightSection.results.get(3).getText().contains(datesInfo.datePicker));
            Assert.assertTrue(rightSection.results.get(4).getText().contains(datesInfo.timePicker));
            Assert.assertTrue(rightSection.results.get(5).getText().contains(String.valueOf(datesInfo.range1.from)));
            Assert.assertTrue(rightSection.results.get(5).getText().contains(String.valueOf(datesInfo.range1.to)));
            Assert.assertTrue(rightSection.results.get(6).getText().contains(String.valueOf(datesInfo.range2.from)));
            Assert.assertTrue(rightSection.results.get(6).getText().contains(String.valueOf(datesInfo.range2.to)));

    }
    public void clickButton(){
        submit.click();
    }

    //Sliders
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
    public void checkSliders(int leftSliderPos, int rightSliderPos) {
        sliderTrack.scrollTo();
        assertEquals(sliders.get(0).getValue(), Integer.toString(leftSliderPos));
        assertEquals(sliders.get(1).getValue(), Integer.toString(leftSliderPos));
    }



}

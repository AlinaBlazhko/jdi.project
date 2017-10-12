package org.mytests.uiobjects.example.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;


/**
 * Created by X240 on 10/3/2017.
 */
public class RightSection extends Section {

    @FindBy(css = ".panel-body-list.logs>li")
    public Elements<Label> logs;

    @FindBy(css = ".panel-body-list.results>li")
    public  Elements<Label> results;
}

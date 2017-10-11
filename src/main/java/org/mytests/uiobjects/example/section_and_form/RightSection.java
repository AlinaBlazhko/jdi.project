package org.mytests.uiobjects.example.section_and_form;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.complex.ITextList;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;
import sun.nio.cs.ext.IBM037;
import sun.swing.SwingUtilities2;



/**
 * Created by X240 on 10/3/2017.
 */
public class RightSection extends Section {

    @FindBy(css = ".panel-body-list.logs>li")
    public Elements<Label> logs;

    @FindBy(css = ".panel-body-list.results>li")
    public  Elements<Label> results;
}

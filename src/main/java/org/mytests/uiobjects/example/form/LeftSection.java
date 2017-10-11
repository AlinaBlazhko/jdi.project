package org.mytests.uiobjects.example.form;

import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.mytests.uiobjects.example.enums.LeftSectionMenu;
import org.openqa.selenium.support.FindBy;

/**
 * Created by X240 on 10/3/2017.
 */
public class LeftSection extends Section{
    @FindBy(css = ".sidebar-menu li a")
    private Menu<LeftSectionMenu> headerMenu;

    @FindBy(css = ".sub li a")
    public IDropDown<LeftSectionMenu> serviceMenu;

    public void open(LeftSectionMenu...enums){

        headerMenu.clickOn(enums[0].getElement());

        if (enums.length == 2){
            serviceMenu.select(enums[1].getElement());
        }
    }
}

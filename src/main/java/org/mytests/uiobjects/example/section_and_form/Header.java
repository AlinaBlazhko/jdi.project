package org.mytests.uiobjects.example.section_and_form;

import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.mytests.uiobjects.example.enums.HeaderMenu;
import org.openqa.selenium.support.FindBy;

/**
 * Created by X240 on 10/2/2017.
 */
public class Header extends Section {
    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 li a")
    private Menu<HeaderMenu> headerMenu;

    @FindBy(css = ".dropdown-menu li a")
    public IDropDown<HeaderMenu> serviceMenu;

    public void open(HeaderMenu...enums){

        headerMenu.clickOn(enums[0].getElement());

        if (enums.length == 2){
            serviceMenu.select(enums[1].getElement());
        }
    }

}

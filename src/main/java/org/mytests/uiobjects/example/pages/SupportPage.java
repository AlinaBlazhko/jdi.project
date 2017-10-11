package org.mytests.uiobjects.example.pages;

import com.epam.jdi.uitests.core.interfaces.common.IText;
import com.epam.jdi.uitests.core.interfaces.complex.interfaces.ITable;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.Table;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

/**
 * Created by X240 on 10/6/2017.
 */

@JPage(url = "/page3.htm")
public class SupportPage {
    @FindBy(css = "table.uui-table stripe")
    public Table table;
}

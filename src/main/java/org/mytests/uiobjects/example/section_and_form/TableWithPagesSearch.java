package org.mytests.uiobjects.example.section_and_form;

import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.Table;
import com.epam.jdi.uitests.web.selenium.elements.composite.Search;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JTable;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

/**
 * Created by X240 on 10/11/2017.
 */
public class TableWithPagesSearch extends Search{
    @FindBy(css = "div.dataTables_filter input")
    public TextField searchInput;

    public IDropDown colors = new Dropdown<>(
            By.className("DataTables_Table_0_length"),
            By.cssSelector("select.uui-form-element option")
    );

    @FindBy(css = "tr.odd")
    public TextList oddRow;

    @FindBy(css = "tr.even")
    public Elements<Text> evenRow;
}

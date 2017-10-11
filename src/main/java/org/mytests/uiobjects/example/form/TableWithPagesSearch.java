package org.mytests.uiobjects.example.form;

import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.Search;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

/**
 * Created by X240 on 10/11/2017.
 */
public class TableWithPagesSearch extends Search{
    @FindBy(css = "div.dataTables_filter input")
    public TextField searchInput;

    public IDropDown countOfRows = new Dropdown<>(
            By.className("DataTables_Table_0_length"),
            By.cssSelector("select.uui-form-element option")
    );

    @FindBy(css = "table#DataTables_Table_0.uui-table.dynamic.stripe.records-per-page.search.showing-pages.paging.dataTable.no-footer>tbody>tr")
    public TextList rows;

//    @FindBy(css = "tr.odd")
//    public TextList oddRow;
//
//    @FindBy(css = "tr.even")
//    public Elements<Text> evenRow;
}

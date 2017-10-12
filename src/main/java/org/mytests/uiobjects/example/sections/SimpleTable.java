package org.mytests.uiobjects.example.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.table.Table;
import org.openqa.selenium.By;

/**
 * Created by X240 on 10/12/2017.
 */
public class SimpleTable {
    public Table table = new Table(
        By.cssSelector("table.uui-table.stripe.tbl-without-header.table-td-click"),
        By.cssSelector("table.uui-table.stripe.tbl-without-header.table-td-click td")
    );
}

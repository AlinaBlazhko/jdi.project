package org.mytests.uiobjects.example.enums;

/**
 * Created by X240 on 9/29/2017.
 */
public enum DropDownMenu {
    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    TABLE_WITH_PAGES("Table with pages"),
    DIFFERENT_ELEMENTS("Different elements"),
    PROFILE_NAME("Piter Chailovskii");

    String element;

    DropDownMenu(String element){
        this.element = element;
    }
}

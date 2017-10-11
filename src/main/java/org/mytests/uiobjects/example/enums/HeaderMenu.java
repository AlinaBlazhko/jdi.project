package org.mytests.uiobjects.example.enums;

/**
 * Created by X240 on 9/29/2017.
 */
public enum HeaderMenu {

    //header menu
    HEADER_HOME("HOME"),
    HEADER_CONTACT_FORM("CONTACT FORM"),
    HEADER_SERVICE("SERVICE"),
    HEADER_METALS_AND_COLORS("METALS & COLORS"),

    //dropdown menu
    SUPPORT("SUPPORT"),
    DATES("DATES"),
    COMPLEX_TABLE("COMPLEX TABLE"),
    SIMPLE_TABLE("SIMPLE TABLE"),
    TABLE_WITH_PAGES("TABLE WITH PAGES"),
    DIFFERENT_ELEMENTS("DIFFERENT ELEMENTS");

    String element;

    public String getElement(){
        return element;
    }

    HeaderMenu(String element){
        this.element = element;
    }
}

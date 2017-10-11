package org.mytests.uiobjects.example.enums;

/**
 * Created by X240 on 10/3/2017.
 */
public enum  LeftSectionMenu {
    //menu from left section
    LEFT_HOME("Home"),
    LEFT_CONTACT_FORM("Contact form"),
    LEFT_SERVICE("Service"),
    LEFT_METALS_AND_COLORS("Metals & Colors"),

    //dropdown menu
    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    TABLE_WITH_PAGES("Table with pages"),
    DIFFERENT_ELEMENTS("Different elements");

    String element;

    public String getElement(){
        return element;
    }

    LeftSectionMenu(String element){
        this.element = element;
    }
}

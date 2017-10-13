package org.mytests.uiobjects.example.enums;

/**
 * Created by X240 on 10/13/2017.
 */
public enum Pages{
    ONE(1, "Contact Form"),
    TWO(2, "Support"),
    THREE(3, "Dates"),
    FOUR(4, "Complex Table"),
    FIVE(5, "Simple Table"),
    SIX(6, "Table with pages"),
    SEVEN(7, "Different Element"),
    EIGHT(8, "Metal and Colors");

    Integer index;
    String name;

    public String getName(){
        return name;
    }

    public Integer getIndex(){
        return index;
    }

    Pages(Integer index, String name){
        this.index = index;
        this.name = name;
    }
}

package org.mytests.uiobjects.example.enums;

/**
 * Created by X240 on 10/2/2017.
 */
public enum Metals {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    public String element;

    public String getElement(){
        return element;
    }

    Metals(String element){
        this.element = element;
    }


}

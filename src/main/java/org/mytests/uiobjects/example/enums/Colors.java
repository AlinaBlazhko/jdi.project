package org.mytests.uiobjects.example.enums;

/**
 * Created by X240 on 10/2/2017.
 */
public enum Colors {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    String element;

    public String getElement(){
        return element;
    }

    Colors(String element){
        this.element = element;
    }
}

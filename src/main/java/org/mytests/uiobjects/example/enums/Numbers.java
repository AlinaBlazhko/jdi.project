package org.mytests.uiobjects.example.enums;

/**
 * Created by X240 on 10/12/2017.
 */
public enum Numbers {
    ONE("1"),
    THREE("3"),
    FIVE("5"),
    SEVEN("7"),
    NINE("9"),
    TWO("2"),
    FOUR("4"),
    SIX("6"),
    EIGHT("8");

    public String element;

    public String getElement(){
        return element;
    }


    Numbers(String element){
        this.element = element;
    }
}

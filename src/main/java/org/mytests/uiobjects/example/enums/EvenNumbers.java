package org.mytests.uiobjects.example.enums;

/**
 * Created by X240 on 10/3/2017.
 */
public enum EvenNumbers {
    TWO("2", 2),
    FOUR("4", 4),
    SIX("6", 6),
    EIGHT("8", 8);

    public String element;
    public int number;

    public String getElement(){
        return element;
    }

    public Integer getNumber(){
        return number;
    }

    EvenNumbers(String element, int number){
        this.element = element;
        this.number = number;
    }
}

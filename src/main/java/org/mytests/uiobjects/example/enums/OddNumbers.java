package org.mytests.uiobjects.example.enums;

/**
 * Created by X240 on 10/3/2017.
 */
public enum OddNumbers {
    ONE("1"),
    THREE("3"),
    FIVE("5"),
    SEVEN("7"),
    NINE("9");

    public String element;

    public String getElement(){
        return element;
    }

    public Integer getNumber(){
        return Integer.parseInt(element);
    }

    OddNumbers(String element){
        this.element = element;
    }
}

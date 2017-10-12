package org.mytests.uiobjects.example.enums;

import com.epam.jdi.uitests.web.selenium.elements.base.IHasElement;

/**
 * Created by X240 on 10/12/2017.
 */
public enum Vegetables{
    CUCUMBER("Cucumber"),
    TOMATO("Tomato"),
    SALAD("Salad"),
    ONION("Onion");

    public String element;

    Vegetables(String element){
        this.element = element;
    }
}

package org.mytests.uiobjects.example.enums;

import com.epam.jdi.uitests.web.selenium.elements.base.IHasElement;

/**
 * Created by X240 on 10/10/2017.
 */
public enum DragAndDrop{
    LEFT(0),
    RIGHT(1);

    public int element;

    DragAndDrop(int element){
        this.element = element;
    }
}

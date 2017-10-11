package org.mytests.uiobjects.example.enums;

/**
 * Created by X240 on 10/7/2017.
 */
public enum  DatesInfoEnum {
    NAME("Alina"),
    LAST_NAME("Blazhko"),
    DESCRIPTION("Student"),
    FROM("12"),
    TO("13"),
    DATE_PICKER("10/17/2017"),
    TIME_PICKER("3:15 PM");

    public String element;

    public String getElement(){
        return element;
    }

    DatesInfoEnum(String element){
        this.element = element;
    }
}

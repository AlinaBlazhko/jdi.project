package org.mytests.uiobjects.example.enums;

import javax.jws.soap.SOAPBinding;

/**
 * Created by X240 on 10/8/2017.
 */
public enum UserName {
    PITER_CHAILOVSKII("PITER CHAILOVSKII");

    String element;

    public String getName(){
        return element;
    }

    UserName(String element){
        this.element = element;
    }
}

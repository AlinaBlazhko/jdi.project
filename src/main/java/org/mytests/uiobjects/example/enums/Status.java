package org.mytests.uiobjects.example.enums;

/**
 * Created by X240 on 10/8/2017.
 */
public enum Status {
    TRUE("true"),
    FALSE("false"),
    METAL("metal"),
    COLORS("Colors"),
    MANDATORY("mandatory"),
    OPTIONAL("optional"),
    ALL("all"),
    NOTHING("nothing");

    public String status;

    Status(String status){
        this.status = status;
    }
}

package org.mytests.uiobjects.example.entities;

import com.epam.commons.DataClass;

/**
 * Created by X240 on 9/28/2017.
 */
public class ContactInfo extends DataClass{

    public String name;
    public String lastName;
    public String description;
    public String odd;
    public String even;

    public ContactInfo(String name, String lastName, String description, String odd, String even){
        this.name = name;
        this.lastName = lastName;
        this.description = description;
        this.odd = odd;
        this.even = even;
    }
}

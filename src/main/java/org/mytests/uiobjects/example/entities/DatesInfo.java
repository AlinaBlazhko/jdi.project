package org.mytests.uiobjects.example.entities;

import com.epam.commons.DataClass;
import com.epam.jdi.uitests.core.annotations.Mandatory;

import javax.print.attribute.standard.MediaSize;
import java.io.StreamCorruptedException;
import java.sql.Date;

import static org.mytests.uiobjects.example.enums.DatesInfoEnum.NAME;

/**
 * Created by X240 on 10/7/2017.
 */
public class DatesInfo {

    public String name;
    public String lastName;
    public String description;
    //public Range1 range1;
    public String from;
    public String to;
    public String datePicker;
    public String timePicker;

    public DatesInfo(String name, String lastName, String description, String from, String to, String datePicker, String timePicker){
        this.name = name;
        this.lastName = lastName;
        this.description = description;
        this.from = from;
        this.to = to;
        //this.range1 = range1;
        this.datePicker = datePicker;
        this.timePicker = timePicker;
    }
}

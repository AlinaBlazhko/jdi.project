package org.mytests.uiobjects.example.entities;

/**
 * Created by X240 on 10/7/2017.
 */
public class DatesInfo {

    public String name;
    public String lastName;
    public String description;
    public Range1 range1;
    //public String from;
    //public String to;
    public String datePicker;
    public String timePicker;
    //public int slider1;
    //public int slider2;
    public Range2 range2;
    public DatesInfo(String name, String lastName, String description, Range1 range1, String datePicker,
                     String timePicker, Range2 range2){
        this.name = name;
        this.lastName = lastName;
        this.description = description;
        //this.from = from;
        //this.to = to;
        this.range1 = range1;
        this.datePicker = datePicker;
        this.timePicker = timePicker;
        this.range2 = range2;
    }

//    public DatesInfo(String name, String lastName, String description,
//                     String from, String to, String datePicker, String timePicker, int slider1, int slider2){
//        this.name = name;
//        this.lastName = lastName;
//        this.description = description;
//        this.from = from;
//        this.to = to;
//        this.datePicker = datePicker;
//        this.timePicker = timePicker;
//        this.slider1 = slider1;
//        this.slider2 = slider2;
//    }

}

package org.mytests.uiobjects.example.entities;

/**
 * Created by X240 on 10/10/2017.
 */
public class SumOfNumbers {
    String odd = "1";
    String even = "2";

    public String getOdd(){
        return odd;
    }

    public String getEven(){
        return even;
    }

    public SumOfNumbers(String odd, String even){
        this.odd = odd;
        this.even = even;
    }

    //public SumOfNumbers(){}
}

package org.mytests.uiobjects.example.entities;

import com.epam.commons.DataClass;

/**
 * Created by Roman_Iovlev on 5/26/2017.
 */
public class User extends DataClass {
    public String name = "epam";
    public String password = "1234";

    public User(){}

    public User(String login, String password){
        this.name = login;
        this.password = password;
    }
}

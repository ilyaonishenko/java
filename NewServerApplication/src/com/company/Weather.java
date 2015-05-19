package com.company;

import java.io.Serializable;

/**
 * Created by woqpw on 19.05.15.
 */
public class Weather implements Serializable {
    private String username;
    private String weather = " The weather will be good";
    public Weather(String username){
        this.username = username;
    }
    public void getWeather(){
        System.out.println(" The weather will be good, "+username);
    }

}

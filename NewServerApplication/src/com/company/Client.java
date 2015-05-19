package com.company;

/**
 * Created by woqpw on 19.05.15.
 */
public class Client {
    private String password;
    private String username;
    public Client(String username,String password){
        this.username = username;
        this.password = password;
    }
    public String getUsername(){
        return  this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword (String password){
        this.password = password;
    }
}

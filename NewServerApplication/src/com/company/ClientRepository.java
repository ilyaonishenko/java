package com.company;

import java.util.LinkedList;
import java.util.List;
/**
 * Created by woqpw on 19.05.15.
 */
public class ClientRepository {
    public List<Client> clientRepository = new LinkedList<Client>();
    public void addSomeNew(){
        clientRepository.add(new Client("firstUser",Main.hash("12345")));
    }
    public boolean check(String userName,String password){
        for (Client c:clientRepository){
            if (c.getUsername().equals(userName)&&c.getPassword().equals(password)){
                return true;
            }
            else return false;
        }
        return false;
    }
    public boolean checkUsername(String username){
        for(Client c:clientRepository){
            if(c.getUsername().equals(username))
                return true;
        }
        return false;
    }
    public boolean checkPassword(String password){
        for(Client c:clientRepository){
            if(c.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}

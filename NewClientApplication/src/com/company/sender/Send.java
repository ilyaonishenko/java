package com.company.sender;

import java.io.*;
import java.net.Socket;

/**
 * Created by woqpw on 08.05.15.
 */

//clientApplication


public class Send  {
    private static String username;
    private static String password;
    private String info;
    private String text;
    public Send(String username,String password){
        this.username = username;
        this.password = password;
        try{
            Socket clientSocket = new Socket("localhost",6025);
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())),true);
            printWriter.println(username);
            printWriter.println(password);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            info = bufferedReader.readLine();
            System.out.println(info);
            clientSocket.close();
        } catch(IOException e){
            System.err.println("Problem with Socket");
        }
    }
    public String getInformation(){
        return  text;
    }
    public void parseInfo(){
        String[] array = info.split(" ",'\t');
        for(String s:array){
            System.out.println(s);
        }
        text = "";
        for(int i=1;i<array.length;i++){
            text += array[i];
            text+=" ";
        }
    }
    public String getUsername(){
        return username;
    }
}

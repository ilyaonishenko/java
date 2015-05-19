package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.*;

//Server application

public class Main {
    private static String username;
    private static String password;
    private static String message;
    public static void main(String[] args) {
	// write your code here
        try {
            ServerSocket listeningSocket = new ServerSocket(6025);
            System.out.println("Socket is ready to listen " + listeningSocket);
            ClientRepository clientRepository  = new ClientRepository();
            clientRepository.addSomeNew();
            Weather weather;
            boolean show = true;
            while(show){
                Socket newSocket = listeningSocket.accept();
                System.out.println("New Socket "+newSocket);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(newSocket.getInputStream()));
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(newSocket.getOutputStream())),true);
                username = bufferedReader.readLine();
                password = bufferedReader.readLine();
                password = hash(password);
                boolean buf = clientRepository.check(username,password);
                if(buf){
                    System.out.println("client "+username+" connected");
                    weather = new Weather(username);
                    try{
                        File file = new File("weather.txt");
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream);
                        objectOutputStream1.writeObject(weather);
                        objectOutputStream1.close();
                        fileOutputStream.close();
                        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file));
                        message = "";
                        String cLine;
                        System.out.println("working");
                        while((cLine = bufferedReader1.readLine())!=null) {
                            message += bufferedReader1.readLine();
                        }
                        printWriter.println(message);
                        System.out.println(message);
                    }catch(IOException ex){
                        System.out.println(ex.getMessage());
                    }
                }
                else if (!clientRepository.checkUsername(username))
                    printWriter.println("no such user");
                else if (!clientRepository.checkPassword(password))
                    printWriter.println("wrong password");

            }
            listeningSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String hash(String password){
        MessageDigest md;
        String hashPassword="";
        try{
            md = MessageDigest.getInstance("SHA-512");
            md.update(password.getBytes());
            byte[] mb = md.digest();
            for(int i=0;i<mb.length;i++){
                byte temp = mb[i];
                String s = Integer.toHexString(new Byte(temp));
                while(s.length()<2){
                    s="0"+s;
                }
                s = s.substring(s.length() - 2);
                hashPassword += s;
            }
        } catch (NoSuchAlgorithmException e){
            System.out.println("ERROR: " + e.getMessage());
        }
        return hashPassword;
    }

}

package com.company;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) {

        String serverName = "46.101.150.180";
//        String serverName = "localhost";
        int port  = 6066;

        try{

            System.out.println("Connecting to "+String.valueOf(port));
            Socket client = new Socket(serverName,port);
            System.out.println("Connected to "+String.valueOf(client.getRemoteSocketAddress()));
            OutputStream outputStream = client.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF("HELLO MOTHERFUCKER");
            InputStream inputStream = client.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            System.out.println("we get: "+dataInputStream.readUTF());
            client.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

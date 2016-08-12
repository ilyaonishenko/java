package com.company.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by woqpw on 12.08.16.
 */
public class Main {

    public static void main(String[] args){

        int port = 6066;

        try{
            Thread thread = new Server(port);
            thread.start();
        } catch (IOException e){
            
            e.printStackTrace();
        }
    }
}

class Server extends Thread{

    private ServerSocket serverSocket;

    public Server(int port) throws IOException{

        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    public void run(){
        while (true){
            try{
                System.out.println("Waiting client on: "+serverSocket.getLocalPort());
                Socket socket = serverSocket.accept();
                System.out.println("Connected to "+socket.getLocalPort());
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                String message = dataInputStream.readUTF();
                System.out.println("We get information: "+message);
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF(reverse(message));
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String reverse(String word){
        return new StringBuilder(word).reverse().toString();
    }
}

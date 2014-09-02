package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String text = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try
        {text = br.readLine();}
        catch (IOException ex)
        {
            System.out.print("Exception!");
        }
        text = text.toUpperCase();
        System.out.print(text);
    }
}

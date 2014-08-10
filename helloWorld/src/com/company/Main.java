package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String text = "";
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("type the word");
        try {
            text = re.readLine();
        }
        catch (IOException l) {
            System.out.println("smt wrong!");
        }
        System.out.println(text);
    }
}

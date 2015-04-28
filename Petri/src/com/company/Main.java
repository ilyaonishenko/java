package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int width = 2000;
        int height = 1000;
        myFrame mainFrame = new myFrame("Petri Netri Huetri");
        mainFrame.setSize(width, height);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}

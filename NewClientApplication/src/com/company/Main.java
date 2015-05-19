package com.company;

import com.company.frame.MyFrame;

import javax.swing.*;

public class Main {
    private final static int _width = 300;
    private static final int _height = 400;
    public static void main(String[] args) {
	// write your code here
        MyFrame myFrame = new MyFrame("ClientApplication");
        myFrame.setBounds(50,100,_width,_height);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }
}

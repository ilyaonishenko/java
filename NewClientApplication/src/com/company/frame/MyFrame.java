package com.company.frame;

import com.company.sender.Send;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by woqpw on 08.05.15.
 */
public class MyFrame extends JFrame {
    private JFrame uglyFrame;
    private static final String _changedText = "This text will be changed";
    private static final int _buttonWidth = 90;
    private static final int _buttonHeight = 35;
    private static final int _labelWidth = 100;
    private static final int _labelHeight = 35;
    private static final int _textFieldWidth = 170;
    private static final int _textFieldHeight = 18;
    JButton closeButton = new JButton("close");
    JButton sendButton = new JButton("send");
    JTextField usernameTextField = new JTextField();
    JTextField passwordTextField = new JTextField();
    JLabel usernameLabel = new JLabel("username");
    JLabel passwordLabel = new JLabel("password");
    JLabel serverAnswerLabel = new JLabel(_changedText);
    JLabel serverAnswerLabel1 = new JLabel("");
    public MyFrame(String text){
        super(text);
        uglyFrame = this;
        Container container = this.getContentPane();
        container.setLayout(null);
        closeButton.setBounds(100, 335, _buttonWidth, _buttonHeight);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uglyFrame.dispose();
            }
        });
        usernameLabel.setBounds(30, 10, _labelWidth, _labelHeight);
        passwordLabel.setBounds(30, 35, _labelWidth, _labelHeight);
        usernameTextField.setBounds(100, 20, _textFieldWidth, _textFieldHeight);
        passwordTextField.setBounds(100, 45, _textFieldWidth, _textFieldHeight);
        sendButton.setBounds(100, 70, _buttonWidth, _buttonHeight);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Send sending = new Send(getUserName(), getPassword());
                sending.parseInfo();
                serverAnswerLabel.setText(sending.getInformation());
                serverAnswerLabel1.setText(sending.getUsername());
            }
        });
        serverAnswerLabel.setBounds(30, 100, 400, 200);
        serverAnswerLabel1.setBounds(30,110,400,220);
        container.add(closeButton);
        container.add(usernameLabel);
        container.add(passwordLabel);
        container.add(usernameTextField);
        container.add(passwordTextField);
        container.add(sendButton);
        container.add(serverAnswerLabel);
        container.add(serverAnswerLabel1);
    }
    public String getUserName(){
        return usernameTextField.getText();
    }
    public String getPassword(){
        return passwordTextField.getText();
    }
}

package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by woqpw on 07.04.15.
 */
public class MyFrame extends JFrame {
    public final static int N = 10;
    private static final char pr = 'X';
    private static final char p = 'P';
    private static final char h = 'H';
    private static final char none = '-';
    public static final int WIDTH = 100;
    public static final int HEIGHT = 80;
    public static JButton[][] grid;

    public MyFrame(String title){
        super(title);
        initGUI();
        changePictures();
    }
    public void initGUI(){
        /*JPanel gridPane = new JPanel();
        gridPane.setLayout(new GridLayout(N,N,5,5));
        ImageIcon icon;
        JLabel jLabel;
        System.out.println("We a here");
        icon = new ImageIcon("src/com/company/pic/predator2.png");
        icon = resizeImage(WIDTH,HEIGHT,icon);
        jLabel = new JLabel(icon);
        gridPane.add(jLabel);
        setContentPane(gridPane);
        pack();*/
        JPanel gridPane = new JPanel();
        gridPane.setLayout(new GridLayout(N,N,5,5));
        grid = new JButton[N][N];
        ImageIcon icon;
        icon = new ImageIcon("src/com/company/pic/background.png");
        icon = resizeImage(WIDTH,HEIGHT,icon);
        JLabel  jLabel;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                grid[j][i]= new JButton(icon);
                gridPane.add(grid[j][i]);
            }
        }
        setContentPane(gridPane);
        pack();

    }
    public void changePictures(){
        getContentPane().removeAll();
        ImageIcon icon;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(Env.field[j][i]==pr){
                    icon = new ImageIcon("src/com/company/pic/predator2.png");
                    //array[j][i]=pr;
                }
                else if(Env.field[j][i]==p){
                    icon = new ImageIcon("src/com/company/pic/plant2.png");
                    //array[j][i]=p;
                }
                else if(Env.field[j][i]==h){
                    icon = new ImageIcon("src/com/company/pic/herbivore2.png");
                    //array[j][i]=h;
                }
                else {
                    icon = new ImageIcon("src/com/company/pic/background.png");
                    //array[j][i]=none;
                }
                icon = resizeImage(WIDTH,HEIGHT,icon);
                grid[j][i] = new JButton(icon);
                add(grid[j][i]);
            }
        }
        pack();
    }
    /*public void createGUI(){
        JPanel gridPane = new JPanel();
        ImageIcon icon;
        JLabel  jLabel;
        gridPane.setLayout(new GridLayout(N,N,5,5));
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(Env.field[j][i]==pr){
                    icon = new ImageIcon("com/company/com.company.pic/predator2.png");
                    //array[j][i]=pr;
                }
                else if(Env.field[j][i]==p){
                    icon = new ImageIcon("com/company/com.company.pic/plant2.png");
                    //array[j][i]=p;
                }
                else if(Env.field[j][i]==h){
                    icon = new ImageIcon("com/company/com.company.pic/herbivore2.png");
                    //array[j][i]=h;
                }
                else {
                    icon = new ImageIcon("com/company/com.company.pic/background.png");
                    //array[j][i]=none;
                }
                icon = resizeImage(WIDTH,HEIGHT,icon);
                jLabel = new JLabel(icon);
                gridPane.add(jLabel);
            }
        }
        setContentPane(gridPane);
        pack();
        setVisible(true);
    }*/
    private ImageIcon resizeImage(int _width,int _height,ImageIcon imageIcon){
        Image img = imageIcon.getImage().getScaledInstance(_width,_height,java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
}

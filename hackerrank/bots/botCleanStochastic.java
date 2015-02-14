import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
  static void printLEFT()
  {
    System.out.println("LEFT");
  }
  static void printRIGHT()
  {
    System.out.println("RIGHT");
  }
  static void printUP()
  {
    System.out.println("UP");
  }
  static void printDOWN()
  {
    System.out.println("DOWN");
  }
  static void printCLEAN()
  {
    System.out.println("CLEAN");
  }
static void nextMove(int posr, int posc, String[] board){
        //add logic here
    int ynow = posr;
    int xnow = posc;
    int xdirt = 0;
    int ydirt = 0;
    for (int i=0;i<board.length;i++)
    {
      for (int j=0;j<=board[i].length()-1;j++)
      {
        if (board[i].charAt(j)=='d')
          {
            xdirt = j;
            ydirt = i;
          }
      }
    }
    if (xnow<xdirt)
    {
      printRIGHT();
      xnow++;
    }
    else if (xnow>xdirt)
    {
      printLEFT();
      xnow--;
    }
    else if (xnow==xdirt)
    {
      if (ynow>ydirt)
      {
        printUP();
        ynow--;
      }
      else if (ynow<ydirt)
      {
        printDOWN();
        ynow++;
      }
      else if (ynow==ydirt)
        printCLEAN();
    }
    }
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] pos = new int[2];
        String board[] = new String[5];
        for(int i=0;i<2;i++) pos[i] = in.nextInt();
        for(int i=0;i<5;i++) board[i] = in.next();
        nextMove(pos[0], pos[1], board);
    }
}

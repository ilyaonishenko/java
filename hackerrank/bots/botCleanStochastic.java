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
    static void println("CLEAN");
  }
static void nextMove(int posr, int posc, String[] board){
        //add logic here
    int xnow = posr;
    int ynow = posc;
    int xdirt = 0;
    int ydirt = 0;
    for (int i=ynow;i<board.length;i++)
    {
      for (int j=xnow;i<board[i].length();j++)
      {
        if (board[i].charAt(j).equals("d"))
          {
            xdirt = j;
            ydirt = i;
          }
      }
    }
    if (xnow<xdirt)
      printRIGHT();
    else if (xnow>xdirt)
      printLEFT()
    else if (xnow==xdirt)
    {
      if (ynow>ydirt)
        printUP();
      else if (ynow<ydirt)
        printDOWN();
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

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
  public static void leftPrint()
  {
    System.out.println("LEFT");
  }
  public static void rightPrint()
  {
    System.out.println("RIGHT");
  }
  public static void upPrint()
  {
    System.out.println("UP");
  }
  public static void downPrint()
  {
    System.out.println("DOWN");
  }
static void nextMove(int n, int r, int c, String [] grid){
  int nowx = c;
  int nowy = r;
  int prinx = 0;
  int priny = 0;
  for (int i=0;i<n;i++)//y
  {
    for (int j=0;j<n;j++)//x
      if (grid[i].charAt(j)=='p')
      {
        prinx = j;
        priny = i;
      }
  }
  if (nowy>priny)
    upPrint();
  else if (nowy<priny)
    downPrint();
  else if (nowy==priny)
  {
    if (nowx>prinx)
      leftPrint();
    else if (nowx<prinx)
      rightPrint();
  }
  }
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,r,c;
        n = in.nextInt();
        r = in.nextInt();
        c = in.nextInt();
        in.useDelimiter("\n");
        String grid[] = new String[n];


        for(int i = 0; i < n; i++) {
            grid[i] = in.next();
        }

    nextMove(n,r,c,grid);

    }
}

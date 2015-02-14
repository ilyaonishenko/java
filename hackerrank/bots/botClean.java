import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static void next_move(int posr, int posc, String[] board){
        //add logic here
        int xnow = posc;
        int ynow = posr;
        ArrayList<Integer> list_x = new ArrayList<Integer>();
        ArrayList<Integer> list_y = new ArrayList<Integer>();
        int[] dirtyx;
        int[] dirtyy;
        int len = board.length;
        for (int i=0;i<board.length;i++)
        {
          for (int j=0;j<=board[i].length()-1;j++)
          {
            if (board[i].charAt(j) == 'd')
            {
              list_x.add(j);
              list_y.add(i);
            }
          }
        }
        //сейчас сделаю просто прохождение всей матрицы.
        // потом что-нибудь умнее
        for (int i=0;i<len;i++)
        {
          for (int j=0;j<len;j++)
          {
            if (i == list_y.get(j))
            {
              //fuck off
            }
          }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] pos = new int[2];
        String board[] = new String[5];
        for(int i=0;i<2;i++) pos[i] = in.nextInt();
        for(int i=0;i<5;i++) board[i] = in.next();
        next_move(pos[0], pos[1], board);
    }
}

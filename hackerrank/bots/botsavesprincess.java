import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static void Print(String text)
        {
        System.out.println(text);
    }
static void displayPathtoPrincess(int n, String [] grid){
    int m = n-1;
    int posx_1 = m/2;
    int posy_1 = m/2;
    int posx_2 = 0;
    int posy_2 = 0;
    if (grid[0].charAt(m)=='p')
        {
        posy_2 = 0;
        posx_2 = m;
    }
    else if (grid[0].charAt(0)=='p')
        {
        posy_2 = 0;
        posx_2 = 0;
    }
    else if (grid[m].charAt(0)=='p')
        {
        posy_2 = m;
        posx_2 = 0;
    }
    else
        {
        posy_2 = m;
        posx_2 = m;
    }
    if (posy_2>posy_1)
        while (posy_2>posy_1)
        {
        posy_1++;
        Print("DOWN");
    }
    else if (posy_2<posy_1)
        while (posy_2<posy_1)
        {
        posy_1--;
        Print("UP");
    }
    if (posx_2>posx_1)
        while (posx_2>posx_1)
        {
        posx_1++;
        Print("RIGHT");
    }
    else if (posx_2<posx_1)
        while (posx_2<posx_1)
        {
        posx_1--;
        Print("LEFT");
    }
  }
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m;
        m = in.nextInt();
        String grid[] = new String[m];
        for(int i = 0; i < m; i++) {
            grid[i] = in.next();
        }

    displayPathtoPrincess(m,grid);
    }
}

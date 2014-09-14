package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String all = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            all = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] allArray = new String[all.split(" ").length];
        allArray = all.split(" ");
        String verbEND[] = new String[]{"у","ю","ет","ем","ут", "ит","им","ют","ат","ят","ать","ять","ишь", "ешь", "ете","ите","ить"};
        ArrayList verbs = new ArrayList();
        ArrayList nouns = new ArrayList();
        String word = "";
        int count=0;
        // слова, которые вводятся в консоль точно попадают в allArray;
        for (int i=0;i<allArray.length;i++)
        {
            count=0;
            for (int j=0;j<verbEND.length;j++)
            {
                if (j==0 || j== 1)
                {
                    word = String.valueOf(allArray[i].charAt(allArray[i].length()-1));
                    if (word == verbEND[j])
                    {
                        verbs.add(allArray[i]);
                    }
                    else
                    {
                        count++;
                    }
                }
                if (j==3 || j==2)
                {
                    word = String.valueOf(allArray[i].charAt(allArray[i].length()-2)).concat(String.valueOf(allArray[i].charAt(allArray[i].length()-1)));
                    if (word.equals(verbEND[j]))
                    {
                        verbs.add(allArray[i]);
                    }
                    else
                    {
                        count++;
                    }
                }
                if (j==5 || j == 4)
                {
                    word = String.valueOf(allArray[i].charAt(allArray[i].length()-2)).concat(String.valueOf(allArray[i].charAt(allArray[i].length()-1)));
                    if (word.equals(verbEND[j]))
                    {
                        verbs.add(allArray[i]);
                    }
                    else
                    {
                        count++;
                    }
                }
                if (j==7 || j==6)
                {
                    word = String.valueOf(allArray[i].charAt(allArray[i].length()-2)).concat(String.valueOf(allArray[i].charAt(allArray[i].length()-1)));
                    if (word.equals(verbEND[j]))
                    {
                        verbs.add(allArray[i]);
                    }
                    else
                    {
                        count++;
                    }
                }
                if (j==8 || j ==9)
                {
                    word = String.valueOf(allArray[i].charAt(allArray[i].length()-2)).concat(String.valueOf(allArray[i].charAt(allArray[i].length()-1)));
                    if (word.equals(verbEND[j]))
                    {
                        verbs.add(allArray[i]);
                    }
                    else
                    {
                        count++;
                    }
                }
                if (count==10)
                {
                    nouns.add(allArray[i]);
                    count=0;
                }
            }
        }
        for (int i=0;i<verbs.size();i++)
        {
            System.out.println(verbs.get(i));
        }
    }
}

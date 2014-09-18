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
        // слова, которые вводятся в консоль точно попадают в allArray; ------------- сделано
        // включительно до окончания двойных окончаний слова разделяются на ис и глаголы.-----------сделано
        // нужно сделать исключения для коротких слов------------сделано
        // можно бояться слов типа привет и ещё чего-нибудь. Они принимаются за глаголы
        // добавить суффикс "л" с плюшками
        // добавить разделения на род число лицо и так далее (звучит плохо)
        // разбить на функции
        for (int i=0;i<allArray.length;i++)
        {
            count=0;
            for (int j=0;j<verbEND.length;j++)
            {
                if (allArray[i].length()<2)
                {
                    nouns.add(allArray[i]);
                    break;
                }
                else if (allArray[i].length()<3)
                {
                    if (j == 0 || j == 1) {
                        word = String.valueOf(allArray[i].charAt(allArray[i].length() - 1));
                        if (word.equals(verbEND[j])) {
                            verbs.add(allArray[i]);
                            break;
                        } else {
                            count++;
                        }
                    }
                    if (j == 3 || j == 2) {
                        word = String.valueOf(allArray[i].charAt(allArray[i].length() - 2)).concat(String.valueOf(allArray[i].charAt(allArray[i].length() - 1)));
                        if (word.equals(verbEND[j])) {
                            verbs.add(allArray[i]);
                            break;
                        } else {
                            count++;
                        }
                    }
                    if (count == 4)
                    {
                        nouns.add(allArray[i]);
                        break;
                    }
                }
                else if (allArray[i].length()<4)
                {
                    if (j == 0 || j == 1) {
                        word = String.valueOf(allArray[i].charAt(allArray[i].length() - 1));
                        if (word.equals(verbEND[j])) {
                            verbs.add(allArray[i]);
                            break;
                        } else {
                            count++;
                        }
                    }
                    if (j == 3 || j == 2) {
                        word = String.valueOf(allArray[i].charAt(allArray[i].length() - 2)).concat(String.valueOf(allArray[i].charAt(allArray[i].length() - 1)));
                        if (word.equals(verbEND[j])) {
                            verbs.add(allArray[i]);
                            break;
                        } else {
                            count++;
                        }
                    }
                    if (j == 5 || j == 4) {
                        word = String.valueOf(allArray[i].charAt(allArray[i].length() - 2)).concat(String.valueOf(allArray[i].charAt(allArray[i].length() - 1)));
                        if (word.equals(verbEND[j])) {
                            verbs.add(allArray[i]);
                            break;
                        } else {
                            count++;
                        }
                    }
                    if (j == 7 || j == 6) {
                        word = String.valueOf(allArray[i].charAt(allArray[i].length() - 2)).concat(String.valueOf(allArray[i].charAt(allArray[i].length() - 1)));
                        if (word.equals(verbEND[j])) {
                            verbs.add(allArray[i]);
                            break;
                        } else {
                            count++;
                        }
                    }
                    if (j == 8 || j == 9) {
                        word = String.valueOf(allArray[i].charAt(allArray[i].length() - 2)).concat(String.valueOf(allArray[i].charAt(allArray[i].length() - 1)));
                        if (word.equals(verbEND[j])) {
                            verbs.add(allArray[i]);
                            break;
                        } else {
                            count++;
                        }
                    }
                    if (j == 10) {
                        word = String.valueOf(allArray[i].charAt(allArray[i].length() - 3)).concat(String.valueOf(allArray[i].charAt(allArray[i].length() - 2))).concat(String.valueOf(allArray[i].charAt(allArray[i].length() - 1)));
                        if (word.equals(verbEND[j])) {
                            verbs.add(allArray[i]);
                            break;
                        } else count++;
                    }
                    if (count ==11)
                    {
                        nouns.add(allArray[i]);
                        break;
                    }
                }
                else {
                    if (j == 0 || j == 1) {
                        word = String.valueOf(allArray[i].charAt(allArray[i].length() - 1));
                        if (word.equals(verbEND[j])) {
                            verbs.add(allArray[i]);
                            break;
                        } else {
                            count++;
                        }
                    }
                    if (j == 3 || j == 2) {
                        word = String.valueOf(allArray[i].charAt(allArray[i].length() - 2)).concat(String.valueOf(allArray[i].charAt(allArray[i].length() - 1)));
                        if (word.equals(verbEND[j])) {
                            verbs.add(allArray[i]);
                            break;
                        } else {
                            count++;
                        }
                    }
                    if (j == 5 || j == 4) {
                        word = String.valueOf(allArray[i].charAt(allArray[i].length() - 2)).concat(String.valueOf(allArray[i].charAt(allArray[i].length() - 1)));
                        if (word.equals(verbEND[j])) {
                            verbs.add(allArray[i]);
                            break;
                        } else {
                            count++;
                        }
                    }
                    if (j == 7 || j == 6) {
                        word = String.valueOf(allArray[i].charAt(allArray[i].length() - 2)).concat(String.valueOf(allArray[i].charAt(allArray[i].length() - 1)));
                        if (word.equals(verbEND[j])) {
                            verbs.add(allArray[i]);
                            break;
                        } else {
                            count++;
                        }
                    }
                    if (j == 8 || j == 9) {
                        word = String.valueOf(allArray[i].charAt(allArray[i].length() - 2)).concat(String.valueOf(allArray[i].charAt(allArray[i].length() - 1)));
                        if (word.equals(verbEND[j])) {
                            verbs.add(allArray[i]);
                            break;
                        } else {
                            count++;
                        }
                    }
                    if (j == 10 || j == 11) {
                        word = String.valueOf(allArray[i].charAt(allArray[i].length() - 3)).concat(String.valueOf(allArray[i].charAt(allArray[i].length() - 2))).concat(String.valueOf(allArray[i].charAt(allArray[i].length() - 1)));
                        if (word.equals(verbEND[j])) {
                            verbs.add(allArray[i]);
                            break;
                        } else count++;
                    }
                    if (j == 12 || j == 13) {
                        word = String.valueOf(allArray[i].charAt(allArray[i].length() - 3)).concat(String.valueOf(allArray[i].charAt(allArray[i].length() - 2))).concat(String.valueOf(allArray[i].charAt(allArray[i].length() - 1)));
                        if (word.equals(verbEND[j])) {
                            verbs.add(allArray[i]);
                            break;
                        } else count++;
                    }
                    if (j == 14 || j == 15) {
                        word = String.valueOf(allArray[i].charAt(allArray[i].length() - 3)).concat(String.valueOf(allArray[i].charAt(allArray[i].length() - 2))).concat(String.valueOf(allArray[i].charAt(allArray[i].length() - 1)));
                        if (word.equals(verbEND[j])) {
                            verbs.add(allArray[i]);
                            break;
                        } else count++;
                    }
                    if (j == 16 || j == 17) {
                        word = String.valueOf(allArray[i].charAt(allArray[i].length() - 3)).concat(String.valueOf(allArray[i].charAt(allArray[i].length() - 2))).concat(String.valueOf(allArray[i].charAt(allArray[i].length() - 1)));
                        if (word.equals(verbEND[j])) {
                            verbs.add(allArray[i]);
                            break;
                        }
                    }
                    if (count == 16) {
                        nouns.add(allArray[i]);
                        count = 0;
                        break;
                    }
                }
            }
        }
        for (int i=0;i<verbs.size();i++)
        {
            System.out.println("verbs: "+ verbs.get(i));
        }
        for (int i=0;i<nouns.size();i++)
        {
            System.out.println("nouns: "+nouns.get(i));
        }
    }
}

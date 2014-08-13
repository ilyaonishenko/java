package com.company;

import com.sun.tools.javac.util.Convert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // write your code here
        System.out.println("type here:");
        String first = "";
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            first = br.readLine();}
        catch (IOException ex) {
            System.out.println("smth bad");
        }
        List answ = new ArrayList();
        main2(first,answ);
        System.out.println(answ.get(answ.size()-1));
    }
    public static void main2(String first,List answ)
    {
        first = first.trim();
        Character sep1[] = new Character[]{'+','-','*','/',')','(','E'};
        String sep2[] = new String[]{"Sin","Cos","Pi","exp"};
        Character sep3[] = new Character[]{'1','2','3','4','5','6','7','8','9','0',' ','.'};
        List numbers = new ArrayList();
        List deals = new ArrayList();
        List deals2 = new ArrayList();
        List numbers2 = new ArrayList();
        Character c1 = '(';
        Character c2 = ')';
        int a=0;
        int b=0;
        String second = "";
        for (int i=0;i<first.length();i++)
        {
            if (first.charAt(i)==c1)
            {
                a = i;
                for (int j=first.length()-1;j>0;j--)
                {
                    if (first.charAt(j)==c2) {
                        b = j;
                        break;
                    }
                }
                for (int j=0;j<first.length();j++)
                {
                    if (j>a&j<b)
                    {
                        second+=first.charAt(j);
                    }
                }
                makeNumbers(second,sep1,numbers);
                makeDeals(second,sep3,deals);
                lookingForMultiply(numbers,numbers2,deals,deals2);
                Double num[] = new Double[numbers2.size()];
                for (int j=0;j<numbers2.size();j++) {
                    num[j] = Double.parseDouble(numbers2.get(j).toString());
                }
                counting(num,deals2,answ);
                numbers.clear();
                deals.clear();
                numbers2.clear();
                deals2.clear();
                second="";
                int count=0;
                for (int j=0;j<first.length();j++)
                {
                    if (j<a||j>b)
                        second+=first.charAt(j);
                    else if (j>a&j<b)
                        if (count<1){
                            second+=Integer.toString((int)Double.parseDouble(answ.get(answ.size()-1).toString()));
                            count++;
                        }
                }
                answ.clear();
                makeNumbers(second,sep1,numbers);
                makeDeals(second,sep3,deals);
                lookingForMultiply(numbers,numbers2,deals,deals2);
                Double num1[] = new Double[numbers2.size()];
                for (int j=0;j<numbers2.size();j++) {
                    num1[j] = Double.parseDouble(numbers2.get(j).toString());
                }
                counting(num1,deals2,answ);
                break;
            }
            else
            {

            }
        }
    }
    public static void counting (Double array[],List deals,List answer)
    {
        double timeq=0;
        int count=0;
        outer: for (int i=0;i<array.length;i++)
        {
            if (i==0) {
                if (deals.get(i).toString().charAt(0) == '+') {
                    timeq = array[i] + array[i + 1];
                    answer.add(timeq);
                    count++;
                } else if (deals.get(i).toString().charAt(0) == '-') {
                    timeq = array[i] - array[i + 1];
                    answer.add(timeq);
                    count++;
                } else if (deals.get(i).toString().charAt(0) == '*') {
                    timeq = array[i] * array[i + 1];
                    answer.add(timeq);
                    count++;
                } else if (deals.get(i).toString().charAt(0) == '/') {
                    timeq = array[i] / array[i + 1];
                    answer.add(timeq);
                    count++;
                }
                i++;
                continue outer;
            }
            else {
                if (deals.get(i - 1).toString().charAt(0) == '+') {
                    timeq = Double.parseDouble(answer.get(count - 1).toString()) + array[i];
                    answer.add(timeq);
                    count++;
                } else if (deals.get(i - 1).toString().charAt(0) == '-') {
                    timeq = Double.parseDouble(answer.get(count - 1).toString()) - array[i];
                    answer.add(timeq);
                    count++;
                }
            }
        }
    }
    public static void lookingForMultiply(List num1,List num2,List deals1,List deals2)
    {
        double timeq=0;
        for (int i=0;i<deals1.size();i++)
        {
            if (deals1.get(i).toString().charAt(0)=='*'&i!=0)
            {
                timeq = Double.parseDouble(num1.get(i).toString())*Double.parseDouble(num1.get(i+1).toString());
                num1.set(i,timeq);
                num1.set(i+1,'0');
            }
            else if (deals1.get(i).toString().charAt(0)=='/'&i!=0)
            {
                timeq = Double.parseDouble(num1.get(i).toString())/Double.parseDouble(num1.get(i+1).toString());
                num1.set(i,timeq);
                num1.set(i+1,'0');
            }
            else {
                deals2.add(deals1.get(i));
            }
        }
        for (int i=0;i<num1.size();i++)
        {
            if (num1.get(i).toString().charAt(0)!='0')
                num2.add(num1.get(i));
        }
    }
    public static void makeNumbers (String all,Character array[],List numbers)
    {
        boolean tr = true;
        String time = "";
        for (int i=0;i<all.length();i++)
        {
            for (int j=0;j<array.length;j++)
            {
                if (all.charAt(i)==array[j])
                    tr = false;
            }
            if (i==all.length()-1&&tr==true)
            {
                time += all.charAt(i);
                time = time.trim();
                numbers.add(time);
                //time = "";
            }
            else if (tr == true) {
                time += all.charAt(i);
                time = time.trim();
            }
            else
            {
                time = time.trim();
                numbers.add(time);
                time="";
                tr = true;
            }
        }
    }
    public static void makeDeals(String all,Character array[],List deals)
    {
        boolean tr = true;
        for (int i=0;i<all.length();i++)
        {
            tr = true;
            for (int j=0;j<array.length;j++)
            {
                if (all.charAt(i)==array[j])
                    tr = false;
            }
            if (tr == true)
            {
                deals.add(all.charAt(i));
            }
        }
    }
}

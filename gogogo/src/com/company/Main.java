package com.company;

import com.sun.tools.javac.util.Convert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class Main {

    public static void main(String[] args) {
        System.out.println("type here:");
        String first = "";
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        first = br.readLine();}
        catch (IOException ex) {
            System.out.println("smth bad");
        }
        first = first.trim();
        //list.add(first);//  Добавление в список
        Character sep1[] = new Character[]{'+','-','*','/',')','(','E'};
        String sep2[] = new String[]{"Sin","Cos","Pi","exp"};
        Character sep3[] = new Character[]{'1','2','3','4','5','6','7','8','9','0',' ','.'};
        List numbers = new ArrayList();
        String time = "";
        boolean tr = true;
        for (int i=0;i<first.length();i++)
        {
            for (int j=0;j<sep1.length;j++)
            {
                if (first.charAt(i)==sep1[j])
                    tr = false;
            }
            if (i==first.length()-1&&tr==true)
            {
                time += first.charAt(i);
                time = time.trim();
                numbers.add(time);
                //time = "";
            }
            else if (tr == true) {
                time += first.charAt(i);
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
        List deals = new ArrayList();
        for (int i=0;i<first.length();i++)
        {
            tr = true;
            for (int j=0;j<sep3.length;j++)
            {
                if (first.charAt(i)==sep3[j])
                    tr = false;
            }
            if (tr == true)
            {
                deals.add(first.charAt(i));
            }
        }
        /*Double num[] = new Double[numbers.size()];
        for (int i=0;i<numbers.size();i++) {
            num[i] = Double.parseDouble(numbers.get(i).toString());
        }
        //System.out.println();
        /*for (int i=0;i<deals.size();i++) {
            System.out.print(deals.get(i) + " ");
        }*/
        List answ = new ArrayList();
        double timeq =0;
        int count = 0;
        /*outer: for (int i=0;i<num.length;i++)
        {
            if (i==0)
            {
                if (deals.get(i).toString().charAt(0) == '+')
                {
                    timeq = num[i] + num[i + 1];
                    answ.add(timeq);
                    count++;
                }
                else if (deals.get(i).toString().charAt(0) == '-')
                {
                    timeq = num[i] - num[i + 1];
                    answ.add(timeq);
                    count++;
                }
                else if (deals.get(i).toString().charAt(0) == '*')
                {
                    timeq = num[i] * num[i + 1];
                    answ.add(timeq);
                    count++;
                }
                else if (deals.get(i).toString().charAt(0) == '/')
                {
                    timeq = num[i] / num[i + 1];
                    answ.add(timeq);
                    count++;
                }
                i++;
                continue outer;
            }
            else
            {
                if (deals.get(i-1).toString().charAt(0)=='+')
                {
                    timeq = Double.parseDouble(answ.get(count-1).toString())+num[i];
                    answ.add(timeq);
                    count++;
                }
                else if (deals.get(i-1).toString().charAt(0)=='-')
                {
                    timeq = Double.parseDouble(answ.get(count-1).toString())-num[i];
                    answ.add(timeq);
                    count++;
                }
                else if (deals.get(i-1).toString().charAt(0)=='*')
                {
                    timeq = Double.parseDouble(answ.get(count-1).toString())*num[i];
                    answ.add(timeq);
                    count++;
                }
                if (deals.get(i-1).toString().charAt(0)=='/')
                {
                    timeq = Double.parseDouble(answ.get(count-1).toString())/num[i];
                    answ.add(timeq);
                    count++;
                }
            }*/
        List deals2 = new ArrayList();
        for (int i=0;i<deals.size();i++)
        {
            if (deals.get(i).toString().charAt(0)=='*'&i!=0)
            {
                timeq = Double.parseDouble(numbers.get(i).toString())*Double.parseDouble(numbers.get(i+1).toString());
                numbers.set(i,timeq);
                numbers.set(i+1,'0');
            }
            else if (deals.get(i).toString().charAt(0)=='/'&i!=0)
            {
                timeq = Double.parseDouble(numbers.get(i).toString())/Double.parseDouble(numbers.get(i+1).toString());
                numbers.set(i,timeq);
                numbers.set(i+1,'0');
            }
            else {
                deals2.add(deals.get(i));
            }
        }
        List numbers2 = new ArrayList();
        for (int i=0;i<numbers.size();i++)
        {
            if (numbers.get(i).toString().charAt(0)!='0')
                numbers2.add(numbers.get(i));
        }

        Double num[] = new Double[numbers2.size()];
        for (int i=0;i<numbers2.size();i++) {
            num[i] = Double.parseDouble(numbers2.get(i).toString());
        }
        outer: for (int i=0;i<num.length;i++) {
            if (i == 0) {
                if (deals2.get(i).toString().charAt(0) == '+') {
                    timeq = num[i] + num[i + 1];
                    answ.add(timeq);
                    count++;
                } else if (deals2.get(i).toString().charAt(0) == '-') {
                    timeq = num[i] - num[i + 1];
                    answ.add(timeq);
                    count++;
                } else if (deals2.get(i).toString().charAt(0) == '*') {
                    timeq = num[i] * num[i + 1];
                    answ.add(timeq);
                    count++;
                } else if (deals2.get(i).toString().charAt(0) == '/') {
                    timeq = num[i] / num[i + 1];
                    answ.add(timeq);
                    count++;
                }
                i++;
                continue outer;
            } else {
                if (deals2.get(i - 1).toString().charAt(0) == '+') {
                    timeq = Double.parseDouble(answ.get(count - 1).toString()) + num[i];
                    answ.add(timeq);
                    count++;
                } else if (deals2.get(i - 1).toString().charAt(0) == '-') {
                    timeq = Double.parseDouble(answ.get(count - 1).toString()) - num[i];
                    answ.add(timeq);
                    count++;
                }
            }
        }
        System.out.print(answ.get(answ.size()-1));
    }
}

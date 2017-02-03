package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wopqw on 02.02.17.
 */
public class Calc {

    Stack<Double> nums = new Stack<Double>();
    Stack<String> ops = new Stack<String>();

    HashMap<String, Integer> prioirty = new HashMap<String, Integer>();
    List<String> sep = Arrays.asList("(",")","+","-","*","/");

    Parser parser = new Parser();

    public Calc(){

        prioirty.put(")",1);
        prioirty.put("(",1);
        prioirty.put("/",2);
        prioirty.put("*",2);
        prioirty.put("+",3);
        prioirty.put("-",3);
    }

    public double evaluate(String text){

        text = "("+text+")";

        String[] numbers = parser.parse(text);
        String[] operations = parser.getOps().toArray(new String[parser.getOps().size()]);

        boolean  allowPush = true;
        for(int i = 0; i<operations.length; i++){
            if(numbers[i].length()!=0)
                nums.push(Double.parseDouble(numbers[i]));
            while (true){

                if(ops.isEmpty()||operations[i].equals("(")||prioirty.get(operations[i])>prioirty.get(ops.peek())){
                    ops.push(operations[i]);
                    break;
                }
                String op = ops.pop();
                if (op.equals("(")||nums.size()<2)
                {
                    break;
                }
                else
                {
                    double d2 = nums.pop();
                    double d1 = nums.pop();
                    nums.push(eval(op,d1,d2));
                }
            }
        }
        while (!ops.isEmpty())
        {
            String op = ops.pop();
            double val2 = nums.pop();
            double val1 = nums.pop();
            nums.push(eval(op, val1, val2));
        }
        double answer = nums.pop();
        return answer;
    }

    public static double eval(String operation, double d1, double d2){
        switch (operation){
            case "+":
                return d1+d2;
            case "-":
                return d1-d2;
            case "*":
                return d1*d2;
            case "/":
                return d1/d2;
        }
        return 0;
    }
}

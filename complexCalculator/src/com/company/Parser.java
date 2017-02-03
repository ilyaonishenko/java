package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wopqw on 02.02.17.
 */
public class Parser {
    private final char[] sep = new char[]{'(',')','+','-','*','/'};
    private List<Character> ops;

    public String[] parse(String text){
        text = deleteSpaces(text);
        ops = createSepArray(text);
        return getAllNumbers(text);
    }

    String deleteSpaces(String text){
        return text.replaceAll("\\s","");
    }

    List<Character> createSepArray(String text){
        List<Character> operations = new ArrayList<>();
        for(int i=0; i<text.length(); i++){
            for (char aSep : sep) {
                if (text.charAt(i) == aSep)
                    operations.add(aSep);
            }
        }
        return operations;
    }

    String[] getAllNumbers(String text){
        List<String> listOfStrings = new ArrayList<>();
        int count = 0;
        int count2 = 0;
        for(int i=0; i<text.length(); i++){
            System.out.println(text.charAt(i));
            if(text.charAt(i)==ops.get(count)){
                listOfStrings.add(text.substring(i-count2, i));
                count2 = 0;
                count++;
            } else{
                count2++;
            }
        }
        return listOfStrings.toArray(new String[listOfStrings.size()]);
    }
    public List<String> getOps(){
        List<String> answerList = new ArrayList<>();
        for(Character c: ops)
            answerList.add(String.valueOf(c));
        return answerList;
    }
}

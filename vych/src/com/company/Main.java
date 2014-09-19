package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static String makeWord(int n,String word)
    {
        if (n==1) {
            word = String.valueOf(word.charAt(word.length() - 1));
            return word;
        }
        if (n==2)
        {
            word = String.valueOf(word.charAt(word.length()-2)).concat(String.valueOf(word.charAt(word.length()-1)));
            return word;
        }
        if (n==3)
        {
            word = String.valueOf(word.charAt(word.length()-3)).concat(String.valueOf(word.charAt(word.length()-2))).concat(String.valueOf(word.charAt(word.length()-1)));
            return word;
        }
        else
            return String.valueOf(0);

    }
    public static int comparing (String word,String word2,ArrayList someList,String some)
    {
        if (word.equals(word2))
        {
            someList.add(some);
            return 0;
        }
        return 1;
    }


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
        String verbEND[] = new String[]{"у","ю","л","ла","ли","ло","ет","ем","ут", "ит","им","ют","ат","ят","ать","ять","ишь", "ешь", "ете","ите","ить"};
        ArrayList verbs = new ArrayList();
        ArrayList nouns = new ArrayList();
        String word = "";
        int check =110;
        int count=0;
        // слова, которые вводятся в консоль точно попадают в allArray; ------------- сделано
        // включительно до окончания двойных окончаний слова разделяются на ис и глаголы.-----------сделано
        // нужно сделать исключения для коротких слов------------сделано
        // можно бояться слов типа привет и ещё чего-нибудь. Они принимаются за глаголы
        // добавить суффикс "л" с плюшками ------- вроде как сделано
        // добавить разделения на род число лицо и так далее (звучит плохо)
        // разбить на функции ( это в последний момент ) ----- сделано
        for (int i=0;i<allArray.length;i++)
        {
            count=0;
            check = 110;
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
                        word = makeWord(1,allArray[i]);
                        check = comparing(word,verbEND[j],verbs,allArray[i]);
                        if (check==0)
                        {
                            break;
                        }
                        else {
                            count++;
                        }
                    }
                    if (j == 2) {
                        word = makeWord(1,allArray[i]);
                        check = comparing(word,verbEND[j],verbs,allArray[i]);
                        if (check==0)
                        {
                            break;
                        }
                        else {
                            count++;
                        }
                    }
                    if (j==3)
                    {
                        word = makeWord(2,allArray[i]);
                        check = comparing(word,verbEND[j],verbs,allArray[i]);
                        if (check==0)
                        {
                            break;
                        }
                        else {
                            count++;
                        }
                    }
                    if (j==4||j==5)
                    {
                        word = makeWord(2,allArray[i]);
                        check = comparing(word,verbEND[j],verbs,allArray[i]);
                        if (check==0)
                        {
                            break;
                        }
                        else {
                            count++;
                        }
                    }
                    if (count == 6)
                    {
                        nouns.add(allArray[i]);
                        break;
                    }
                }
                else if (allArray[i].length()<4)
                {
                    if (j == 0 || j == 1) {
                        word = makeWord(1,allArray[i]);
                        check = comparing(word,verbEND[j],verbs,allArray[i]);
                        if (check==0)
                        {
                            break;
                        }
                        else {
                            count++;
                        }
                    }
                    if ( j == 2) {
                        word = makeWord(1,allArray[i]);
                        check = comparing(word,verbEND[j],verbs,allArray[i]);
                        if (check==0)
                        {
                            break;
                        }
                        else {
                            count++;
                        }
                    }
                    if (j==3)
                    {
                        word = makeWord(2,allArray[i]);
                        check = comparing(word,verbEND[j],verbs,allArray[i]);
                        if (check==0)
                        {
                            break;
                        }
                        else {
                            count++;
                        }
                    }
                    if (j == 5 || j == 4) {
                        word = makeWord(2,allArray[i]);
                        check = comparing(word,verbEND[j],verbs,allArray[i]);
                        if (check==0)
                        {
                            break;
                        }
                        else {
                            count++;
                        }
                    }
                    if (j == 7 || j == 6) {
                        word = makeWord(2,allArray[i]);
                        check = comparing(word,verbEND[j],verbs,allArray[i]);
                        if (check==0)
                        {
                            break;
                        }
                        else {
                            count++;
                        }
                    }
                    if (j == 8 || j == 9) {
                        word = makeWord(2,allArray[i]);
                        check = comparing(word,verbEND[j],verbs,allArray[i]);
                        if (check==0)
                        {
                            break;
                        }
                        else {
                            count++;
                        }
                    }
                    if (j == 10|| j == 11) {
                        word = makeWord(2,allArray[i]);
                        check = comparing(word,verbEND[j],verbs,allArray[i]);
                        if (check==0)
                        {
                            break;
                        }
                        else {
                            count++;
                        }
                    }
                    if (j == 12|| j == 13) {
                        word = makeWord(2,allArray[i]);
                        check = comparing(word,verbEND[j],verbs,allArray[i]);
                        if (check==0)
                        {
                            break;
                        }
                        else {
                            count++;
                        }
                    }
                    if (count ==14)
                    {
                        nouns.add(allArray[i]);
                        break;
                    }
                }
                else {
                    if (j == 0 || j == 1) {
                        word = makeWord(1,allArray[i]);
                        check = comparing(word,verbEND[j],verbs,allArray[i]);
                        if (check==0)
                        {
                            break;
                        }
                        else {
                            count++;
                        }
                    }
                    if (j == 2) {
                        word = makeWord(1,allArray[i]);
                        check = comparing(word,verbEND[j],verbs,allArray[i]);
                        if (check==0)
                        {
                            break;
                        }
                        else {
                            count++;
                        }
                    }
                    if (j==3)
                    {
                        word = makeWord(2,allArray[i]);
                        check = comparing(word,verbEND[j],verbs,allArray[i]);
                        if (check==0)
                        {
                            break;
                        }
                        else {
                            count++;
                        }
                    }
                    if (j == 5 || j == 4) {
                        word = makeWord(2,allArray[i]);
                        check = comparing(word,verbEND[j],verbs,allArray[i]);
                        if (check==0)
                        {
                            break;
                        }
                        else {
                            count++;
                        }
                    }
                    if (j == 7 || j == 6) {
                        word = makeWord(2,allArray[i]);
                        check = comparing(word,verbEND[j],verbs,allArray[i]);
                        if (check==0)
                        {
                            break;
                        }
                        else {
                            count++;
                        }
                    }
                    if (j == 8 || j == 9) {
                        word = makeWord(2,allArray[i]);
                        check = comparing(word,verbEND[j],verbs,allArray[i]);
                        if (check==0)
                        {
                            break;
                        }
                        else {
                            count++;
                        }
                    }
                    if (j == 10 || j == 11) {
                        word = makeWord(2,allArray[i]);
                        check = comparing(word,verbEND[j],verbs,allArray[i]);
                        if (check==0)
                        {
                            break;
                        }
                        else {
                            count++;
                        }
                    }
                    if (j == 12 || j == 13) {
                        word = makeWord(2,allArray[i]);
                        check = comparing(word,verbEND[j],verbs,allArray[i]);
                        if (check==0)
                        {
                            break;
                        }
                        else {
                            count++;
                        }
                    }
                    if (j == 14 || j == 15) {
                        word = makeWord(3,allArray[i]);
                        check = comparing(word,verbEND[j],verbs,allArray[i]);
                        if (check==0)
                        {
                            break;
                        }
                        else {
                            count++;
                        }
                    }
                    if (j == 16 || j == 17) {
                        word = makeWord(3,allArray[i]);
                        check = comparing(word,verbEND[j],verbs,allArray[i]);
                        if (check==0)
                        {
                            break;
                        }
                        else {
                            count++;
                        }
                    }
                    if (j==18||j==19)
                    {
                        word = makeWord(3,allArray[i]);
                        check = comparing(word,verbEND[j],verbs,allArray[i]);
                        if (check==0)
                        {
                            break;
                        }
                        else {
                            count++;
                        }
                    }
                    if (j==20)
                    {
                        word = makeWord(3,allArray[i]);
                        check = comparing(word,verbEND[j],verbs,allArray[i]);
                        if (check==0)
                        {
                            break;
                        }
                        else {
                            count++;
                        }
                    }
                    if (count == 21) {
                        nouns.add(allArray[i]);
                        count = 0;
                        break;
                    }
                }
            }
        }
        ///////////////////////////////
        for (int i=0;i<verbs.size();i++)
        {
            System.out.println("verbs: "+ verbs.get(i));
        }
        for (int i=0;i<nouns.size();i++)
        {
            System.out.println("nouns: "+nouns.get(i));
        }
        ///////////////////////////////
        String female = "ла";
        String wtf = "ло";
        ArrayList females = new ArrayList();
        ArrayList males = new ArrayList();
        ArrayList wtff = new ArrayList();
        for (int i=0;i<verbs.size();i++)
        {
            String vfy = String.valueOf(verbs.get(i));
            word = makeWord(2,vfy);
            if (female.equals(word))
            {
                females.add(vfy);
            }
            else if (wtf.equals(word))
            {
                wtff.add(vfy);
            }
            else
            {
                males.add(vfy);
            }
        }
        /////////////////////////////////////////////////
        for (int i=0;i<females.size();i++)
        {
            System.out.println("females: "+females.get(i));
        }
        for (int i=0;i<wtff.size();i++)
            System.out.println("wtf: "+wtff.get(i));
        for (int i=0;i<males.size();i++)
            System.out.println("males "+males.get(i));
        //////////////////////////////////////////////////
        //males нужно разделить на первое лицо (ед/мн) второе лицо (ед/мн) и третье лицо (ед/мн)--сделано
        //все существительные нужно разделить на 1,2,3 рода, мн число и мест.----сделано
        ArrayList Sin1 = new ArrayList();
        ArrayList Sin2 = new ArrayList();
        ArrayList Sin3 = new ArrayList();
        ArrayList Mul1 = new ArrayList();
        ArrayList Mul2 = new ArrayList();
        ArrayList Mul3 = new ArrayList();
        //String verbEND[] = new String[]{"у","ю","л","ла","ли","ло","ет","ем","ут","ют","ат","ят", "ит","им","ать","ять","ишь", "ешь", "ете","ите","ить"};
        //String verbEND[] = new String[]{"у0","ю1","л2","ла3","ли4","ло5","ет6","ем7","ут8", "ит9","им10","ют11","ат12","ят13","ать14","ять15","ишь16", 17"ешь", 18"ете",19"ите","20ить"};
        for (int i=0;i<males.size();i++)
        {
            for (int j=0;j<verbEND.length;j++)
            {
                if (j==1||j==0)
                {
                    word = makeWord(1,String.valueOf(males.get(i)));
                    if (word.equals(verbEND[j]))
                        Sin1.add(String.valueOf(males.get(i)));
                }
                if (j==2||j==3)
                {

                }
                if (j==4||j==5)
                {

                }
                if (String.valueOf(males.get(i)).length()>=1) {
                    if (j == 6) {
                        word = makeWord(2, String.valueOf(males.get(i)));
                        if (word.equals(verbEND[j]))
                            Sin3.add(String.valueOf(males.get(i)));
                    }
                    if (j == 7) {
                        word = makeWord(2, String.valueOf(males.get(i)));
                        if (word.equals(verbEND[j]))
                            Mul1.add(String.valueOf(males.get(i)));
                    }
                    if (j == 8 ) {
                        word = makeWord(2, String.valueOf(males.get(i)));
                        if (word.equals(verbEND[j]))
                            Mul3.add(String.valueOf(males.get(i)));
                    }
                    if ( j == 9){
                        word = makeWord(2, String.valueOf(males.get(i)));
                        if (word.equals(verbEND[j]))
                            Sin3.add(String.valueOf(males.get(i)));
                    }
                    if (j == 10) {
                        word = makeWord(2, String.valueOf(males.get(i)));
                        if (word.equals(verbEND[j]))
                            Mul1.add(String.valueOf(males.get(i)));
                    }
                    if (j==11){
                        word = makeWord(2, String.valueOf(males.get(i)));
                        if (word.equals(verbEND[j]))
                            Mul3.add(String.valueOf(males.get(i)));
                    }
                    if (j == 12) {
                        word = makeWord(2, String.valueOf(males.get(i)));
                        if (word.equals(verbEND[j]))
                            Mul3.add(String.valueOf(males.get(i)));
                    }
                    if (j == 13) {
                        word = makeWord(2, String.valueOf(males.get(i)));
                        if (word.equals(verbEND[j]))
                            Mul3.add(String.valueOf(males.get(i)));
                    }
                    if (String.valueOf(males.get(i)).length()>=2) {
                        if (j == 16 || j == 17) {
                            word = makeWord(3, String.valueOf(males.get(i)));
                            if (word.equals(verbEND[j]))
                                Sin2.add(String.valueOf(males.get(i)));
                        }
                        if (j == 18 || j == 19) {
                            word = makeWord(3, String.valueOf(males.get(i)));
                            if (word.equals(verbEND[j]))
                                Mul2.add(String.valueOf(males.get(i)));
                        }
                    }
                }
            }
        }
        //////////////////////////////////////////////
        for (int i=0;i<Sin1.size();i++)
            System.out.println("SIN1 "+Sin1.get(i));
        for (int i=0;i<Sin2.size();i++)
            System.out.println("SIN2 "+Sin2.get(i));
        for (int i=0;i<Sin3.size();i++)
            System.out.println("SIN3 "+Sin3.get(i));
        for (int i=0;i<Mul1.size();i++)
            System.out.println("MUL1 "+Mul1.get(i));
        for (int i=0;i<Mul2.size();i++)
            System.out.println("MUL2 "+Mul2.get(i));
        for (int i=0;i<Mul3.size();i++)
            System.out.println("MUL3 "+Mul3.get(i));
        ////////////////////////////////////////////////
        // разделение ИС на рода и числа, местоимения.------сделано
        // общий вывод
        String nounsEND[] = new String[]{"о","е","я","ь","а","и"};
        ArrayList nouns1 = new ArrayList();
        ArrayList nouns2 = new ArrayList();
        ArrayList nouns3 = new ArrayList();
        ArrayList nounsMul = new ArrayList();
        for (int i=0;i<nouns.size();i++)
        {
            for (int j=0;j<nounsEND.length;j++)
            {
                if (j==0||j==1)
                {
                    word = makeWord(1,String.valueOf(nouns.get(i)));
                    if (word.equals(nounsEND[j])) {
                        nouns3.add(String.valueOf(nouns.get(i)));
                        break;
                    }
                }
                if (j==2||j==3)
                {
                    if (String.valueOf(nouns.get(i)).length()!=1) {
                        word = makeWord(1, String.valueOf(nouns.get(i)));
                        if (word.equals((nounsEND[j]))) {
                            nouns2.add(String.valueOf(nouns.get(i)));
                            break;
                        }
                    }
                }
                if (j==5)
                {
                    word = makeWord(1,String.valueOf(nouns.get(i)));
                    if (word.equals(nounsEND)) {
                        nounsMul.add(String.valueOf(nouns.get(i)));
                        break;
                    }
                }
                else
                {
                    nouns1.add(String.valueOf(nouns.get(i)));
                    break;
                }
            }
        }
        String mest[] = new String[]{"я","мы","ты","вы","он","она","оно","они"};
        ///сделать вываод
        // в каких списках лежат слова: nouns1,2,3,Mul,Sin1,2,3,Mul1,2,3,female,wtff,mest
        System.out.println("Финальный вывод:");
        ArrayList allNouns = new ArrayList();
        ArrayList allVerbs = new ArrayList();
        ArrayList allSinMul = new ArrayList();
        //сначала средний род, потом женский
        if (nouns3 != null) {
            for (int i=0;i< nouns3.size();i++)
                allNouns.add(String.valueOf(nouns3.get(i)));
        }
        if (nouns2!= null)
            for (int i=0;i<nouns2.size();i++)
                allNouns.add(String.valueOf(nouns2.get(i)));
        if (nounsMul!=null)
            for (int i=0;i<nounsMul.size();i++)
                allNouns.add(String.valueOf(nounsMul.get(i)));
        if (nouns1!=null)
            for (int i=0;i<nouns1.size();i++)
                allNouns.add(String.valueOf(nouns1.get(i)));
        //////////////////////////////////////////////////////////
        for (int i=0;i<allNouns.size();i++)
            System.out.println("ALLNOUNS "+ allNouns.get(i));
        ///////////////////////////////////////////////////////////
        if (wtff!=null)
            for (int i=0;i<wtff.size();i++)
                allVerbs.add(String.valueOf(wtff.get(i)));
        if (females!=null)
            for (int i=0;i<females.size();i++)
                allVerbs.add(String.valueOf(females.get(i)));
        if (males!=null)
            for (int i=0;i<males.size();i++)
                allVerbs.add(String.valueOf(males.get(i)));
        ////////////////////////////////////////////////////////////
        for (int i=0;i<allVerbs.size();i++)
            System.out.println("ALLVERBS "+allVerbs.get(i));
        ///////////////////////////////////////////////////////////
        for (int i=0;i<allVerbs.size();i++)
            System.out.println(allNouns.get(i)+" "+allVerbs.get(i));
    }
}

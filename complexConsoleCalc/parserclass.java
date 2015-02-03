import java.util.ArrayList;
public class parserclass implements parser
{


  //  ОБЯЗАТЕЛЬНО НАСТРОИТЬ СКОБКИ !!!!!!
  /*
  Итак, программа умеет открывать единственные скобки.
  Задача - при поступлении выражения раскрывать скобки по очереди и получатьзначения из них
  Пара принципиально различающихся вариантов:
  скобки и скобки рядом
  скобки в скобках

  */
  calc c = new calc();
  public String chooseStep(String text)//complex or not
  {
    boolean check  = false;
    String answer = "";
    for (int i=0;i<text.length();i++)
    {
      if (text.charAt(i)=='i')
      {
        check = true;
      }
    }
    if (check == true)
    {
      //System.out.println("I choose second step");
      answer = secondStep(text);
    }
    else
    {
      //System.out.println("I choose first Step");
      answer = firstStep(text);
    }
    return answer;
  }

  public String firstStep(String text)
  {
  //  if (text.length()==1)
    //  return text;
  // System.out.println("I'm in parserclass");
  //  System.out.println(text);
    text = badSign(text);
    boolean check = false;
    boolean checkForBrackets= false;
    boolean aLotOfBrackets = false;
    int n = 0;
    int n2 = 0;
    int n11=0,n12 =0, n13=0, n14=0;
    String hero = "";
    //
    //
    //
    // Вот тут работаем со скобками.
    //
    //
    //
    for (int i=0;i<text.length();i++)
    {
      //System.out.println("I'm here");
      if (text.charAt(i)=='(')
      {
        check = true;
        n=i+1;
        //System.out.println(text.charAt(n+1));
      }
    }
    for (int i=text.length()-1;i>=0;i--)
    {
      if (text.charAt(i)=='(')
      {
        n11 = i+1;
        //System.out.println(text.charAt(n+1));
      }
    }
    if (n11==n&&check==true)
    {
      checkForBrackets = true;
      //System.out.println("В системе всего одна пара скобок");
      // Определенная проверка того, что всего одна скобочка.
    }
    for ( int i=0;i<text.length();i++)
    {

    }

    //  5+(5+5)+5*(6-3) это нет
    //
    //  7*(6+3+(8-3))-2 это работает
    //
    if (n11!=n)
    {
      aLotOfBrackets = true;
      //System.out.println("A lot of Brackets");
    }
    //checkForBrackets==true
    if (checkForBrackets == true)
    {
      String text2 = text;
    //  System.out.println("Check is true");
      //for (int i = text.length()-1;i>=0;i--)
      for (int i=0;i<text.length();i++)
      {
        if (text.charAt(i)==')')
        {
          n2 = i;
          break;
        }
      }
      String work="";
      for (int i=n;i<n2;i++)
      {
        work+=String.valueOf(text.charAt(i));
      }
      hero = firstStep(work);
      //System.out.println(hero+" hero was found");
      text = "";
      boolean ch=false;
      for (int i=0;i<text2.length();i++)
      {
        if (text2.charAt(i)==')'||text2.charAt(i)=='(')
        {
          continue;
        }
        if (i<n||i>n2)
          text+=String.valueOf(text2.charAt(i));
        if (i>n&&i<n2&&ch==false)
        {
          text+=hero;
          ch = true;
        }
      }
      check = false;
      // из этого можно попробовать сделать отдельный метод

  //  System.out.println(text+" it is a text in true");
  //  System.out.println(text.length()+" it is a length in true");
    /*if (text.length()==1)
      return text;*/
    }

    //
    //
    //
    //      Тут заканчивается работа со скобочками
    //
    //
    //
    String walker = "";
    int counter = 0;
    boolean check2 = false;
    String answer="";
    if (check==false)
    {
    //  System.out.println("check is false");
      ArrayList<String> firstList = new ArrayList<String>();
      ArrayList<String> secondList = new ArrayList<String>();
      Character[] sep = new Character[]{'+','-','/','*'};
      for (int i=0;i<text.length();i++)
      {
        /*if (text.charAt(i)!=' ');
          firstList.add(String.valueOf(text.charAt(i)));*/
          check2 = false;
          for (int j=0;j<sep.length;j++)
          {
            if (text.charAt(i)==sep[j])
            {
              check2 = true;
              counter = j;
            }
          }
          if (check2 == true)
          {
            firstList.add(walker);
            firstList.add(String.valueOf(sep[counter]));
            walker = "";
          }
          if (check2 != true)
          {
            walker +=String.valueOf(text.charAt(i));
            if (i==text.length()-1)
            {
              firstList.add(walker);
              walker = "";
            }
          }
          /*for (int j=0;j<sep.length;j++)
          {
            if (text.charAt(i)!=sep[j])
              counter++;
            if (text.charAt(i)==sep[j])
              firstList.add(String.valueOf(sep[j]));
          }
          if (counter==sep.length-1)
          {
            //System.out.println(String.valueOf(text.charAt(i))+" - good"); ok
            walker+=String.valueOf(text.charAt(i));
            if (i==text.length()-1)
            {
              firstList.add(walker);
              walker = "";
            }
          }
          if (counter!=sep.length)
          {
            //System.out.println(walker+"kk1"); ok
            firstList.add(walker);
            walker = "";
          }*/

      }
      ///////jasdlkasbdalsdasklfblkadsbflkasdbvlasdbvlhadsbvlasdbvlksadbvlkasdbvlksjdbv;djksvb;aksdbv;sdvbs;advb;sdavb;dsvb;as;l
      System.out.println("i want to say smth");
      for (int i=0;i<firstList.size();i++)
      {
        if (firstList.get(i).equals(String.valueOf(sep[2]))||firstList.get(i).equals(String.valueOf(sep[3])))
        {
            //System.out.println("I'm going into the priority list");
            firstList = priorityList(firstList);
        }
      }
      if (firstList.size()==1)
      {
        return firstList.get(0);
      }
      //System.out.println("size of firstList is " +String.valueOf(firstList.size()));
      firstList = firstNumber(firstList);
      for (int i=0;i<firstList.size();i++)
      {
        //System.out.println(firstList.get(i));
      }
      for (int i=0;i<firstList.size();i++)
      {
        if (firstList.get(i).equals("+"))
        {
          //System.out.println("i'm thinking about addition");  ok
          /*System.out.println(firstList.get(0));// not ok
          System.out.println(firstList.get(1));
          System.out.println(firstList.get(2));*/
          secondList = refreshList(firstList,'+');
          break;
        }
        if (firstList.get(i).equals("-"))
        {
          secondList = refreshList(firstList,'-');
          break;
        }
        if (firstList.get(i).equals("*"))
        {
          secondList = refreshList(firstList,'*');
          break;
        }
        if (firstList.get(i).equals("/"))
        {
          secondList = refreshList(firstList,'/');
          break;
        }
      }
      //answer = secondList.get(0);
      if (secondList.size() == 1)
      {
      //  System.out.println("it's one!");
        answer = secondList.get(0);
      //  System.out.println(secondList.get(0)+" remaining");
      //  System.out.println(answer +" is answer");
        return secondList.get(0);
      }
      if (secondList.size()>1)
      {

      //  for (int i=0;i<secondList.size();i++)
        //  System.out.println(secondList.get(i)+"k");
        String go = "";
        for (int i=0;i<secondList.size();i++)
          go+=secondList.get(i);
        //System.out. println(go+" is go");//////
        answer = firstStep(go);
      }
    }
    return answer;
  }
  public ArrayList<String> refreshList(ArrayList<String> list,Character ch)
  {
    double res = 0;
    ArrayList<String> newList = new ArrayList<String>();
    if (ch=='+')
    {
    /*  System.out.println("ch is "+String.valueOf(ch));
      System.out.println(" get 0 is "+list.get(0));
      System.out.println(" get 2 is "+list.get(2));*/
      res = c.performAddition(list.get(0),list.get(2));
    }
    if (ch=='-')
    {
        res = c.performAddition(list.get(0),list.get(1)+list.get(2));
    }
    if (ch=='/')
    {
      res = c.performDivision(list.get(0),list.get(2));
    }
    if (ch=='*')
    {
      res = c.performMultiplication(list.get(0),list.get(2));
    }
    newList.add(String.valueOf(res));
    if (list.size()>2)
    {
    for (int i=3;i<list.size();i++)
    {
      newList.add(list.get(i));
    }
    }
    return newList;
  }
  public ArrayList<String> priorityList(ArrayList<String> list)
  {
    //System.out.println("I'm in pririty List");
    ArrayList<String> newList = new ArrayList<String>();
    //ArrayList<String> newList = new ArrayList<String>();
    /*System.out.println(String.valueOf(list.size())+" is size of list");
    for (int i=0;i<list.size();i++)
      System.out.println(list.get(i));*/
    int count = 0;
    String whale = "";
    int number = 0;
    double res=0;
    Character[] sep = new Character[]{'/','*'};
    for (int i=0;i<list.size();i++)
    {
      if (count==0)
      {
      for (int j=0;j<sep.length;j++)
        {
          if (list.get(i).equals(String.valueOf(sep[j])))
          {
            count++;
            number = i;
            if (j==0)
            {
              res = c.performDivision(list.get(i-1),list.get(i+1));
            }
            else
            {
              res = c.performMultiplication(list.get(i-1),list.get(i+1));
            }
          }
        }
      }
    }
    for (int i=0;i<list.size();i++)
    {
      if (i == number-1)
      {
        newList.add(String.valueOf(res));
        i+=2;
      }
      else
      {
        //System.out.println("I'm adding "+list.get(i));
        newList.add(list.get(i));
      }
    }
    if (newList.size()!=1)
    {
      for (int i=0;i<newList.size();i++)
      {
        if (newList.get(i).equals(String.valueOf(sep[0]))||newList.get(i).equals(String.valueOf(sep[1])))
        {
          priorityList(newList);
        }
      }
    }
    //System.out.println("to second round");
    /*for (int i=0;i<list.size();i++)
    {
      //System.out.println(String.valueOf(list.get(i)));
      if (list.get(i).equals("+")||list.get(i).equals("-"))
      {
        //System.out.println("I found + or -");
        newList.add(list.get(i-1));
        newList.add(list.get(i));
        newList.add(list.get(i+1));
      }
    }
    */
    //System.out.println(newList.size());
    /*for (int i=0;i<newList.size();i++)
    {
      System.out.println(newList.get(i));
    }*/
    return newList;
  }
  public String preOrder (String text)
  {
    System.out.println("I HAVE "+text);
    int countes = 0;
    for (int i=0;i<text.length();i++)
    {
      if (text.charAt(i)=='(')
      {
        countes++;
      }
    }
    System.out.println("there are "+countes);
    if (countes<2)
    {
      System.out.println("I'm in");
      return firstStep(text);
    }
    else
    {
      int bracketsArr[] = new int [countes];
      int brackets2Arr[] = new int [countes];
      int pointer=0;
      for (int i=0;i<text.length();i++)
      {
        if (text.charAt(i)=='(')
        {
          bracketsArr[pointer] = i;
          pointer++;
        }
      }
      pointer=0;
      for (int i=0;i<text.length();i++)
      {
        if (text.charAt(i)==')')
        {
          brackets2Arr[pointer]=i;
          pointer++;
        }
      }
      String newText="";
      if (bracketsArr[0+1]>brackets2Arr[0])
      {
        //one near one
        String goaway = "";
        for (int j=0;j<text.length();j++)
        {
          if (j<brackets2Arr[0]&&j>bracketsArr[0])
          {
            goaway+=text.charAt(j);
          }
        }
        System.out.println(goaway);
        goaway = firstStep(goaway);
        for (int j=0;j<text.length();j++)
        {
          if (j==bracketsArr[0])
          {
            newText+=goaway;
          }
          if (j<=brackets2Arr[0]&&j>=bracketsArr[0])
          {
          }
          else
          newText+=text.charAt(j);
        }
        newText = preOrder(newText);
      }
      else
      {
        //one in one
        System.out.println("I'm in one in one");
        //int maxIn1=lookForMax(bracketsArr);
        //int minIn2=lookForMin(brackets2Arr);
        int maxIn1 = bracketsArr[0+1];
        int minIn2 = brackets2Arr[0];
        //System.out.println("max in 1   "+maxIn1);
        //System.out.println("min in 2   "+minIn2);
        //System.out.println("length    "+text.length());
        String goaway = "";
        //(10-(5-2))
        for (int j=0;j<text.length();j++)
        {
        //  System.out.println(j);
          if (j>maxIn1&&j<minIn2)
          {
          //  System.out.println("_____"+j);
            goaway+=text.charAt(j);
          }
        }
        System.out.println("Go away   "+goaway);
        goaway = firstStep(goaway);
        for (int j=0;j<text.length();j++)
        {
          if (j==maxIn1)
          {
            newText+=goaway;
          }
          if (j>=maxIn1&&j<=minIn2)
          {
          }
          else
          newText+=text.charAt(j);
        }
        newText =  preOrder(newText);
      }
      return newText;
    }
  }
  //look 2 ways : brackets in brackets, or brackets near brackets;
  public String bracketsNearBrackets(String text)
  {
    return text;
  }
  public String bracketsInBrackets(String text)
  {
    return text;
  }
  public String secondStep(String text)
  {
    // впереди большая работа: раcпарсить полученный стринг так и передать его в метод twoBrackets
    int counter1 = 0;
    int counter2 = 0;
    int n1=0,n2=0,n3=0,n4=0;
    boolean check1 = false, check2 = false;
    for (int i=0;i<text.length();i++)
    {
      if (text.charAt(i) == ')')
        counter1++;
      if (text.charAt(i)=='(')
        counter2++;
    }
    if (counter1==counter2&&counter1==2)
    {
      //сначала нужно тестировать самый простой случай -  когда просто две скобки и знак между ними
      // сделаем проверку, чтобы скобки были не внутри друг друга
      for (int i=0;i<text.length();i++)
      {
        if (text.charAt(i)=='(')
        {
          n1 = i;
          //check = true;
        }
        if (text.charAt(i)==')')
        {
          n2 = i;
          //check = true;
        }
      }
    }

    //РАБОТЫ НАД КОМПЛЕКСНОЙ ЧАСТЬЮ ЗАМОРАЖИВАЮТСЯ!!!!!!!!!!!\\
    //ПОКА ОБЫЧНЫЙ КАЛЬКУЛЯТОР РАБОТАЕТ НЕПРАВИЛЬНО !!!!!!!!!\\
    //ЭТО ВСЕ!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\\


    //Character sign = '*';// знак, который нужно использовать
    // тут сделать определение двух скобочек и знака между ними
    // все разделить на 2 стринга
    //if (counter1==counter2&&counter1==2)
      // text = twoBrackets(text,text);
    //  text = twoBrackets(text,text,sign); нужно сделать ввод
    return text;
  }
  public String twoBrackets(String text1,String text2, Character sign)
  {
    String answer = "";
    //System.out.println("I'm in two twoBrackets");
    ArrayList<String> first = new ArrayList<String>();
    ArrayList<String> second = new ArrayList<String>();
    ArrayList<String> ifirst = new ArrayList<String>();
    ArrayList<String> isecond = new ArrayList<String>();
    ArrayList<String> ffirst = new ArrayList<String>();
    ArrayList<String> ssecond = new ArrayList<String>();
    first = lookForI(text1);
    second = lookForI(text2);
    String maybe="";
    for (int i=0;i<first.size();i++)
    {
      maybe="";
      if (first.get(i).charAt(0)=='c')
      {
        for (int j=1;j<first.get(i).length();j++)
          maybe+=String.valueOf(first.get(i).charAt(j));
        ifirst.add(maybe);
      }
      else
      {
        ffirst.add(first.get(i));
      }
    }
    maybe="";
    for (int i=0;i<second.size();i++)
    {
      maybe = "";
      if (second.get(i).charAt(0)=='c')
      {
        for (int j=1;j<second.get(i).length();j++)
          maybe+=String.valueOf(second.get(i).charAt(j));
        isecond.add(maybe);
      }
      else
      {
        ssecond.add(second.get(i));
      }
    }
    first.clear();
    second.clear();
    /*for (int i=0;i<ffirst.size();i++)
      System.out.println("first "+ffirst.get(i));
    for (int i=0;i<ssecond.size();i++)
      System.out.println("second "+ssecond.get(i));
    for (int i=0;i<ifirst.size();i++)
      System.out.println("ifirst "+ifirst.get(i));
    for (int i=0;i<isecond.size();i++)
      System.out.println("isecond "+isecond.get(i));*/
    if (sign == '+')
    {
      answer = c.performComplexAddition(ffirst.get(0),ssecond.get(0),ifirst.get(0),isecond.get(0));
    }
    if (sign == '-')
    {
      answer = c.performComplexSubtraction(ffirst.get(0),ssecond.get(0),ifirst.get(0),isecond.get(0));
    }
    if (sign == '/')
    {
      answer = c.performComplexDivision(ffirst.get(0),ssecond.get(0),ifirst.get(0),isecond.get(0));
    }
    if (sign == '*')
    {
      answer = c.performComplexMultiplication(ffirst.get(0),ssecond.get(0),ifirst.get(0),isecond.get(0));
    }
      // тут мы сделали разделение на на списки действ и мнимых чисел

    return answer;
  }
  public int lookForMax(int[] array)
  {
    int buf=0;
    for (int i=0;i<array.length;i++)
    {
      if (array[i]>buf)
        buf = array[i];
    }
    return buf;
  }
  public int lookForMin(int[] array)
  {
    int buf=110;
    for (int i=0;i<array.length;i++)
    {
      if (array[i]<buf)
      buf = array[i];
    }
    return buf;
  }
  public ArrayList<String> lookForI(String text)
  {
    boolean check2 = false;
    String walker = "";
    int counter=0;
    ArrayList<String> firstList = new ArrayList<String>();
    ArrayList<String> normalList = new ArrayList<String>();
    ArrayList<String> complexList = new ArrayList<String>();
    Character[] sep = new Character[]{'+','-','/','*'};
    for (int i=0;i<text.length();i++)
    {
      /*if (text.charAt(i)!=' ');
        firstList.add(String.valueOf(text.charAt(i)));*/
        check2 = false;
        for (int j=0;j<sep.length;j++)
        {
          if (text.charAt(i)==sep[j])
          {
            check2 = true;
            counter = j;
          }
        }
        if (check2 == true)
        {
          firstList.add(walker);
          firstList.add(String.valueOf(sep[counter]));
          walker = "";
        }
        if (check2 != true)
        {
          walker +=String.valueOf(text.charAt(i));
          if (i==text.length()-1)
          {
            firstList.add(walker);
            walker = "";
          }
        }
      }
      Character[] seps = new Character[]{'+','/','*'};
      boolean getme = false;
      String sign = "";
      int num = 0;
      for (int i=0;i<firstList.size();i++)
      {
        getme = false;
        for (int j=0;j<firstList.get(i).length();j++)
        {
          if (firstList.get(i).charAt(j)=='i')
          {
            getme = true;
          }
        }
        if (firstList.get(i).equals("+"))
        {
          //System.out.println("I found plus");
          continue;
        }
        if (firstList.get(i).equals("-"))
        {
          sign = "-";
          num = i;
          continue;
        }
        if (getme == true)
        {
          if (i==num+1)
            complexList.add(sign+firstList.get(i));
          else
            complexList.add(firstList.get(i));
        }
        if (getme!=true)
        {
          if (i==num+1)
            normalList.add(sign+firstList.get(i));
          else
            normalList.add(firstList.get(i));
        }
      }
      /*for (int i=0;i<normalList.size();i++)
        System.out.println(normalList.get(i)+" normal");
      for (int i=0;i<complexList.size();i++)
        System.out.println(complexList.get(i)+" complex");*/
      for (int i=0;i<complexList.size();i++)
        normalList.add("c"+complexList.get(i));
      return normalList;
  }
  public String badSign(String text)
  {
    String addback = "+-";
  //  String adddiv = "+/"
    String newText="";
    int count =0;
    for (int i=0;i<text.length()-1;i++)
    {
      String check = String.valueOf(text.charAt(i))+String.valueOf(text.charAt(i+1));
      if(check.equals(addback))
      {
        System.out.println("i found!");
        for (int j=0;j<text.length();j++)
        {
          /*if (j==text.length()-1)
          {
            newText+=text.charAt(text.length()-1);
          }*/
          if (j<=i+1&&j>i)
          {

          }
          if (j==i)
          {
            //newText+="-";
          }
          else
            newText+=text.charAt(j);
        }
        System.out.println("i'll return "+newText);
      }
      else count++;
    }
    if (count == text.length()-1)
      newText = text;
    return newText;
  }
  public ArrayList<String> firstNumber(ArrayList<String> arrayList)
  {
    // neпервое число минусовое. И это оч оч оч оч плохо.
    ArrayList<String> arrayList2 = new ArrayList<String>();
    System.out.println("in first number");
    for (int i=0;i<arrayList.size();i++)
    System.out.println(arrayList.get(i));
    System.out.println("look on work");
    for (int i=0;i<arrayList.size();i++)
    {
      System.out.println(arrayList.get(i));
      if (arrayList.get(i).length()==0||arrayList.get(i).equals(""))
      {
        arrayList2.add(String.valueOf(arrayList.get(i+1)+arrayList.get(i+2)));
        i+=2;
        //System.out.println("arrayList2 "+arrayList2.get(i));
        continue;
      }
      arrayList2.add(arrayList.get(i));
    }
    System.out.println("changed list");
    for (int i=0;i<arrayList2.size();i++)
    System.out.println(arrayList2.get(i));
    return arrayList2;
  }
}

import java.util.ArrayList;
public class parserclass implements parser
{
  calc c = new calc();
  public String chooseStep(String text)
  {
    boolean check  = false;
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
      secondStep(text);
    }
    else
    {
      //System.out.println("I choose first Step");
      firstStep(text);
    }
    return "0";
  }
  public String firstStep(String text)
  {
  //  if (text.length()==1)
    //  return text;
  //  System.out.println("I'm in parserclass");
  //  System.out.println(text);
    boolean check = false;
    int n = 0;
    int n2 = 0;
    String hero = "";
    for (int i=0;i<text.length();i++)
    {
      if (text.charAt(i)=='(')
      {
        check = true;
        n=i+1;
      }
    }
    if (check==true)
    {
      String text2 = text;
      //System.out.println("Check is true");
      for (int i = text.length()-1;i>=0;i--)
      {
        if (text.charAt(i)==')')
          n2 = i;
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
  //  System.out.println(text+" it is a text in true");
  //  System.out.println(text.length()+" it is a length in true");
    /*if (text.length()==1)
      return text;*/
    }
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
      //System.out.println("i want to say smth");
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
      /*for (int i=0;i<firstList.size();i++)
      {
        System.out.println(firstList.get(i));
      }*/
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
        //System.out. println(go+" is go");
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
      res = c.performSubtraction(list.get(0),list.get(2));
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
  public String secondStep(String text)
  {
    int counter1 = 0;
    int counter2 = 0;
    for (int i=0;i<text.length();i++)
    {
      if (text.charAt(i) == ')')
        counter1++;
      if (text.charAt(i)=='(')
        counter2++;
    }
    // тут сделать определение двух скобочек и знака между ними
    // все разделить на 2 стринга
    //if (counter1==counter2&&counter1==2)
      // text = twoBrackets(text,text);
      text = twoBrackets(text,text);
    return text;
  }
  public String twoBrackets(String text1,String text2)
  {
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
    for (int i=0;i<ffirst.size();i++)
      System.out.println("first "+ffirst.get(i));
    for (int i=0;i<ssecond.size();i++)
      System.out.println("second "+ssecond.get(i));
    for (int i=0;i<ifirst.size();i++)
      System.out.println("ifirst "+ifirst.get(i));
    for (int i=0;i<isecond.size();i++)
      System.out.println("isecond "+isecond.get(i));
      // тут мы сделали разделение на на списки действ и мнимых чисел
    return text1;
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
}

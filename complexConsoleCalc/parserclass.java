import java.util.ArrayList;
public class parserclass implements parser
{
  calc c = new calc();
  public String firstStep(String text)
  {
  //  System.out.println("I'm in parserclass");
  //  System.out.println(text);
    boolean check = false;
    for (int i=0;i<text.length();i++)
    {
      if (text.charAt(i)=='(')
        check = true;
    }
    if (check==true)
    {
      //System.out.println("Check is true");
    }
    String walker = "";
    int counter = 0;
    boolean check2 = false;
    String answer="";
    if (check==false)
    {
      //System.out.println("check is false");
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
}

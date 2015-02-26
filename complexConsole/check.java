public class check
{
  public void check(String text)
  {
    boolean go = check2(text);
    if (go==true)
    {
      twoStackAlgo tsa = new twoStackAlgo();
      complexTwoStackAlgo ctsa = new complexTwoStackAlgo();
      checkForInts cfi = new checkForInts();
      double answ = 0;
      Complex cansw1 = new Complex(0,0);
      boolean check = false;
      boolean ex = false;
      for (int i=0;i<text.length();i++)
      {
        if (text.charAt(i)=='i')
          check = true;
      }
      if (check == false)
      {
        answ = tsa.evaluation(text);
        ex = cfi.check(String.valueOf(answ));
        if (ex == true)
        {
          int answe = (int)answ;
          System.out.println(answe);
        }
        else
        {
          answ = java.lang.Math.round(answ*1000)/1000.0d;
          ex = cfi.check(String.valueOf(answ));
          if (ex == true)
          {
            int answe = (int)answ;
            System.out.println(answe);
          }
          else
          {
            System.out.println(answ);
          }
        }
      }
      else if (check == true)
      {
        cansw1 =ctsa.complexEvaluation(text);
        System.out.println(cansw1);
      }
    }
    else
    {
    }
  }
  public boolean check2(String text)
  {
    boolean bracket = false;
    boolean answer = true;
    for (int i=0;i<text.length();i++)
      if (text.charAt(i)=='('||text.charAt(i)==')')
        {
          bracket = true;
          break;
        }
    if (text.length()==1||text.length()==0)
    {
      answer = false;
      return answer;
    }
    else if (bracket == true)
    {
      int count=0;
      for (int i=0;i<text.length();i++)
      {
        if (text.charAt(i)=='(')
          count++;
        if (text.charAt(i)==')')
          count++;
      }
      if (count%2==0)
        answer = true;
      else
        answer = false;
    }
    if (answer == true)
    {

      parser p = new parser();
      String[] array = p.parser(text);
      String[] sep = new String[]{")","+","-","*","/"};
      int countOps = 0;
      int countVal = 0;
      for (int i=0;i<array.length;i++)
      {
        for (int j=0;j<sep.length;j++)
        {
          if (array[i].equals(sep[j]))
          {
            countOps++;
            break;
          }
        }
      }
      countVal = array.length-countOps;
      if (countVal==countOps+1)
      {
        answer = true;
        return answer;
      }
      else
      {
        answer = false;
        return answer;
      }
    }
    return answer;
  }
}

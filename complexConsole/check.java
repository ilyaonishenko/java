public class check
{
  public void check(String text)
  {
    twoStackAlgo tsa = new twoStackAlgo();
    complexTwoStackAlgo ctsa = new complexTwoStackAlgo();
    double answ = 0;
    Complex cansw1 = new Complex(0,0);
    boolean check = false;
    for (int i=0;i<text.length();i++)
    {
      if (text.charAt(i)=='i')
        check = true;
    }
    if (check == false)
    {
      answ = tsa.evaluation(text);
      System.out.println(answ);
    }
    else if (check == true)
    {
      cansw1 =ctsa.complexEvaluation(text);
      System.out.println(cansw1);
    }
  }
}

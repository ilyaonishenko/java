import java.util.*;
public class Main
{

  public static void main(String[] args)
  {
    double answ = 0;
    Complex cansw1 = new Complex(0,0);
    Scanner sc = new Scanner(System.in);
    twoStackAlgo tsa = new twoStackAlgo();
    complexTwoStackAlgo ctsa = new complexTwoStackAlgo();
    System.out.println("Введите выражение");
    String text = sc.next();
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

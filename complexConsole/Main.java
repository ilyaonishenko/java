import java.util.*;
public class Main
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    twoStackAlgo tsa = new twoStackAlgo();
    System.out.println("Введите выражение");
    String text = sc.next();
    double answ = tsa.evaluation(text);
    System.out.println(answ);
  }
}

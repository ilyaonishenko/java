import java.util.*;
public class Main
{

  public static void main(String[] args)
  {
    check ch = new check();
    Scanner sc = new Scanner(System.in);
    System.out.println("Введите выражение");
    String text = sc.next();
    try
    {
        ch.check(text);
    }
    catch(java.lang.NumberFormatException e)
    {
        System.out.println("Ooops");
    }
  }
}

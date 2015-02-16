import java.util.*;
public class Main
{

  public static void main(String[] args)
  {
    check ch = new check();
    Scanner sc = new Scanner(System.in);
    System.out.println("Введите выражение");
    String text = sc.next();
    ch.check(text);
  }
}

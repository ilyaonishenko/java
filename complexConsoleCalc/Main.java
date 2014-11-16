import java.util.Scanner;
public class Main
{
  public static void main (String[] args)
  {
    System.out.println("Введите первое число");
    Scanner sc = new Scanner(System.in);
    String aString = sc.next();
    String bString = sc.next();
    calc c = new calc();
    double w = 0;
    String ww = " ";
    Boolean check = false;
    int t=0;
    while (check!=true)
    {
      System.out.println("1)addition\n2)subtraction\n3)mult\n4)division\n5)compAddition\n6)compSub\n7)compmult\n8)comDiv\n9)exit");
      System.out.println("choose:");
      t = sc.nextInt();
      switch(t)
      {
        case 1:
        {
          System.out.println("Addition");
          w = c.performAddition(aString,bString);
          System.out.println("result: "+w+"\n\n");
          break;
        }
        case 2:
        {
          System.out.println("Subtraction");
          w = c.performSubtraction(aString,bString);
          System.out.println("result: "+w+"\n\n");
          break;
        }
        case 3:
        {
          System.out.println("Multiplication");
          w = c.performMultiplication(aString,bString);
          System.out.println("result: "+w+"\n\n");
          break;
        }
        case 4:
        {
          System.out.println("Division");
          w = c.performDivision(aString,bString);
          System.out.println("result: "+w+"\n\n");
          break;
        }
        case 5:
        {
          System.out.println("Complex addition");
          ww = c.performComplexAddition(aString,bString);
          System.out.println("result: "+ww);
          break;
        }
        case 6:
        {
          System.out.println("Complex subrtaction");
          ww = c.performComplexSubtraction(aString,bString);
          System.out.println("result: "+ww);
          break;
        }
        case 7:
        {
          System.out.println("Complex multiplication");
          ww = c.performComplexMultiplication(aString,bString);
          System.out.println("result: "+ww);
          break;
        }
        case 8:
        {
          System.out.println("Complex division");
          ww = c.performComplexDivision(aString,bString);
          System.out.println("result: "+ww);
          break;
        }
        case 9:
        {
          check=true;
          break;
        }
      }
    }
  }
}

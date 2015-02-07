import java.lang.Math;
import java.util.Random;
public class Flips
{
  public static void main(String[] args)
  {
    int T = Integer.parseInt(args[0]);

      Counter heads = new Counter("heads");
      Counter tails = new Counter("tails");
      Random rand = new Random();
      for(int i=0;i<100;i++)
      {
        if (i>rand.nextInt(100))
          heads.increment();
        else
          tails.increment();
      }
      System.out.println(heads);
      System.out.println(tails);
  }
}

import java.util.*;
public class fixedCapacityStackOfStrings
{
  private String[] a;
  private int N;
  public fixedCapacityStackOfStrings(int cap)
  {
    a = new String[cap];
  }
  public boolean isEmpty()
  {
    return this.N==0;
  }
  public int size()
  {
    return this.N;
  }
  public void push(String item)
  {
    a[this.N++] = item;
  }
  public String pop()
  {
    return a[--N];
  }
  public static void main(String[] args)
  {
    Scanner reader = new Scanner(System.in);

    fixedCapacityStackOfStrings s;
    s = new fixedCapacityStackOfStrings(100);
    for (int i=0;i<15;i++)
    {
      String item = reader.next();
      if (!item.equals("-"))
        s.push(item);
      else
        if (!s.isEmpty())
          s.pop();
    }
    System.out.println("(" + s.size() + " left on stack)");
  }
}

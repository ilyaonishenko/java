public class Counter
{
  //vars
  private final String name;
  private int count;
  //constructor
  public Counter (String id)
  {
    name = id;
  }
  public void increment()
  {
    count++;
  }
  public int tally()
  {
    return count;
  }
  public String toString()
  {
    return count+" "+name;
  }
  public static void main (String[] args)
  {
    Counter heads = new Counter("Heads");
    Counter tails = new Counter("tails");
    heads.increment();
    heads.increment();
    tails.increment();
    System.out.println(heads);
    System.out.println(tails);
  }
}

public class fixedCapacityStack<Item>
{
  //realisation for Strings
  private Item[] a;
  private int N;
  public fixedCapacityStack(int cap)
  {
    a = (Item[])new Object[cap];
  }
  public boolean isEmpty()
  {
    return this.N==0;
  }
  public int size()
  {
    return this.N;
  }
  public void push(Item item)
  {
    a[N++] = item;
  }
  public Item pop()
  {
    return a[--N];
  }
  public static void main (String[] args)
  {
    fixedCapacityStack<String> s;
    s = new fixedCapacityStack<String>(100);
    while (!StdIn.isEmpty())
    {
      String item = StdIn.readString();
      if (!item.equals("-"))
           s.push(item);
      else if (!s.isEmpty())
        StdOut.print(s.pop() + " ");
    }
    StdOut.println("(" + s.size()+ "left on stack)");
  }
}

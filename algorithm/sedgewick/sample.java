import java.util.Iterator;
public class queue<Item>
{
  public int rank(int key,int[] a)
  {
    int lo=0;
    int hi = a.lenght-1;
    while (lo<hi)
    {
      int mid = lo+(hi-lo)/2
      if (key<a[mid])
        hi = mid-1;
      else if (key>a[mid])
        lo = mid+1;
      else
        return mid;
    }
    return -1;
  }
  private class Node
  {
    Item item;
    Node next;
  }
  private Node first;
  private Node last;
  private int N;
  public boolean isEmpty()
  {
    return N==0;
  }
  public int size()
  {
    return N;
  }
  public void enqueue(Item item)
  {
    Node oldlast = last;
    last = new Node();
    last.next = null;
    last. item = item;
    if (isEmpty())
    {
      first = last;
    }
    else
      oldlast.next = last;
    N++;
  }
  public item dequeue()
  {
    Item item = first.item;
    first = first.next;
    if (isEmpty())
      last = null;
    N--;
    return item;
  }
  private class ListIterator implements Iterator<Item>
  {
    private Node current = first;
    public boolean hasNext()
    {
      return current!=null;
    }
    public Item next()
    {
      Item item = current.item;
      current = current.next;
      return item;
    }
  }
}
public class sample<Item>
{
  private class Node
  {
    Item item;
    Node next;
  }
  private Node first;
  private int N;
  public boolean isEmpty()
  {
    return this.N==0;
  }
  public int size()
  {
    return this.N;
  }
  public void push (Item item)
  {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
    N++;
  }
  public Item pop()
  {
    Item item = first.item;
    first = first.next;
    N--;
    return item;
  }
  private class ListIterator implements Iterator<Item>
  {
    private Node current = first;
    public boolean hasNext()
    {
      return current !=null;
    }
    public Item next()
    {
      Item item = current.item;
      current = current.next;
      return item;
    }
  }
  public Iterator<Item> iterator()
  {
    return new ListIterator();
  }
  public static void main (String[] args)
  {
    sample<String> stack = new sample<String>();
    stack.push("hello");
    stack.push("Mr.");
    stack.push("robinson");
    for (int i=0;i<stack.size();i++)
    {
      System.out.println(stack);
    }
  }
}

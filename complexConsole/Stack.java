import java.util.Iterator;
//linked list implementation
public class Stack<Item>
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
  public void push(Item item)
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
  public Item peek()
  {
    if (isEmpty()) throw new RuntimeException("Stack underflow");
        return first.item;
  }
  private class ListIterator implements Iterator<Item>
  {
    private Node current = first;
    public boolean hasNext()
    {
      return current !=null;
    }
    public void remove()
    {

    }
    public Item next()
    {
      Item item = current.item;
      current = current.next;
      return item;
    }
  }
}

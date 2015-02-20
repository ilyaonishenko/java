public class Env
{
  private int size_x;
  private int size_y;
  public Character[][] field;
  public Env(int x,int y)
  {
    size_x = x;
    size_y = y;
    init();
  }
  public void init()
  {
    field = new Character[size_y][size_x];
    for (int i=0;i<size_y;i++)
    {
      for (int j=0;j<size_x;j++)
      {
        field[i][j] = '-';
      }
    }
  }
  public void Print()
  {
    for (int i=0;i<size_y;i++)
    {
      for (int j=0;j<size_x;j++)
      {
        System.out.print(field[i][j]+" ");
      }
      System.out.print("\n");
    }
  }
}

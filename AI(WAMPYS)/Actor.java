public class Actor
{
  private int x;
  private int y;
  private char id;
  private char show;
  private char none = '-';
  private char before;
  public Actor(int x,int y,char id,char show,Env env)
  {
    this.x = x;
    this.y = y;
    this.id = id;
    this.show = show;
    before = env.field[x][y];
    env.field[x][y] = id;
    if (x!=env.field.length-1)
        if (env.field[x+1][y]==none)
            env.field[x+1][y]=show;
    if (y!=env.field.length-1)
        if (env.field[x][y+1]==none)
            env.field[x][y+1]=show;
    if (x!=0)
        if (env.field[x-1][y]==none)
            env.field[x-1][y]=show;
    if (y!=0)
        if (env.field[x][y-1]==none)
            env.field[x][y-1]=show;
  }
  public int getX()
  {
      return x;
  }
  public int getY()
  {
      return y;
  }
  public void delete(Env env)
  {
      env.field[x][y] = before;
  }
  public char getBefore()
  {
      return before;
  }
}

public class Actor
{
  private int x;
  private int y;
  private char id;
  private char show;
  private char none = '-';
  public Actor(int x,int y,char id,char show,Env env)
  {
    this.x = x;
    this.y = y;
    this.id = id;
    this.show = show;
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
}

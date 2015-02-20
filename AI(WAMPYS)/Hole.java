public class Hole
{
  public Hole(int x,int y,Env env)
  {
    super(x,y,env);
    env.field[x][y] = '±';
  }
}

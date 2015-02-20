public class Wampus extends Ccharacter
{
//  private int x;
  //private int y;
  public Wampus(int x,int y,Env env)
  {
    super(x,y,env);
    env.field[x][y] = 'w';
  }
}

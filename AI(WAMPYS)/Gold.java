public class Gold extends Actor
{
  public Gold(int x,int y,Env env)
  {
    super(x,y,env);
    env.field[x][y] = 'g';
  }
}

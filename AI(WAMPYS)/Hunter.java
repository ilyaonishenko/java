public class Hunter extends Ccharacter
{
  public Hunter(int x,int y,Env env)
  {
    super (x,y,env);
    env.field[x][y] = 'h';
  }
}

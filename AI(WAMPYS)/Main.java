public class Main
{
  public static void main(String[] args)
  {
    Env env = new Env(5,5);
    env.Print();
    Wampus wampus = new Wampus(2,2,env);
    env.Print();
  }
}

public class Main
{
    final static char none = '-';
    public static void main(String[] args)
    {
        Env env = new Env(10,10);
        Wampus wampus = new Wampus(0,0,none,none,env);
        Hole hole = new Hole(0,0,none,none,env);
        Hunter hunter = new Hunter(0,0,none,none,env);
        Gold gold = new Gold(0,0,none,none,env);
        int num = 3;
        Generator gen = new Generator(env,wampus,hunter,hole,num,gold);
        System.out.println("After2:");
        env.Print();
    }
}

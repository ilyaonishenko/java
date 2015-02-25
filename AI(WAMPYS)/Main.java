import java.util.HashMap;
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
        Generator gen = new Generator(env,wampus,hunter,hole,gold);
        wampus = gen.getWampusLocation(wampus,env);
        hunter = gen.getHunterLocation(hunter,env);
        hole = gen.getHoleLocation(hole,env);
        gold = gen.getGoldLocation(gold,wampus,env);
        HashMap<Integer,Character> map = new HashMap<Integer,Character>();
        /*System.out.println("One");
        env.Print();
        hunter = hunter.moveUp(hunter,env);
        System.out.println("Two");
        env.Print();
        char[] arr = hunter.read(env);
        for (int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }*/
        for (int i=0;i<10;i++)
        {
            System.out.println(i);
            env.Print();
            map = hunter.read(env);
            hunter = hunter.understand(hunter,env,map);
        }
    }
}

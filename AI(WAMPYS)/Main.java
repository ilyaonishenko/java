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
        System.out.println("One");
        env.Print();
        int x = hunter.getX();
        int y = hunter.getY();
        System.out.println("x is "+x);
        System.out.println("y is "+y);
        hunter = hunter.moveUp(hunter,env);
        System.out.println("Two");
        env.Print();
        x = hunter.getX();
        y = hunter.getY();
        System.out.println("x is "+x);
        System.out.println("y is "+y);
    }
}

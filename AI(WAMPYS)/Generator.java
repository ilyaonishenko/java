import java.util.Random;
public class Generator
{
	final static char h = 'h';
    final static char w = 'w';
    final static char g = 'g';
    final static char d = '±';
    final static char _d = '~';
    final static char _g = '+';
    final static char _w = '§';
    final static char none = '-';
	Random r = new Random();
	public Generator(Env env,Wampus wampus,Hunter hunter,Hole hole,Gold gold)
	{
		//wampus = new Wampus(3,7,env);
		/*wampus = getWampusLocation(wampus,env);
		gold = getGoldLocation(gold,wampus,env);
		hunter = getHunterLocation(hunter,env);
		for (int i=0;i<numHole;i++)
		{
			hole = getHoleLocation(hole,env);
		}*/
	}
	public Wampus getWampusLocation(Wampus wampus,Env env)
	{
		int x=0,y=0;
		while (x==0||x==env.field.length)
			x = r.nextInt(env.field.length-1);
		while (y==0||x==env.field.length)
			y = r.nextInt(env.field.length-1);
		//System.out.println("x is "+x+" and y is "+y);
		return new Wampus(x,y,w,_w,env);
	}
	public Gold getGoldLocation(Gold gold,Wampus wampus,Env env)
	{
		int x=0,y=0;
		x = wampus.getX();
		y = wampus.getY();
		System.out.println("x is "+x+" and y is "+y);
		int loc = r.nextInt(3);//0-up,1-right,2 -down,3-left;
		if (loc == 0)
			y--;
		else if (loc==1)
			x++;
		else if (loc==2)
			y++;
		else x--;
		System.out.println("x is "+x+" and y is "+y);
		return new Gold(x,y,g,_g,env);
	}
	public Hunter getHunterLocation(Hunter hunter,Env env)
	{
		int x=0,y=0;
		while (x==0||x==env.field.length)
			x = r.nextInt(env.field.length-1);
		while (y==0||x==env.field.length)
			y = r.nextInt(env.field.length-1);
		return new Hunter(x,y,h,none,env);
	}
	public Hole getHoleLocation(Hole hole,Env env)
	{
		int x=0,y=0;
		while (x==0||x==env.field.length)
			x = r.nextInt(env.field.length-1);
		while (y==0||x==env.field.length)
			y = r.nextInt(env.field.length-1);
		return new Hole(x,y,d,_d,env);
	}
}

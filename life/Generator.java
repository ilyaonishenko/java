import java.util.Random;
public class Generator
{
	final static char p = 'P';
	final static char pr = 'X';
	final static char h = 'H';
	final static char none = '-';
	static int x=0,y=0;
	private static Generator gen;
	static Random r = new Random();
	private Generator()
	{
	}
	public static Generator getGen()
	{
		if (gen==null)
			gen = new Generator();
		return gen;
	}
	public static Predator getPredatorLocation(Predator predator)
	{
		x=0;y=0;
		while (x==0||x==Env.field.length)
			x = r.nextInt(Env.field.length-1);
		while (y==0||x==Env.field.length)
			y = r.nextInt(Env.field.length-1);
		//System.out.println("x is "+x+" and y is "+y);
		return new Predator(x,y,pr,none);
	}
	public static Herbivore getHerbivoreLocation(Herbivore herbivore)
	{
		x=0;y=0;
		while (x==0||x==Env.field.length)
			x = r.nextInt(Env.field.length-1);
		while (y==0||x==Env.field.length)
			y = r.nextInt(Env.field.length-1);
		//System.out.println("x is "+x+" and y is "+y);
		return new Herbivore(x,y,h,none);
	}
	public static Plant getPlantLocation(Plant plant)
	{
		x=0;y=0;
		while (x==0||x==Env.field.length)
			x = r.nextInt(Env.field.length-1);
		while (y==0||x==Env.field.length)
			y = r.nextInt(Env.field.length-1);
		//System.out.println("x is "+x+" and y is "+y);
		return new Plant(x,y,p,none);
	}
}

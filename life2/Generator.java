import java.util.Random;
public class Generator
{
	private static char he = 'h';
	private static char pl = 'P';
	private static char pr = 'X';
	private static Generator gen;
	private static Random r = new Random();
	private static int x,y;
	private Generator(){

	}
	public static Generator getGen(){
		if (gen==null)
			gen = new Generator();
		return gen;
	}
	public static void getLocation(Predator predator){
		x=0;y=0;
		while (x==0||x==Env.field.length){
			x = r.nextInt(Env.field.length-1);
		while (y==0||y==Env.field.length){
			y =r.nextInt(Env.field.length-1);
		}
		}
		predator.setX(x);
		predator.setY(y);
		predator.setID(pr);
		predator.refresh();
	}
	public static void getLocation(Herbivore h){
		x=0;y=0;
		while (x==0||x==Env.field.length){
			x = r.nextInt(Env.field.length-1);
		while (y==0||y==Env.field.length){
			y =r.nextInt(Env.field.length-1);
		}
		}
		h.setX(x);
		h.setY(y);
		h.setID(he);
		h.refresh();
	}
	public static void getLocation(Plant p){
		x=0;y=0;
		while (x==0||x==Env.field.length){
			x = r.nextInt(Env.field.length-1);
		while (y==0||y==Env.field.length){
			y =r.nextInt(Env.field.length-1);
		}
		}
		p.setX(x);
		p.setY(y);
		p.setID(pl);
		p.refresh();
	}
}
// Университет Предпринимательства 11

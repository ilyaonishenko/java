import java.util.LinkedList;
import java.util.List;
public class Main{
	private static final char pr = 'X';
	private static final char p = 'P';
	private static final char h = 'h';
	private static final char none = '-';
	//public static List<Predator> predatorsList = new LinkedList<Predator>();
	//public static List<Herbivore> herbivoresList = new LinkedList<Herbivore>();
	//public static List<Plant> plantsList = new LinkedList<Plant>();
	public static void main(String[] args){
		int N=10;
		Env.getEnv(N);
		Herbivore herb = new Herbivore('-',0,0);
		Predator pred = new Predator('-',0,0);
		Plant plant = new Plant('-',0,0);
		Generator.getLocation(herb);
		Generator.getLocation(pred);
		Generator.getLocation(plant);
		Env.Print();
	}
}

import java.util.LinkedList;
import java.util.List;
public class Main{
	private static final char pr = 'X';
	private static final char p = 'P';
	private static final char h = 'H';
	private static final char none = '-';
	public static List<Predator> predatorsList = new LinkedList<Predator>();
	public static List<Herbivore> herbivoresList = new LinkedList<Herbivore>();
	public static List<Plant> plantsList = new LinkedList<Plant>();
	public static void main(String[] args){
		int N=10;
		Env.getEnv(N);
		//'H',0,0
		Herbivore herb = new Herbivore('H',7,8);
		Predator pred = new Predator('X',6,8);
		Plant plant = new Plant('P',5,5);
		Herbivore herb1 = new Herbivore('H',2,2);
		Predator pred1 = new Predator('X',4,4);
		Plant plant1 = new Plant('P',1,1);
		predatorsList.add(pred);
		predatorsList.add(pred1);
		herbivoresList.add(herb);
		herbivoresList.add(herb1);
		plantsList.add(plant);
		plantsList.add(plant1);
		herb = null;
		herb1 = null;
		pred = null;
		pred1 = null;
		plant = null;
		plant1 = null;
		Env.Print();
		for(Herbivore h:herbivoresList)
			h.moveRight();
		for(Predator p:predatorsList)
			p.moveRight();
		System.out.println("______________");
		Env.Print();
		//Generator.getLocation(herb);
		//Generator.getLocation(pred);
		//Generator.getLocation(plant);
	}
}

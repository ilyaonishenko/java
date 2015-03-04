import java.util.HashMap;
public class Main
{
	final static char none = '-';
	final static char p = 'P';
	final static char pr = 'X';
	final static char h = 'H';
	public static void main(String[] args)
	{
		Env.getEnv(5,5);
		Generator.getGen();
		System.out.println("One");
		Env.Print();
		Predator predator = new Predator(0,0,none,none);
		Herbivore herbivore = new Herbivore(0,0,none,none);
		Plant plant = new Plant(0,0,none,none);
		predator = Generator.getPredatorLocation(predator);
		herbivore = Generator.getHerbivoreLocation(herbivore);
		plant = Generator.getPlantLocation(plant);
		/*System.out.println("Two");
		Env.Print();
		System.out.println("Three");
		predator.moveUp(predator);
		Env.Print();*/
		System.out.println("P for plant");
		System.out.println("X for predator");
		System.out.println("H for herbivore");
		HashMap<Integer,Character> map1 = new HashMap<Integer,Character>();
		HashMap<Integer,Character> map2 = new HashMap<Integer,Character>();
		System.out.println("ID "+predator.getID());
		predator.setID('Q');
		System.out.println("ID "+predator.getID());
		predator = predator.moveDown(predator);
		System.out.println("ID "+predator.getID());
        for (int i=0;i<10;i++)
        {
            System.out.println(i);
            Env.Print();
			map2 = herbivore.read();
			herbivore = herbivore.understand(herbivore,map2);
            map1 = predator.read();
            predator = predator.understand(predator,map1,herbivore);
			System.out.println("Energy: "+predator.getEnergy());
        }
	}
}

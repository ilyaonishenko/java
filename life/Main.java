public class Main
{
	final static char none = '-';
	public static void main(String[] args)
	{
		Env.getEnv(10,10);
		Generator.getGen();
		System.out.println("One");
		Env.Print();
		Predator predator = new Predator(0,0,none,none);
		Herbivore herbivore = new Herbivore(0,0,none,none);
		Plant plant = new Plant(0,0,none,none);
		predator = Generator.getPredatorLocation(predator);
		herbivore = Generator.getHerbivoreLocation(herbivore);
		plant = Generator.getPlantLocation(plant);
		System.out.println("Two");
		Env.Print();
	}
}

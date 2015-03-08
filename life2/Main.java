public class Main
{
	private static final char pr = 'X';
	private static final char p = 'P';
	private static final char h = 'h';
	public static void main(String[] args)
	{
		Env.getEnv(5);
		Predator predator = new Predator(pr,3,3);
		Herbivore herbivore = new Herbivore(h,1,1);
		Plant plant = new Plant(p,4,4);
		System.out.println("-------------one-----------");
		Env.Print();
		for (int i=0;i<10;i++)
		{
			System.out.println(i);
			herbivore.sight();
			predator.sight();
			herbivore.thinking(p);
			predator.thinking(h,herbivore);
			Env.Print();
		}
	}
}

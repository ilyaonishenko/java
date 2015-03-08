public class Main
{
	private static final char pr = 'X';
	private static final char p = 'P';
	private static final char h = 'h';
	public static void main(String[] args)
	{
		Env.getEnv(10);
		Predator predator = new Predator(pr,8,8);
		Herbivore herbivore = new Herbivore(h,5,5);
		Plant plant = new Plant(p,3,3);
		System.out.println("-------------one-----------");
		Env.Print();
		for (int i=0;i<10;i++)
		{
			System.out.println(i);
			predator.sight();
			herbivore.sight();
			predator.thinking(h);
			herbivore.thinking(p);
			Env.Print();
		}
	}
}

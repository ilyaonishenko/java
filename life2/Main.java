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
		predator.info();
		predator.moveUp();
		predator.moveLeft();
		predator.moveDown();
		System.out.println("-------------two-----------");
		Env.Print();
		predator.info();
	}
}

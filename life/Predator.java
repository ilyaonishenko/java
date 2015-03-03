public class Predator extends Animal
{
	public Predator(int x,int y,char id,char show)
	{
		super(x,y,id,show);
		eatBehavior = new EatHerbivore();
	}
	public void performEating()
	{
		eatBehavior.Eat();
	}
}

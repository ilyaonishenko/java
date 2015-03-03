public class Herbivore extends Animal
{
	public Herbivore(int x,int y,char id,char show)
	{
		super(x,y,id,show);
		eatBehavior = new EatPlant();
	}
	public void performEating()
	{
		eatBehavior.Eat();
	}
}

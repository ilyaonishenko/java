public class Predator extends Animal
{
	public Predator(char id,int x,int y)
	{
		super(id,x,y);
		eatBehavior = new EatHerbivore();
	}
	public void performEating(Herbivore herb)
	{
		eatBehavior.Eat(herb);
	}
}

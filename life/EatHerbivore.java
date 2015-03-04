public class EatHerbivore implements EatBehavior
{
	final static char none = '-';
	public void Eat(Predator predator,Herbivore herb)
	{
		predator.setEnergy(herb.getEnergy());
		herb.setID(none);
		System.out.println("set");
	}
}

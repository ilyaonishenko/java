public class EatHerbivore implements EatBehavior
{
	final static char none = '-';
	public void Eat(Predator predator,Herbivore herb)
	{
		predator.setEnergy(predator.getEnergy()+herb.getEnergy());
		/*herb.setID(none);
		herb.reInit();
		//herb = new Dead();*/
		herb.dead();
		herb.reInit();
		System.out.println("set "+herb.getID());
	}
}

public class EatHerbivore implements EatBehavior{
	final char none = '-';
	public void Eat(Animal animal){
		setEnergy(getEnergy()+animal.getEnergy());
	}
}

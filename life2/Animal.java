public class Animal extends Actor
{
	public Animal (char id,int x,int y)
	{
		super(id,x,y);
	}
	public void greeting ()
	{
		System.out.println("Hello world");
	}
	public void moveUp()
	{
		clear();
		setY(getY()-1);
		setEnetgy(getEnergy()-1);
		refresh();
	}
	public void moveDown()
	{
		clear();
		setY(getY()+1);
		setEnetgy(getEnergy()-1);
		refresh();
	}
	public void moveLeft()
	{
		clear();
		setX(getX()-1);
		setEnetgy(getEnergy()-1);
		refresh();
	}
	public void moveRight()
	{
		clear();
		setX(getX()+1);
		setEnetgy(getEnergy()-1);
		refresh();
	}
}

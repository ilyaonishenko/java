import java.util.HashMap;
import java.util.Random;
public class Herbivore extends Animal
{
	private int x,y;
	private char id;
	final static char show = '-';
	private int _energy;
	Random r =new Random();
	public Herbivore(int x,int y,char id,char show)
	{
		super(x,y,id,show);
//		eatBehavior = new EatPlant();
		this.x= x;
		this.y=y;
		this.id=id;
	}
	/*public void performEating()
	{
		eatBehavior.Eat();
	}*/
	public Herbivore moveUp(Herbivore herb)
	{
		//this.y--;
		herb.delete();
		herb.setY(this.y--);
		_energy = herb.getEnergy()-1;
		//herb = new Herbivore(x,y,id,show);
		herb.setEnergy(_energy);
		herb.reInit();
		return herb;
	}
	public Herbivore moveDown(Herbivore herb)
	{
		//this.y++;
		herb.delete();
		herb.setY(this.y++);
		//herb.delete();
		_energy = herb.getEnergy()-1;
		//herb = new Herbivore(x,y,id,show);
		herb.setEnergy(_energy);
		herb.reInit();
		return herb;
	}
	public Herbivore moveRight(Herbivore herb)
	{
		//this.x++;
		herb.delete();
		herb.setX(this.x++);
		//herb.delete();
		_energy = herb.getEnergy()-1;
		//herb = new Herbivore(x,y,id,show);
		herb.setEnergy(_energy);
		herb.reInit();
		return herb;
	}
	public Herbivore moveLeft(Herbivore herb)
	{
		//this.x--;
		herb.delete();
		herb.setX(this.x--);
		//herb.delete();
		_energy = herb.getEnergy()-1;
		//herb = new Herbivore(x,y,id,show);
		herb.setEnergy(_energy);
		herb.reInit();
		return herb;
	}
	public Herbivore understand(Herbivore herb,HashMap map)
    {
        if (herb.getBefore()=='P')
        {
            System.out.println("YOU WIN H");
        }
		int i = r.nextInt(3);
		try
		{
			if ((char)map.get(i)!='X')
			{
				if (i==0&&y>0)
					return herb.moveUp(herb);
				if (i==1&&x<Env.field.length-1)
					return herb.moveRight(herb);
				if (i==2&&y<Env.field.length-1)
					return herb.moveDown(herb);
				if (i==3&&x>0)
					return herb.moveLeft(herb);
			}
		}
		catch(NullPointerException e)
		{

		}
        return herb;
    }
}

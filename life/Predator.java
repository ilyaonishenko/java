import java.util.HashMap;
import java.util.Random;
public class Predator extends Animal
{
	private int x,y;
	private char id;
	Random r = new Random();
	private int _energy;
	final static char show = '-';
	public Predator(int x,int y,char id,char show)
	{
		super(x,y,id,show);
		eatBehavior = new EatHerbivore();
		lifeBehavior = new Is_Alive();
		this.x= x;
		this.y=y;
		this.id=id;
	}
	public void performEating(Predator predator,Herbivore herb)
	{
		eatBehavior.Eat(predator,herb);
	}
	public boolean performLife()
	{
		return lifeBehavior.live();
	}
	public Predator moveUp(Predator predator)
	{
		//this.y--;
		predator.delete();
		predator.setY(this.y--);
		_energy = predator.getEnergy()-1;
		//predator = new Predator(x,y,id,show);
		predator.setEnergy(_energy);
		predator.reInit();
		return predator;
	}
	public Predator moveDown(Predator predator)
	{
		//this.y++;
		predator.delete();
		predator.setY(this.y++);
		_energy = predator.getEnergy()-1;
		predator.setEnergy(_energy);
		predator.reInit();
		return predator;
	}
	public Predator moveRight(Predator predator)
	{
		//this.x++;
		predator.delete();
		predator.setX(this.x++);
		_energy = predator.getEnergy()-1;
		//predator = new Predator(x,y,id,show);
		predator.setEnergy(_energy);
		predator.reInit();
		return predator;
	}
	public Predator moveLeft(Predator predator)
	{
		//this.x--;
		predator.delete();
		predator.setX(this.x--);
		_energy = predator.getEnergy()-1;
		//predator = new Predator(x,y,id,show);
		predator.setEnergy(_energy);
		predator.reInit();
		return predator;
	}
	public Predator understand(Predator predator,HashMap map,Herbivore herb)
    {
        if (predator.getBefore()=='H')
        {
			System.out.println(predator.getBefore());
            System.out.println("YOU WIN P");
			predator.performEating(predator,herb);
        }
		for (int i=0;i<map.size()-1;i++)
		{
			try{
			if ((char)map.get(i)=='H')
			{
				if (i==0)
                    return predator.moveUp(predator);
                if (i==1)
                    return predator.moveRight(predator);
                if (i==2)
                    return predator.moveDown(predator);
                if (i==3)
                    return predator.moveLeft(predator);
			}
			else
			{
				int z = r.nextInt(3);
				if (z==0&&y>0)
				{
					return predator.moveUp(predator);
				}
				if (z==1&&x<Env.field.length-1)
					return predator.moveRight(predator);
				if (z==2&&y<Env.field.length-1)
					return predator.moveDown(predator);
				if (z==3&&x>0)
					return predator.moveLeft(predator);
			}
			}
			catch(NullPointerException e)
			{
			}
		}
		/*int z = r.nextInt(3);
		System.out.println(z);
		try
		{
			if (z==0&&y>0)
			{
				return predator.moveUp(predator);
			}
			if (z==1&&x<Env.field.length-1)
				return predator.moveRight(predator);
			if (z==2&&y<Env.field.length-1)
				return predator.moveDown(predator);
			if (z==3&&x>0)
				return predator.moveLeft(predator);
		}
		catch(NullPointerException e)
		{

		}*/
        return predator;
    }
}

public abstract class Actor
{
	private int x,y;
	private char id,show,before;
	private char none = '-';
	final private int max = 100;
	private int energy = max;
	private int last_x = x;
	private int last_y = y;
	private boolean dead = false;
	public Actor(int x,int y,char id,char show)
	{
		this.x = x;
		this.y = y;
		this.id = id;
		this.show = show;
		before = Env.field[x][y];
		Env.field[x][y] = id;
		if (x!=Env.field.length-1)
			if (Env.field[x+1][y]==none)
				Env.field[x+1][y]=show;
		if (y!=Env.field.length-1)
			if (Env.field[x][y+1]==none)
				Env.field[x][y+1]=show;
		if (x!=0)
			if (Env.field[x-1][y]==none)
				Env.field[x-1][y]=show;
		if (y!=0)
			if (Env.field[x][y-1]==none)
				Env.field[x][y-1]=show;
	}
	public void reInit()
	{
		try
		{
			before = Env.field[x][y];
			Env.field[x][y]=id;
		}
		catch (java.lang.ArrayIndexOutOfBoundsException e)
		{

		}
	}
	public int getX()
	{
		return this.x;
	}
	public int getY()
	{
		return this.y;
	}
	public void delete()
	{
		try
		{
		Env.field[x][y] = before;
		System.out.println("before "+before);
		}
		catch (java.lang.ArrayIndexOutOfBoundsException e)
		{

		}
	}
	public char getBefore()
	{
		return before;
	}
	public int getEnergy()
	{
		return energy;
	}
	public boolean checkEnergy()
	{
		if (this.energy==0)
			return true;
		else return false;
	}
	public Actor KMP()
	{
		return null;
	}
	public void setEnergy(int newEnergy)
	{
		energy = newEnergy;
		if (energy==0)
		{
			System.out.println("You are dead");
			this.id = none;
		}
	}
	public char getID()
	{
		return this.id;
	}
	public void setID(char newID)
	{
		this.id = newID;
	}
	public void setX(int x)
	{
		last_x = x;
		this.x = x;
	}
	public void setY(int y)
	{
		last_y=y;
		this.y = y;
	}
	public void dead()
	{
		System.out.println("it's dead");
		Env.field[x][y]=none;
		this.id = none;
		this.y = 1;
		this.x = 1;
		//this.energy = 0;
		before = none;
		dead = true;
	}
	public boolean isDead()
	{
		return dead;
	}
}

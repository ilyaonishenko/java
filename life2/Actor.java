public class Actor
{
	private int x,y,energy;
	private char id,before;
	private boolean dead;
	final static char none = '-';
	final static int max = 100;
	public Actor(char id,int x,int y)
	{
		this.x = x;
		this.y = y;
		this.id = id;
		this.energy = max;
		refresh();
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public int getX()
	{
		return x;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public int getY()
	{
		return y;
	}
	public int getEnergy()
	{
		return this.energy;
	}
	public void setEnetgy(int energy)
	{
		this.energy = energy;
	}
	public void addEnergy(int energy)
	{
		this.energy +=energy;
	}
	public char getBefore()
	{
		return before;
	}
	public void setBefore(char before){
		this.before = before;
	}
	public void setID(char id)
	{
		this.id = id;
	}
	public char getID()
	{
		return id;
	}
	public boolean isDead()
	{
		return dead;
	}
	public void death()
	{
		id = none;
		this.x=0;
		this.y=0;
		this.dead = true;
		this.energy = 0;
	}
	public void check()
	{
		if (this.energy<=0)
			death();
	}
	public boolean readyfor(){
		if (this.energy>max)
			return true;
		else return false;
	}
	public void refresh()
	{
		this.before = Env.field[x][y];
		Env.field[x][y]=id;
	}
	public void clear()
	{
		if (before!='P'){
			before = none;
		}
		Env.field[x][y] = before;
	}
	public void info()
	{
		System.out.println("------------------------");
		System.out.println("id: "+this.id);
		System.out.println("x: "+this.x);
		System.out.println("y: "+this.y);
		System.out.println("energy: "+this.energy);
		System.out.println("before: "+this.before);
		System.out.println("------------------------");
	}
}

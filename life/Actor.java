public abstract class Actor
{
	private int x,y;
	private char id,show,before;
	private char none = '-';
	private int energy = 100;
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
		Env.field[x][y] = before;
	}
	public char getBefore()
	{
		return before;
	}
	public int getEnergy()
	{
		return energy;
	}
}

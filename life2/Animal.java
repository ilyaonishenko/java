import java.util.Random();
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
		info();
	}
	public void moveDown()
	{
		clear();
		setY(getY()+1);
		setEnetgy(getEnergy()-1);
		refresh();
		info();
	}
	public void moveLeft()
	{
		clear();
		setX(getX()-1);
		setEnetgy(getEnergy()-1);
		refresh();
		info();
	}
	public void moveRight()
	{
		clear();
		setX(getX()+1);
		setEnetgy(getEnergy()-1);
		refresh();
		info();
	}
	public char[] sight()
	{
		/*
		0 for up
		1 for right
		2 for down
		3 for lefts
		*/
		char[] locs = new char[4];
		locs[0] = Env.field[getX()][getY()-1];
		locs[1] = Env.field[getX()+1][getY()];
		locs[2] = Env.field[getX()][getY()+1];
		locs[3] = Env.field[getX()-1][getY()];
		return locs;
	}
	public void thinking(char lookId)
	{
		Random r = new Random();
		char[] locs = sight();
		for (int i=0;i<locs.length;i++)
		{
			try {
				if (locs[i]==lookId)
				{
					if (i==0){
						moveUp();
					}
					else if (i==1){
						moveRight();
					}
					else if (i==2){
						moveDown();
					}
					else if (i==3){
						moveLeft();
					}
					else {
						outer:
						int z = r.nextInt(3);
						if(z==0&&getY()-1<0){
							throw new moveException();
						}
						else if (z==0)
					}
				}
			}catch(moveException ex)
			{

			}
		}
	}
}

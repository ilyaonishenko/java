import java.util.Random;
public class Animal extends Actor{
	int z,lastZ=-1,oppositeZ=-1;
	Random r = new Random();
	public Animal (char id,int x,int y)
	{
		super(id,x,y);
	}
	public void moveUp()
	{
		clear();
		setY(getY()-1);
		setEnetgy(getEnergy()-1);
		refresh();
		//info();
	}
	public void moveDown()
	{
		clear();
		setY(getY()+1);
		setEnetgy(getEnergy()-1);
		refresh();
	//	info();
	}
	public void moveLeft()
	{
		clear();
		setX(getX()-1);
		setEnetgy(getEnergy()-1);
		refresh();
	//	info();
	}
	public void moveRight()
	{
		clear();
		setX(getX()+1);
		setEnetgy(getEnergy()-1);
		refresh();
	//	info();
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
		try{
		locs[0] = Env.field[getX()][getY()-1];
	}catch (ArrayIndexOutOfBoundsException e){
		locs[0] = 'n';
	}
	try{
		locs[1] = Env.field[getX()+1][getY()];
	}catch(ArrayIndexOutOfBoundsException e)
	{
		locs[1]= 'n';
	}
	try{
		locs[2] = Env.field[getX()][getY()+1];
	}catch(ArrayIndexOutOfBoundsException e){
		locs[2] = 'n';
	}
	try{
		locs[3] = Env.field[getX()-1][getY()];
	}catch(ArrayIndexOutOfBoundsException e){
		locs[3] = 'n';
	}
		return locs;
	}
	public void randomMove()
	{
		z = r.nextInt(4);
		switch(z){
			case 0:{
				if (z==lastZ||z==oppositeZ){
					randomMove();
					break;
				}
				else {
					if (getY()-1<0){
						randomMove();
						break;
					} else {
						moveUp();
						lastZ = z;
						oppositeZ = 2;
					}
				}
				break;
			}
			case 1:{
				if (z==lastZ||z==oppositeZ){
					randomMove();
					break;
				}
				else{
					if (getX()+1>Env.getSize()-1){
						randomMove();
						break;
					} else {
						moveRight();
						lastZ = z;
						oppositeZ = 3;
					}
				}
				break;
			}
			case 2:{
				if (z==lastZ||z==oppositeZ){
					randomMove();
					break;
				}
				else{
					if(getY()+1>Env.getSize()-1){
						randomMove();
						break;
					} else {
						moveDown();
						lastZ = z;
						oppositeZ = 0;
					}
				}
				break;
			}
			case 3:{
				if (z==lastZ||z==oppositeZ){
					randomMove();
					break;
				}
				else{
					if(getX()-1<0){
						randomMove();
						break;
					} else {
						moveLeft();
						lastZ = z;
						oppositeZ = 1;
					}
				}
				break;
			}
		}
	}
}

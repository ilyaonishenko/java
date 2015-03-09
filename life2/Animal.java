import java.util.Random;
public class Animal extends Actor
{
	Random r = new Random();
	EatBehavior eatBehavior;
	int z,lastZ=-1,oppositeZ=-1;;
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
	public void thinking(char lookId)
	{
		boolean done = false;
		if (getBefore()==lookId){
			System.out.println("i found!");
			performEating(lookId);
			done = true;
		}
		char[] locs = sight();
		boolean check = false;
		for (int i=0;i<locs.length;i++)
		{
			if (locs[i]!='n'){
				if (locs[i]==lookId)
				{
					if (i==0){
						moveUp();
						check = true;
					}
					else if (i==1){
						moveRight();
						check = true;
					}
					else if (i==2){
						moveDown();
						check = true;
					}
					else if (i==3){
						moveLeft();
						check = true;
					}
				}
			}
		}
		if (getBefore()==lookId&&done==false){
			System.out.println("i found!");
			performEating(lookId);
		}
		if (getBefore()=='P'&&lookId!='P'){
			System.out.println("Flower");
			setBefore('-');
			setID('-');
			refresh();
		}
		if (check == false){
			randomMove();
		}
	}
	public void born(char lookId){
		if (lookId=='P'){
			if (getEnergy()>100){
				Herbivore herb = new Herbivore('h',getX(),getY());
				//Generator.getLocation(herb);
				Main.herbivoresList.add(herb);
				addEnergy(-100);
			}
		}
		if (lookId=='h'){
			if(getEnergy()>100){
				Predator pred = new Predator('X',getX(),getY());
				//Generator.getLocation(pred);
				Main.predatorsList.add(pred);
				addEnergy(-100);
			}
		}
	}
/*	public void thinking(char lookId)
	{
		char[] locs = sight();
		boolean check = false;
		for (int i=0;i<locs.length;i++)
		{
			if (locs[i]!='n'){
				if (locs[i]==lookId)
				{
					if (i==0){
						moveUp();
						check = true;
					}
					else if (i==1){
						moveRight();
						check = true;
					}
					else if (i==2){
						moveDown();
						check = true;
					}
					else if (i==3){
						moveLeft();
						check = true;
					}
				}
			}
		}
		if (getID()==lookId){
			performEating();
		}
		if (check == false){
			randomMove();
		}
	}*/
	public void performEating(char lookId)
	{
		//eatBehavior.Eat();
		if (lookId=='h'){
			for (Herbivore h:Main.herbivoresList){
				if (h.getX()==getX()&&h.getY()==getY()){
					addEnergy(h.getEnergy());
					refresh();
					Main.herbivoresList.remove(h);
					setID('X');
					setBefore('-');
				}
			}
		}
		else if (lookId=='P'){
			for (Plant p:Main.plantsList){
				if (p.getX()==getX()&&p.getY()==getY()){
					addEnergy(p.getEnergy());
					refresh();
					Main.plantsList.remove(p);
					setID('h');
					setBefore('-');
				}
			}
		}
	/*	addEnergy(animal.getEnergy());
		animal.setID('-');
		refresh();
		animal.check();
		setID('X');
		setBefore('-');*/
	}
	/*public void performEating(){
		/*addEnergy(plant.getEnergy());
		//plant.set();
		refresh();
		setID('h');
		setBefore('-');*/
	//}
}

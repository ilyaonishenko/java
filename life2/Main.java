import java.util.LinkedList;
import java.util.List;
import java.awt.*;
import javax.swing.*;
import java.lang.Thread;
public class Main{
	private static final char pr = 'X';
	private static final char p = 'P';
	private static final char h = 'h';
	private static final char none = '-';
	public static List<Predator> predatorsList = new LinkedList<Predator>();
	public static List<Herbivore> herbivoresList = new LinkedList<Herbivore>();
	public static List<Plant> plantsList = new LinkedList<Plant>();
	public static char[][] toPrint;
	public static void main(String[] args)
	{
		int N=10;
		Thread thread = new Thread();
		toPrint = new char[10][10];
		int width = 110*N, height = 90*N;
		Env.getEnv(N);
		Predator predator = new Predator(none,0,0);
		Predator predator2 = new Predator(none,0,0);
		predatorsList.add(predator);
		predatorsList.add(predator2);
		predator = null;
		predator2 = null;
		Plant plant = new Plant(none,0,0);
		Plant plant2 = new Plant(none,0,0);
		plantsList.add(plant);
		plantsList.add(plant2);
		Herbivore herbivore = new Herbivore(none,0,0);
		Herbivore herbivore2 = new Herbivore(none,0,0);
		herbivoresList.add(herbivore);
		herbivoresList.add(herbivore2);
		herbivore = null;
		herbivore2 = null;
		//Generator.getLocation(predator);
		for (Predator p:predatorsList)
			Generator.getLocation(p);
		for(Herbivore h:herbivoresList)
			Generator.getLocation(h);
		for (Plant p:plantsList)
			Generator.getLocation(p);
		/*myFrame mainFrame = new myFrame("Hello SWING!!!",toPrint);
		mainFrame.setSize(width, height);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);*/
		//mainFrame.changeBackground(toPrint);
		Env.Print();
		for (int i=0;i<10;i++)
		{
			System.out.println(i);
			for (Herbivore h:herbivoresList){
				if (h.isDead()==false){
					h.check();
					if (h.readyfor()==true){
						herbivore = new Herbivore('h',h.getX(),h.getY());
						h.addEnergy(-100);
					}
				}
			}
			if (herbivore!=null){
				herbivoresList.add(herbivore);
				herbivore=null;
			}
			for (Herbivore h:herbivoresList){
				if (h.isDead()==false){
					h.sight();
				}
			}
			for (Herbivore he:herbivoresList){
				if (he.isDead()==false){
					he.thinking(p);
				}
			}
			//mainFrame.changeBackground(toPrint);
			/*try{
				thread.sleep(500);
			} catch(Exception e){

			}*/
			for(Predator p:predatorsList){
				if (p.isDead()==false){
					p.check();
					if (p.getID()!=pr){
						p.setID(pr);
					}
					if(p.readyfor()==true){
						predator = new Predator(pr,p.getX(),p.getY());
						p.addEnergy(-100);
					}
				}
			}
			if (predator!=null){
				predatorsList.add(predator);
				predator = null;
			}
			for(Predator p:predatorsList){
				if (p.isDead()==false){
					p.sight();
				}
			}
			for(Predator pre:predatorsList){
				if (pre.isDead()==false){
					pre.thinking(h);
				}
			}
			for (Herbivore h:herbivoresList){
				if (h.isDead()==false){
					h.info();
				}
			}
			for(Predator p:predatorsList){
				if (p.isDead()==false){
					p.info();
				}
			}
			bigCheck();
			//mainFrame.changeBackground(toPrint);
		/*	try{
				thread.sleep(500);
			} catch(Exception e){

			}*/
			Env.Print();
		}
	}
	public static void bigCheck(){
		boolean check=false;
		for (int i=0;i<Env.field.length;i++){
			for(int j=0;j<Env.field.length;j++){
				check = false;
				for(Herbivore h:herbivoresList){
					if (Env.field[j][i]!=none&&h.getX()!=j&&h.getY()!=i&&check==false){
						check = false;
					}
					else check = true;
				}
				for(Predator p:predatorsList){
					if(Env.field[j][i]!=none&&p.getX()!=j&&p.getY()!=i&&check==false){
						check = false;
					} else check = true;
				}
				for(Plant p:plantsList){
					if(Env.field[j][i]!=none&&p.getX()!=j&&p.getY()!=i&&check==false){
						check = false;
					} else check = true;
				}
				if (check==false){
					Env.field[j][i]=none;
				}
			}
		}
	}
}

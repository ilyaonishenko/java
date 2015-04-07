package com.company;
import javax.swing.*;
import java.util.LinkedList;
import java.util.List;
public class Main{
	private static final char pr = 'X';
	private static final char p = 'P';
	private static final char h = 'H';
	private static final char none = '-';
	public static List<Predator> predatorsList = new LinkedList<Predator>();
	public static List<Herbivore> herbivoresList = new LinkedList<Herbivore>();
	public static List<Plant> plantsList = new LinkedList<Plant>();
    public static List<Predator> secondpredatorsList = new LinkedList<Predator>();
    public static List<Herbivore> secondherbivoresList = new LinkedList<Herbivore>();
    public static List<Plant> secondplantsList = new LinkedList<Plant>();
    private static char[][] array = new char[10][10];
	public static void main(String[] args){
		int N=10;
		Env.getEnv(N);
        Thread thread = new Thread();
		//'H',0,0
		Herbivore herb = new Herbivore('H',0,0);
		Predator pred = new Predator('X',0,0);
		Plant plant = new Plant('P',0,0);
		Herbivore herb1 = new Herbivore('H',0,0);
		Predator pred1 = new Predator('X',0,0);
		Plant plant1 = new Plant('P',0,0);
        Predator predatorNew = null;
        Herbivore herbivoreNew = null;
        Plant plantNew = null;
		predatorsList.add(pred);
		predatorsList.add(pred1);
		herbivoresList.add(herb);
		herbivoresList.add(herb1);
		plantsList.add(plant);
		plantsList.add(plant1);
		herb = null;
		herb1 = null;
		pred = null;
		pred1 = null;
		plant = null;
		plant1 = null;
        for(Plant p:plantsList)
            Generator.getLocation(p);
        for(Herbivore h:herbivoresList)
            Generator.getLocation(h);
        for(Predator p:predatorsList)
            Generator.getLocation(p);
        bigCheck();
        for(Herbivore h:herbivoresList) {
            h.info();
        }
        for(Predator p:predatorsList) {
            p.info();
        }
        for(Plant p:plantsList)
            p.info();
        Conflict.checkConflicts(predatorsList,herbivoresList,plantsList);
        secondCheck();
        deleteCheck();
        MyFrame myFrame = new MyFrame("Swing tut");
        int width = 110*N, height = 90*N;
        myFrame.setSize(width, height);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
        myFrame.setResizable(false);
        Env.Print();
        for(int i=0;i<10;i++){
            for(Herbivore h:herbivoresList){
                if(!h.isDead()) {
                    h.thinking('P');
                    h.lifeCheck();
                    if (h.getEnergy() > h.max) {
                        herbivoreNew = new Herbivore('H', h.getX(), h.getY());
                        h.setEnetgy(h.getEnergy() - h.max);
                    }
                }
                h.info();
            }
            checkForBornHerbviore(herbivoreNew);
            if(herbivoreNew!=null)
                herbivoreNew = null;
            //Conflict.refreshFromDeads(predatorsList,herbivoresList,plantsList);
            bigCheck();
            secondCheck();
            deleteCheck();
            myFrame.changePictures();
            try{
                thread.sleep(500);
            }catch (Exception e){
            }
            for(Predator p:predatorsList){
                if(!p.isDead()) {
                    p.thinking('H');
                    p.lifeCheck();
                    if (p.getEnergy() > p.max) {
                        predatorNew = new Predator('X', p.getX(), p.getY());
                        p.setEnetgy(p.getEnergy() - p.max);
                    }
                }
                p.info();
            }
            checkForBornPredator(predatorNew);
            if(predatorNew!=null)
                predatorNew = null;
            //Conflict.refreshFromDeads(predatorsList,herbivoresList,plantsList);
            bigCheck();
            secondCheck();
            deleteCheck();
            myFrame.changePictures();
            try{
                thread.sleep(500);
            }catch (Exception e){
            }
            for(Plant p:plantsList)
                p.info();
            System.out.println("_________________________");
            Env.Print();
        }
		/*for(Herbivore h:herbivoresList)
			h.moveRight();
		System.out.println("______________");
		Env.Print();
		Conflict.checkConflicts(predatorsList,herbivoresList,plantsList);
		for(Predator p:predatorsList)
			p.moveRight();
		Conflict.checkConflicts(predatorsList,herbivoresList,plantsList);
		System.out.println("______________");
		Env.Print();
		for(Predator p:predatorsList){
            p.moveRight();
            p.lifeCheck();
            if (p.getEnergy()>p.max){
                predatorNew = new Predator('X',p.getX(),p.getY());
                p.setEnetgy(p.getEnergy()-p.max);
            }
        }
        checkForBornPredator(predatorNew);
		Conflict.checkConflicts(predatorsList,herbivoresList,plantsList);
		System.out.println("______________");
		Env.Print();
		for(Predator p:predatorsList)
			p.moveRight();
		Conflict.checkConflicts(predatorsList,herbivoresList,plantsList);	
		System.out.println("______________");
		Env.Print();*/
		//Generator.getLocation(herb);
		//Generator.getLocation(pred);
		//Generator.getLocation(plant);
	}
    public static void checkForBornPredator(Predator predatorNew){
        if(predatorNew!=null){
            predatorNew.setBefore(none);
            Env.field[predatorNew.getX()][predatorNew.getY()]='X';
            predatorsList.add(predatorNew);
            predatorNew = null;
        }
    }
    public static void checkForBornHerbviore(Herbivore herbivoreNew){
        if(herbivoreNew!=null){
            herbivoreNew.setBefore(none);
            Env.field[herbivoreNew.getX()][herbivoreNew.getY()]='H';
            herbivoresList.add(herbivoreNew);
            herbivoreNew = null;
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
    public static void secondCheck(){
        boolean check=false;
        for (int i=0;i<Env.field.length;i++){
            for(int j=0;j<Env.field.length;j++){
                check = false;
                if(Env.field[j][i]=='H') {
                    for (Herbivore h : herbivoresList) {
                        if (h.getX() == j && h.getY() == i)
                            check = true;
                    }
                    if (!check) {
                        Env.field[j][i] = none;
                    }
                    check = false;
                }
                else if (Env.field[j][i]=='P'){
                    for(Plant p:plantsList){
                        if(p.getX()==j&&p.getY()==i)
                            check = true;
                    }
                    if(!check)
                        Env.field[j][i]=none;
                    check = false;
                }
                else if (Env.field[j][i]=='X'){
                    for(Predator p:predatorsList){
                        if(p.getX()==j&&p.getY()==i)
                            check = true;
                    }
                    if(!check)
                        Env.field[j][i] = none;
                    check = false;
                }
            }
        }
    }
    public static void deleteCheck(){
        boolean check1=false;
        boolean check2 = false;
        boolean check3 = false;
        for(int i=0;i<predatorsList.size();i++){
            if(predatorsList.get(i).getID()=='-'){
                check1 = true;
                break;
            }
        }
        for(int i=0;i<herbivoresList.size();i++){
            if(herbivoresList.get(i).getID()=='-'){
                check2 = true;
                break;
            }
        }
        for(int i=0;i<plantsList.size();i++){
            if(plantsList.get(i).getID()=='-'){
                check3=  true;
                break;
            }
        }
        if(check1){
            for(Predator p:predatorsList){
                if(p.getID()!=none)
                    secondpredatorsList.add(p);
            }
            predatorsList.clear();
            for(Predator p:secondpredatorsList)
                predatorsList.add(p);
        }
        if(check2){
            for(Herbivore h:herbivoresList){
                if(h.getID()!=none)
                    secondherbivoresList.add(h);
            }
            herbivoresList.clear();
            for(Herbivore h:secondherbivoresList)
                herbivoresList.add(h);
        }
        if(check3){
            for(Plant p:plantsList){
                if(p.getID()!=none)
                    secondplantsList.add(p);
            }
            plantsList.clear();
            for(Plant p:secondplantsList)
                plantsList.add(p);
        }
    }
}

package com.company;
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
	public static void main(String[] args){
		int N=10;
		Env.getEnv(N);
		//'H',0,0
		Herbivore herb = new Herbivore('H',5,8);
		Predator pred = new Predator('X',4,8);
        Herbivore herb2 = new Herbivore('H',2,8);
		Plant plant = new Plant('P',5,5);
		Herbivore herb1 = new Herbivore('H',2,2);
		Predator pred1 = new Predator('X',4,4);
		Plant plant1 = new Plant('P',1,1);
		predatorsList.add(pred);
		predatorsList.add(pred1);
		herbivoresList.add(herb);
		herbivoresList.add(herb1);
        herbivoresList.add(herb2);
		plantsList.add(plant);
		plantsList.add(plant1);
		herb = null;
		herb1 = null;
		pred = null;
		pred1 = null;
		plant = null;
		plant1 = null;
		Env.Print();
		for(Herbivore h:herbivoresList)
			h.moveRight();
		System.out.println("______________");
		Env.Print();
		Conflict.checkConflicts(predatorsList,herbivoresList,plantsList);
		for(Predator p:predatorsList)
			p.moveRight();
		Conflict.checkConflicts(predatorsList,herbivoresList,plantsList);
		System.out.println("______________");
		Env.Print();
		for(Predator p:predatorsList)
			p.moveRight();
		Conflict.checkConflicts(predatorsList,herbivoresList,plantsList);
		System.out.println("______________");
		Env.Print();
		for(Predator p:predatorsList)
			p.moveRight();
		Conflict.checkConflicts(predatorsList,herbivoresList,plantsList);	
		System.out.println("______________");
		Env.Print();
		//Generator.getLocation(herb);
		//Generator.getLocation(pred);
		//Generator.getLocation(plant);
		// первая часть путь 42, вторая 48
	}
}

package com.company;
import java.util.LinkedList;
import java.util.List;
public class Conflict{
	private static Conflict conf;
	static int[] arrayXHerbivore;
	static int[] arrayXPredator;
	static int[] arrayXPlant;
	static int[] arrayYHerbivore;
	static int[] arrayYPredator;
	static int[] arrayYPlant;
    static List<Predator> secondPredatorList = new LinkedList<Predator>();
    static List<Herbivore> secondHerbivoreList = new LinkedList<Herbivore>();
    static List<Plant> secondPlantList = new LinkedList<Plant>();
	private Conflict(List<Predator> predatorsList,List<Herbivore> herbivoresList,List<Plant> plantsList){

	}
	public static Conflict getConflict(List<Predator> predatorsList,List<Herbivore> herbivoresList,List<Plant> plantsList){
		if (conf==null)
			conf= new Conflict(predatorsList,herbivoresList,plantsList);
		return conf;
	}
	public static void checkConflicts(List<Predator> predatorsList,List<Herbivore> herbivoresList,List<Plant> plantsList){
		arrayXPlant = new int[plantsList.size()];
		arrayYPlant = new int[plantsList.size()];
		arrayXPredator = new int[predatorsList.size()];
		arrayYPredator = new int[predatorsList.size()];
		arrayXHerbivore = new int[herbivoresList.size()];
		arrayYHerbivore = new int[herbivoresList.size()];
		for(int i=0;i<predatorsList.size();i++){
			arrayXPredator[i] = predatorsList.get(i).getX();
			arrayYPredator[i] = predatorsList.get(i).getY();
		}
		for(int i=0;i<herbivoresList.size();i++){
			arrayXHerbivore[i] = herbivoresList.get(i).getX();
			arrayYHerbivore[i] = herbivoresList.get(i).getY();
		}
		for(int i=0;i<plantsList.size();i++){
			arrayXPlant[i] = plantsList.get(i).getX();
			arrayYPlant[i] = plantsList.get(i).getY();
		}
		if(compareArrays(arrayXPlant,arrayXHerbivore)&&compareArrays(arrayYPlant,arrayYHerbivore)){
			solveConflict1(herbivoresList,plantsList);
		}
		if(compareArrays(arrayXPredator,arrayXHerbivore)&&compareArrays(arrayYPredator,arrayYHerbivore)){
			//System.out.println("asdas");
			solveConflict2(predatorsList,herbivoresList);
		}
	}
	private static void solveConflict1(List<Herbivore> herbivoresList,List<Plant> plantsList){
		for(int i=0;i<herbivoresList.size();i++){
			for(int j=0;j<plantsList.size();j++){
				if (herbivoresList.get(i).getX()==plantsList.get(j).getX()&&herbivoresList.get(i).getY()==plantsList.get(j).getY()){
					if(!plantsList.get(j).isDead()){
						plantsList.get(j).death();
					}
				}
			}
		}
	}
	private static void solveConflict2(List<Predator> predatorsList,List<Herbivore> herbivoresList){
		for(int i=0;i<predatorsList.size();i++){
			for(int j=0;j<herbivoresList.size();j++){
				if(predatorsList.get(i).getX()==herbivoresList.get(j).getX()&&predatorsList.get(i).getY()==herbivoresList.get(j).getY()){
					if(!herbivoresList.get(j).isDead()){
						herbivoresList.get(j).death();
					}
				}
			}
		}
	}
    public static boolean fastCheck2(List<Herbivore> herbivoreList,int x,int y){
        for (int i=0;i<herbivoreList.size();i++){
            if (herbivoreList.get(i).getX()==x&&herbivoreList.get(i).getY()==y){
                if(!herbivoreList.get(i).isDead()){
                    herbivoreList.get(i).death();
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean fastCheck3(List<Predator> predatorList,int x,int y){
        for(int i=0;i<predatorList.size();i++){
            if(predatorList.get(i).getX()==x&&predatorList.get(i).getY()==y){
                if(!predatorList.get(i).isDead()){
                    predatorList.get(i).setEnetgy(predatorList.get(i).getEnergy()+Actor.max);
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean fastCheck1(List<Plant> plantList,int x,int y){
        for(int i=0;i<plantList.size();i++){
            if(plantList.get(i).getX()==x&&plantList.get(i).getY()==y){
                if(!plantList.get(i).isDead()) {
                    plantList.get(i).death();
                    return true;
                }
            }
        }
        return false;
    }
	private static boolean compareArrays(int[] array1,int[] array2) {
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}

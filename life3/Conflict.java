import java.util.LinkedList;
import java.util.List;
public class Conflict{
	private static Conflict conf;
	int[] array_X;
	int[] array_Y;
	private Conflict(List predatorsList,List herbivoresList,List plantsList){

	}
	public static Conflict getConflict(List predatorsList,List herbivoresList,List plantsList){
		if (conf==null)
			conf= new Conflict(predatorsList,herbivoresList,plantsList);
		return conf;
	}
	private void checkConflicts(List predatorsList,List herbivoresList,List plantsList){

	}
	private void solveConflict(){

	}
	private boolean equality(int[] array){
		//сравнение
		int N = array.lenght;
		for (int i=0;i<N;i++){
			int p =array[i];
			for(int j=i+1;j<N;j++){
				if (p==array[j])
					return true;
			}
		}
		return false;
	}
}

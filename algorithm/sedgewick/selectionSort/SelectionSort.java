public class SelectionSort{
	private static boolean less(int v,int w){
		return v<w;
	}
	private static void exch(int[] a,int i,int j){
		int t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	private static void show(int[] a){
		for(int c:a)
			System.out.println(c+" ");
		System.out.println();
	}
	public static boolean isSorted(int[] a){
		for (int i=0;i<a.length;i++){
			if (less(a[i],a[i-1]))
				return false;
			return true;
		}
		return false;
	}
	public static void selectionSort(int[] a){
		int N = a.length;
		for (int i=0;i<N;i++){
			int min = i;
			for(int j=i+1;j<N;j++)
				if(less(a[j],a[min]))
					min=j;
			exch(a,i,min);
		}
	}
	public static void main(String[] args){
		int[] array = new int[10];
		array[0] = 3;
		array[1] = 9;
		array[2] = 1;
		array[3] = 6;
		array[4] = 0;
		array[5] = 15;
		array[6] = 19;
		array[7] = 2;
		array[8] = 11;
		array[9] = 23;
		show(array);
		selectionSort(array);
		show(array);
	}
}

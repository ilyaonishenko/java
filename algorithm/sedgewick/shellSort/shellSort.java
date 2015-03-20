public class shellSort{
	private static boolean less(int v,int w){
		return v<w;
	}
	private static void exch(int[] a,int i,int j){
		int t = a[i];
		a[i]=a[j];
		a[j]=t;
	}
	private static void show(int[] a){
		for (int i:a)
			System.out.print(i+" ");
		System.out.println();
	}
	private static void shellSorting(int[] a){
		int N = a.length;
		int h=1;
		while(h<N/3)
			h = 3*h+1;
		while (h>=1){
			for (int i=h;i<N;i++){
				for (int j=i;j>=h&&less(a[j],a[j-h]);j-=h)
					exch(a,j,j-h);
			}
			h=h/3;
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
		shellSorting(array);
		show(array);
	}
}

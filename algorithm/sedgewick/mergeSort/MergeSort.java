import java.util.Random;
public class MergeSort{
	private static int[] array;
	public static void main(String[] args){
		int[] array = new int[8];
		Random r = new Random();
		for(int i=0;i<array.length;i++)
			array[i] = r.nextInt(10);
		sort(array);
		for(int i:array)
			System.out.print(i+" ");
	}
	public static void sort(int[] arr){
		array = new int[arr.length];
		sort(arr,0,arr.length-1);
	}
	private static void sort(int[] a,int lo,int hi){
		if (hi<=lo)
			return;
		int mid = lo+(hi-lo)/2;
		sort(a,lo,mid);
		sort(a,mid+1,hi);
		merge(a,lo,mid,hi);
	}
	public static void merge(int[] a,int lo,int mid,int hi){
		int i = lo;
		int j = mid+1;
		int[] aux = new int[a.length];
		for(int k=lo;k<=hi;k++)
			aux[k]=a[k];
		for(int k=lo;k<=hi;k++){
			if(i>mid)
				a[k]=aux[j++];
			else if (j>hi)
				a[k]=aux[i++];
			else if (less(aux[j],aux[i]))
				a[k]=aux[j++];
			else a[k]=aux[i++];
		}
	}
	public static boolean less(int v,int w){
		return v<w;
	}
}

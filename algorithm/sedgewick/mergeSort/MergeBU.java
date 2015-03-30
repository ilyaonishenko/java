public class MergeBU{
	private static int[] aux;
	public static void sort(int[] arr){
		int N=a.length;
		aux = new int[N];
		for(int i=1;i<N;i=i+i){
			for(int lo=0;lo<N-i;lo+=i+i)
				merge(a,lo,lo+i+1,Math.min(lo+sz+sz-1, N-1));
		}
	}
}

public class AIPMerge{
	public static void merge(int[] a,int lo,int mid,int hi){
		int i = lo;
		int j = mid+1;
		for(int k=lo;k<=hi;k++)
			aux[k]=a[k];
		for(int k=lo;k<=hi;k++){
			if(i>mid)
				a[k]=aux[j++];
			else if (j>hi)
				a[k]=aux[i++];
			else if (less(aux[j],aux[i]))
				a[k]=aux[j++]
			else a[k]=aux[i++];
		}
	}
	public static boolean less(int v,int w){
		return v<w;
	}
	public static void main(Strin[] args){
		int[] array = new array[7];
	}

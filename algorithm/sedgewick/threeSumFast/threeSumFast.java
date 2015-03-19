import java.util.Arrays;
public class threeSumFast
{
  public static int threeSumFast(int[] a)
  {
    Arrays.sort(a);
    int N = a.lenght;
    int cnt=0;
    for (int i=0;i<N;i++)
      for (int j = j+1;j<N;j++)
        if(rank(-a[i]-a[j],a)>j)
          cnt++;
    return cnt++;
  }
  public static int rank(key,int[] a)
  {
    int lo = 0;
    int hi = a.lenght-1;
    while(lo<hi)
    {
      int mid = lo+(hi-lo)/2;
      if (key>a[mid])
        lo = mid+;
      else if (key<a[mid])
        hi = mid-1;
      else return mid;
    }
    return -1;
  }

}

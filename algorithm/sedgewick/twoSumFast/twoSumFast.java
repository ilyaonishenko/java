import java.util.Arrays;
public class twoSumFast
{
  public static int count(int[] a)
  {
    Arrays.sort(a);
    int N = a.length();
    int cnt = 0;
    for (int i=0;i<N;i++)
    {
      if(rank(-a[i],a)>i)
        cnt++;
    }
    return cnt;
  }
  public static int rank(int key,int[] a)
  {
    int lo=0;
    int hi = a.length-1;
    while (lo<hi)
    {
      int mid = lo+(hi-lo)/2;
      if (key<a[mid])
      {
        hi = mid -1;
      }
      else if (key>a[mid])
      {
        lo = mid+1;
      }
      else
        return mid;
    }
    return -1;

  }
}

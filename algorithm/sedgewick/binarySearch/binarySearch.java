import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
public class binarySearch
{
  public static int rank(int key, int[] a)
  {
    int lo=0;
    int hi = a.length-1;
    while (lo<hi)
    {
      int mid = lo+(hi-lo)/2;
      if (key<a[mid])
      {
        hi = mid-1;
      }
      else if (key>a[mid])
      {
        lo = mid+1;
      }
      else
      {
        return mid;
      }
    }
    return -1;
  }
  public static int[] readFile(String name)
  {
    String result="";
    Scanner n = null;
    try
    {
      n = new Scanner(new File(name));
      while (n.hasNext())
      {
        result+=n.next()+" ";
      }
    } catch (IOException e)
    {
      e.printStackTrace();
    } finally
    {
      n.close();
    }
    int[] resultArr;
    ArrayList<String> arrayList = new ArrayList<String>();
    String[] stringResult = new String[(result.split(" ")).length];
    stringResult = result.split(" ");
    for (int i=0;i<stringResult.length;i++)
    {
      if (stringResult[i].equals(" "))
      {
        //nothing
      }
      else
      {
        arrayList.add(stringResult[i]);
      }
    }
    resultArr = new int[arrayList.size()];
    for (int i=0;i<arrayList.size();i++)
    {
      resultArr[i] = Integer.valueOf(arrayList.get(i));
    }

    return resultArr;
  }
  public static void main(String[] args)
  {
    String name = "file.txt";
    int[] result = readFile(name);
    Arrays.sort(result);
    int key = 5;
    int answer = rank(key,result);
    System.out.println(answer);
  }
}

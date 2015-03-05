import java.util.ArrayList;
public class parser
{
  public String[] parser(String text)
  {
    String[] sep = new String[]{"(",")","+","-","*","/"};
    String[] array =  text.split("[+\\s\\-\\*\\/\\(\\)]");
    ArrayList<String> list = new ArrayList<String>();
    for (int i=0;i<text.length();i++)
      for (int j=0;j<sep.length;j++)
        if(String.valueOf(text.charAt(i)).equals(sep[j]))
          list.add(sep[j]);
    sep = null;
    String[] arr = new String[list.size()];
    for (int i=0;i<list.size();i++)
      arr[i] = list.get(i);
    list = new ArrayList<String>();
    for (int i=0;i<array.length;i++)
      if (!array[i].equals(" ")&&array[i].length()!=0)
        list.add(array[i]);
    array = new String[list.size()];
    for (int i=0;i<list.size();i++)
      array[i]= list.get(i);
    list = null;
    ArrayList<String> list2 = new ArrayList<String>();
    int count =0;//for values;
    int count2 = 0;//for osp
    boolean checked = true;
    for (int i=0;i<text.length();i++)
    {
      if (count2!=arr.length){
      if (String.valueOf(text.charAt(i)).equals(arr[count2]))
      {
        list2.add(String.valueOf(text.charAt(i)));
        count2++;
        checked = true;
        continue;
      }
    }
      if (checked == true)
      {
        list2.add(array[count]);
        count++;
        checked = false;
      }
    }
    arr = null;
    array = new String[list2.size()];
    for (int i=0;i<list2.size();i++)
      array[i]=list2.get(i);
    return array;
  }
}

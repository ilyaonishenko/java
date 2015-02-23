public class checkForInts
{
  public boolean check(String text)
  {
    String after="";
    boolean check=false;
    for (int i=0;i<text.length();i++)
    {
      if (check==false)
      {
        if (text.charAt(i)=='.')
          check = true;
      }
      else if (check==true)
        after+=String.valueOf(text.charAt(i));
    }
    if (Double.parseDouble(after)==0)
      return true;
    else
      return false;
  }
}

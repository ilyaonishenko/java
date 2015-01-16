import java.util.ArrayList;
public interface parser
{
  public String firstStep(String text);
  public ArrayList<String> refreshList(ArrayList<String> list,Character ch);
  public ArrayList<String> priorityList(ArrayList<String> list);
  public String secondStep(String text);
  public String chooseStep(String text);
  public String twoBrackets(String text1,String text2,Character sign);
  public ArrayList<String> lookForI(String text);
  public String preOrder(String text);
  public String bracketsNearBrackets(String text);
  public String bracketsInBrackets(String text);
  public int lookForMin(int[] array);
  public int lookForMax(int[] array);
  public String badSign(String text);
  public ArrayList<String> firstNumber(ArrayList<String> arrayList);
}

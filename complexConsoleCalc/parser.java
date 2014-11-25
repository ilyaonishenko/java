import java.util.ArrayList;
public interface parser
{
  public String firstStep(String text);
  public ArrayList<String> refreshList(ArrayList<String> list,Character ch);
  public ArrayList<String> priorityList(ArrayList<String> list);
  public String secondStep(String text);
  public String chooseStep(String text);
}

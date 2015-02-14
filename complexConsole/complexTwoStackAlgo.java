import java.util.TreeMap;
public class complexTwoStackAlgo
{
  public double complexEvaluation(String text)
  {
    text = "("+text+")";
    TreeMap<String,Integer> precedence = new TreeMap<String,Integer>();
    precedence.put(")",0);
    precedence.put("(",0);
    precedence.put("+",1);
    precedence.put("-",1);
    precedence.put("*",2);
    precedence.put("/",2);
    Stack<String> values = new Stack<String>();
    Stack<String> ops = new Stack<String>();
    Stack<String> cValues = new Stack<String>();
    Stack<String> cOps = new Stack<String>();
     /*
      план
      если последние 2 значения в стеке действительные (мнимые), то работает с ними
      если нет, то они сохраняются в спец. стеке выражением. И знак вместе с ними
      Например 5i +5+ 10i
      5i +10i +5 // решается
      push 5i
      push 5
      push
    */
  }
}

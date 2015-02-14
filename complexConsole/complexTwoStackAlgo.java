import java.util.TreeMap;
public class complexTwoStackAlgo
{
  public Complex complexEvaluation(String text)
  {
    text = "("+text+")";
    TreeMap<String,Integer> precedence = new TreeMap<String,Integer>();
    precedence.put(")",0);
    precedence.put("(",0);
    precedence.put("+",1);
    precedence.put("-",1);
    precedence.put("*",2);
    precedence.put("/",2);
    Stack<Complex> values = new Stack<Complex>();
    Stack<Complex> ops = new Stack<Complex>();
     /*
      план
      если последние 2 значения в стеке действительные (мнимые), то работает с ними
      если нет, то они сохраняются в спец. стеке выражением. И знак вместе с ними
      Например 5i +5+ 10i
      5i +10i +5 // решается
      push 5i
      push 5
      push
      //Всё написано кроме парсинга из текста в класс комплекс
    */
    int len = text.length();
    for (int i=0;i<len;i++)
    {
      String sign = //sign
      if (!precedence.containsKey(sign))
      {
        //добавление в список значений
      }
      while (true)
      {
        if (ops.isEmpty()||sign.equals("(")||(precedence.get(sign)>precedence.get(ops.peek())))
        {
          ops.push(sign);
          break;
        }
        String op = ops.pop();
        if (op.equals("("))
        {
          assert sign.equals(")");
          break;
        }
        else
        {
          Complex val2 = vals.pop();
          Complex val1 = vals.pop();
          vals.push(eval(op,val1,val2));
        }
      }
    }
    while (!ops.isEmpty())
    {
      String op = ops.pop();
      Complex val2 = vals.pop();
      Complex val1 = vals.pop();
      vals.push(eval(op, val1, val2));
    }
    double answ = vals.pop();
    return answ;
  }
  public static double eval(String op, Complex val1, Complex val2) {
        if (op.equals("+")) return val1.plus(val2);//plus
        if (op.equals("-")) return val1.minus(val2);//minus
        if (op.equals("/")) return val1.divides(val2);//division
        if (op.equals("*")) return val1.times(val2);//mult
        throw new RuntimeException("Invalid operator");
    }
}

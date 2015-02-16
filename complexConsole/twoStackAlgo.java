import java.util.TreeMap;
public class twoStackAlgo
{
  protected double evaluation(String text)
  {
    text = "("+text+")";
    parser p = new parser();
    String[] array = p.parser(text);
    TreeMap<String,Integer> precedence = new TreeMap<String,Integer>();
    precedence.put(")",0);
    precedence.put("(",0);
    precedence.put("+",1);
    precedence.put("-",1);
    precedence.put("*",2);
    precedence.put("/",2);
    Stack<String> ops = new Stack<String>();
    Stack<Double> vals = new Stack<Double>();
    int len = array.length;
    for (int i=0;i<len;i++)
    {
      String sign = array[i];
      if (!precedence.containsKey(sign))
      {
        vals.push(Double.parseDouble(sign));
        //настроить для считывания double ---  сделано
        continue;
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
          double val2 = vals.pop();
          double val1 = vals.pop();
          vals.push(eval(op,val1,val2));
        }
      }
    }
    while (!ops.isEmpty())
    {
      String op = ops.pop();
      double val2 = vals.pop();
      double val1 = vals.pop();
      vals.push(eval(op, val1, val2));
    }
    double answ = vals.pop();
    return answ;
  }
  public static double eval(String op, double val1, double val2) {
        if (op.equals("+")) return val1 + val2;
        if (op.equals("-")) return val1 - val2;
        if (op.equals("/")) return val1 / val2;
        if (op.equals("*")) return val1 * val2;
        throw new RuntimeException("Invalid operator");
    }
}

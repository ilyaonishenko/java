import java.util.TreeMap;
public class complexTwoStackAlgo
{

  public static Complex complexEvaluation(String text)
  {
    Complex val = new Complex(0,0);
    Complex vall = new Complex(0,0);
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
    Stack<Complex> values = new Stack<Complex>();
    Stack<String> ops = new Stack<String>();
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
    int len = array.length;
    boolean check = false;
    for (int i=0;i<len;i++)
    {
      check = false;
      String sign = array[i];
      if (!precedence.containsKey(sign))
      {
        //string to complex
        for (int j=0;j<array[i].length();j++)
        {
          if (array[i].charAt(j)=='i')
          {
            check = true;
            break;
          }
        }
        String newSign = "";
        for (int j=0;j<sign.length();j++)
        {
          if (sign.charAt(j)!='i')
            newSign+=sign.charAt(j);
          if (sign.charAt(j)=='i')
          {}
        }
        sign = newSign;
        newSign = null;
        if (check == false)
        {
          val = new Complex(Double.parseDouble(sign),0);
        }
        else
        {
          val = new Complex(0,Double.parseDouble(sign));
        }
        /*if (values.size()!=0)
          vall = values.pop();
        if (val.re()==0&&vall.im()==0)
          val = new Complex(vall.re(),val.im());
        else if (val.im()==0&&vall.re()==0)
          val = new Complex(val.re(),vall.im());*/
        values.push(val);
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
          //if (values.size()>=2)
          //{
            Complex val2 = values.pop();
            Complex val1 = values.pop();
            values.push(eval(op,val1,val2));
          //}
        }
      }
    }
    while (!ops.isEmpty())
    {
      String op = ops.pop();
      Complex val2 = values.pop();
      Complex val1 = values.pop();
      values.push(eval(op, val1, val2));
    }
    Complex answ = values.pop();
    return answ;
  }
  public static Complex eval(String op, Complex val1, Complex val2) {
        if (op.equals("+")) return val1.plus(val2);//plus
        if (op.equals("-")) return val1.minus(val2);//minus
        if (op.equals("/")) return val1.divides(val2);//division
        if (op.equals("*")) return val1.times(val2);//mult
        throw new RuntimeException("Invalid operator");
    }
}

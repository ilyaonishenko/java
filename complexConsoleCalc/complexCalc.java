public class complexCalc implements complexOperations
{
  double res = 0;
  double resi = 0;
  public String complexAddition(String a,String b, String ai,String bi)
  {
    double a1 = Double.parseDouble(a);
    double a2 = Double.parseDouble(ai);
    double b1 = Double.parseDouble(b);
    double b2 = Double.parseDouble(bi);
    res = a1+b1;
    resi = a2+b2;
    return String.valueOf(res)+"|"+String.valueOf(resi);
  }
  public String complexSubtraction(String a,String b,String ai,String bi)
  {
    double a1 = Double.parseDouble(a);
    double a2 = Double.parseDouble(ai);
    double b1 = Double.parseDouble(b);
    double b2 = Double.parseDouble(bi);
    res = a1-b1;
    resi = a2-b2;
    return String.valueOf(res)+"|"+String.valueOf(resi);
  }
  public String complexMultiplication(String a,String b,String ai,String bi)
  {
    double a1 = Double.parseDouble(a);
    double a2 = Double.parseDouble(ai);
    double b1 = Double.parseDouble(b);
    double b2 = Double.parseDouble(bi);
    res = a1*b1-a2*b2;
    resi = a1*b2+a2*b1;
    return String.valueOf(res)+"|"+String.valueOf(resi);
  }
  public String complexDivision(String a,String b,String ai,String bi)
  {
    double a1 = Double.parseDouble(a);
    double a2 = Double.parseDouble(ai);
    double b1 = Double.parseDouble(b);
    double b2 = Double.parseDouble(bi);
    res = (a1*b1+a2*b2)/(b1*b1+b2*b2);
    resi = (a2*b1-a1*b2)/(b1*b1+b2*b2);
    return String.valueOf(res)+"|"+String.valueOf(resi);
  }
}

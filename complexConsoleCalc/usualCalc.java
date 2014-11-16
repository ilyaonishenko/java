public class usualCalc implements Operations
{
  public double addition(String a,String b)
  {
    double a1 = Double.parseDouble(a);
    double b1 = Double.parseDouble(b);
    double result = a1+b1;
    return result;
  }
  public double subtraction(String a, String b)
  {
    double a1 = Double.parseDouble(a);
    double b1 = Double.parseDouble(b);
    double result = a1-b1;
    return result;
  }
  public double multiplication(String a,String b)
  {
      double a1 = Double.parseDouble(a);
      double b1 = Double.parseDouble(b);
      double result = a1*b1;
      return result;
  }
  public double division(String a,String b)
  {
    double a1 = Double.parseDouble(a);
    double b1 = Double.parseDouble(b);
    double result = a1/b1;
    return result;
  }
}

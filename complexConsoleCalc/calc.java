public class calc
{
  Operations operations = new usualCalc();
  complexOperations complexOperations = new complexCalc();
  public double performAddition(String a,String b)
  {
    return operations.addition(a,b);
  }
  public double performSubtraction(String a,String b)
  {
    return operations.subtraction(a,b);
  }
  public double performMultiplication(String a,String b)
  {
    return operations.multiplication(a,b);
  }
  public double performDivision(String a,String b)
  {
    return operations.division(a,b);
  }
  public String performComplexAddition(String a,String b,String ai,String bi)
  {
    return complexOperations.complexAddition(a,b,ai,bi);
  }
  public String performComplexSubtraction(String a,String b,String ai,String bi)
  {
    return complexOperations.complexSubtraction(a,b,ai,bi);
  }
  public String performComplexMultiplication(String a,String b,String ai,String bi)
  {
    return complexOperations.complexMultiplication(a,b,ai,bi);
  }
  public String performComplexDivision(String a,String b,String ai,String bi)
  {
    return complexOperations.complexDivision(a,b,ai,bi);
  }
}

public class Date
{
  private final int day;
  private final int month;
  private final int year;
  public Date (int day,int month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
  }
  public int month()
  {
    return this.month;
  }
  public int day()
  {
    return this.day;
  }
  public int year()
  {
    return this.year;
  }
  public String toString()
  {
    return day()+"/"+month()+"/"+year();
  }
  public static void main(String[] args)
  {
    int day = Integer.parseInt(args[0]);
    int month = Integer.parseInt(args[1]);
    int year = Integer.parseInt(args[2]);
    Date date = new Date(day,month,year);
    System.out.println(date);
  }
}

public class Env
{
	private static Env env;
	private static int size_x,size_y;
	static Character field[][];
	private Env(int x,int y)
	{
		size_x = x;
		size_y = y;
		init();
	}
	public static Env getEnv(int x,int y)
	{
		if (env == null)
			env = new Env(x,y);
		return env;
	}
	public void init()
	{
		field = new Character[size_x][size_y];
		for (int i=0;i<size_y;i++)
		{
			for (int j=0;j<size_x;j++)
			{
				field[j][i] = '-';
			}
		}
	}
	public static void Print()
	{
		for (int i=0;i<size_x;i++)
		{
			for (int j=0;j<size_x;j++)
				System.out.print(field[j][i]+" ");
			System.out.print("\n");
		}
	}
}

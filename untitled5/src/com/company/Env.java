package com.company;
public class Env
{
	//sadasdas
	private static Env env;
	private static int size;
	public static char field[][];
	private Env(int size)
	{
		this.size = size;
		init();
	}
	public static Env getEnv(int size)
	{
		if (env == null)
			env = new Env(size);
		return env;
	}
	public static void init()
	{
		field = new char[size][size];
		for (int i=0;i<size;i++)
			for (int j=0;j<size;j++)
				field[j][i]='-';
	}
	public static void Print()
	{
		for (int i=0;i<size;i++)
		{
			for (int j=0;j<size;j++)
				System.out.print(field[j][i]+" ");
			System.out.print("\n");
		}
	}
	public static int getSize()
	{
		return size;
	}
}

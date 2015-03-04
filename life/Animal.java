import java.util.ArrayList;
import java.util.HashMap;
public class Animal extends Actor
{
	EatBehavior eatBehavior;
	LifeBehavior lifeBehavior;
	private int x,y;
	private char id;
	final static char show = '-';
	public Animal(int x,int y,char id,char show)
	{
		super(x,y,id,show);
		this.x= x;
		this.y=y;
		this.id=id;
	}
	public HashMap read()
	{
		int count=0;
        HashMap<Integer,Character> map = new HashMap<Integer,Character>();
        ArrayList<Integer> list = new ArrayList<Integer>();
		/*
        1 for up
        2 for right
        3 for down
        4 for left
        */
        if (y-1>=0)
        {
            count++;
            list.add(0);
        }
        if (x-1>=0)
        {
            count++;
            list.add(3);
        }
        if (y+1<=Env.field.length-1)
        {
            count++;
            list.add(2);
        }
        if (x+1<=Env.field.length-1)
        {
            count++;
            list.add(1);
        }
        if (count==4)
        {
            map.put(0,Env.field[x][y-1]);
            map.put(1,Env.field[x+1][y]);
            map.put(2,Env.field[x][y+1]);
            map.put(3,Env.field[x-1][y]);
            map.put(4,Env.field[x][y]);
        }
        else
        {
            for (int i=0;i<list.size();i++)
            {
                if(list.get(i)==0)
                {
                    map.put(0,Env.field[x][y-1]);
                }
                else if (list.get(i)==1)
                {
                    map.put(1,Env.field[x+1][y]);
                }
                else if (list.get(i)==2)
                {
                    map.put(2,Env.field[x][y+1]);
                }
                else if (list.get(i)==3)
                {
                    map.put(3,Env.field[x-1][y]);
                }
            }
            map.put(4,Env.field[x][y]);
        }
        return map;
	}
}

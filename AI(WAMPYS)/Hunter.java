import java.util.ArrayList;
import java.util.HashMap;
public class Hunter extends Ccharacter
{
    final static char w = 'w';
    final static char _d = '~';
    final static char _g = '+';
    final static char _w = '§';
    final static char none = '-';
    private int x,y;
    private char id,show;
    public Hunter(int x,int y,char id,char show,Env env)
    {
        super (x,y,id,show,env);
        this.x=x;
        this.y=y;
        this.id = id;
        this.show = show;
    }
    public Hunter moveUp(Hunter hunter,Env env)
    {
        this.y--;
        System.out.println("x is"+hunter.getX());
        System.out.println("y is"+hunter.getY());
        hunter.delete(env);
        return new Hunter(x,y,id,show,env);
    }
    public Hunter moveDown(Hunter hunter,Env env)
    {
        this.y++;
        System.out.println("x is"+hunter.getX());
        System.out.println("y is"+hunter.getY());
        hunter.delete(env);
        return new Hunter(x,y,id,show,env);
    }
    public Hunter moveRight(Hunter hunter,Env env)
    {
        this.x++;
        System.out.println("x is"+hunter.getX());
        System.out.println("y is"+hunter.getY());
        hunter.delete(env);
        return new Hunter(x,y,id,show,env);
    }
    public Hunter moveLeft(Hunter hunter,Env env)
    {
        this.x--;
        System.out.println("x is"+hunter.getX());
        System.out.println("y is"+hunter.getY());
        hunter.delete(env);
        return new Hunter(x,y,id,show,env);
    }
    public HashMap read(Env env)
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
        if (y+1<=env.field.length-1)
        {
            count++;
            list.add(2);
        }
        if (x+1<=env.field.length-1)
        {
            count++;
            list.add(1);
        }
        if (count==4)
        {
            map.put(0,env.field[x][y-1]);
            map.put(1,env.field[x+1][y]);
            map.put(2,env.field[x][y+1]);
            map.put(3,env.field[x-1][y]);
            map.put(4,env.field[x][y]);
        }
        else
        {
            for (int i=0;i<list.size();i++)
            {
                if(list.get(i)==0)
                {
                    map.put(0,env.field[x][y-1]);
                }
                else if (list.get(i)==1)
                {
                    map.put(1,env.field[x+1][y]);
                }
                else if (list.get(i)==2)
                {
                    map.put(2,env.field[x][y+1]);
                }
                else if (list.get(i)==3)
                {
                    map.put(3,env.field[x-1][y]);
                }
            }
            map.put(4,env.field[x][y]);
        }
        return map;
    }
    public Hunter understand(Hunter hunter,Env env,HashMap map)
    {
        if (hunter.getBefore()=='g')
        {
            System.out.println("YOU WIN");
        }
        for (int i=0;i<map.size()-1;i++)
        {
            try
            {
                if ((char)map.get(i)!=_d)
                {
                    System.out.println("Yes");
                    if (i==0)
                        return hunter.moveUp(hunter,env);
                    if (i==1)
                        return hunter.moveRight(hunter,env);
                    if (i==2)
                        return hunter.moveDown(hunter,env);
                    if (i==3)
                        return hunter.moveLeft(hunter,env);
                }
            }
            catch(NullPointerException e)
            {
                System.out.println("что-то не так");
            }
        }
        return hunter;
    }
}

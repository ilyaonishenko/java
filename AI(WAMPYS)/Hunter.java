import java.util.ArrayList;
public class Hunter extends Ccharacter
{
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
        hunter.delete(env);
        return new Hunter(x,y,id,show,env);
    }
    public Hunter moveDown(Hunter hunter,Env env)
    {
        this.y++;
        hunter.delete(env);
        return new Hunter(x,y,id,show,env);
    }
    public Hunter moveRight(Hunter hunter,Env env)
    {
        this.x++;
        hunter.delete(env);
        return new Hunter(x,y,id,show,env);
    }
    public Hunter moveLeft(Hunter hunter,Env env)
    {
        this.x--;
        hunter.delete(env);
        return new Hunter(x,y,id,show,env);
    }
    public char[] read(Env env)
    {
        int count=0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        char[] array;
        /*
        1 for up
        2 for right
        3 for down
        4 for left
        */
        if (y-1>0)
        {
            count++;
            list.add(1);
        }
        if (x-1>0)
        {
            count++;
            list.add(4);
        }
        if (y+1<env.field.length-1)
        {
            count++;
            list.add(3);
        }
        if (x+1<env.field.length-1)
        {
            count++;
            list.add(2);
        }
        if (count==4)
        {
            array = new char[5];
            array[0] = env.field[x][y-1];
            array[1] = env.field[x+1][y];
            array[2] = env.field[x][y+1];
            array[3] = env.field[x-1][y];
            array[4] = env.field[x][y];
        }
        else
        {
            array= new char[list.size()+1];
            for (int i=0;i<list.size();i++)
            {
                if(list.get(i)==1)
                {
                    array[i]=env.field[x][y-1];
                }
                if (list.get(i)==2)
                {
                    array[i]=env.field[x+1][y];
                }
                if (list.get(i)==3)
                {
                    array[i]=env.field[x][y+1];
                }
                if (list.get(i)==4)
                {
                    array[i]=env.field[x-1][y];
                }
            }
            array[list.size()]=env.field[x][y];
        }
        return array;
    }
}

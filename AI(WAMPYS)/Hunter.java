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
}

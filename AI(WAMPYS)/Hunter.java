public class Hunter extends Ccharacter
{
    private int x,y;
    public Hunter(int x,int y,char id,char show,Env env)
    {
        super (x,y,id,show,env);
        this.x=x;
        this.y=y;
    }
    public void moveUp()
    {
        this.y--;
    }
}

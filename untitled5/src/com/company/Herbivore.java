package com.company;
public class Herbivore extends Animal {
    public Herbivore(char id, int x, int y) {
        super(id, x, y);
    }
    @Override
    public void moveUp() {
        clear();
        if(!isDead())
            setY(getY() - 1);
        setEnetgy(getEnergy() - 1);
        if(Conflict.fastCheck1(Main.plantsList, this.getX(), this.getY()))
            this.setEnetgy(this.getEnergy()+max);
        if(Conflict.fastCheck3(Main.predatorsList,this.getX(),this.getY()))
            death();
        refresh();
    }
    @Override
    public void moveDown() {
        clear();
        if(!isDead())
            setY(getY() + 1);
        setEnetgy(getEnergy() - 1);
        if(Conflict.fastCheck1(Main.plantsList, this.getX(), this.getY()))
            this.setEnetgy(this.getEnergy() + max);
        if(Conflict.fastCheck3(Main.predatorsList,this.getX(),this.getY()))
            death();
        refresh();
    }
    @Override
    public void moveLeft() {
        clear();
        if (!isDead())
            setX(getX() - 1);
        setEnetgy(getEnergy() - 1);
        if(Conflict.fastCheck1(Main.plantsList, this.getX(), this.getY()))
            this.setEnetgy(this.getEnergy() + max);
        if(Conflict.fastCheck3(Main.predatorsList,this.getX(),this.getY()))
            death();
        refresh();
    }
    @Override
    public void moveRight() {
        clear();
        if(!isDead())
            setX(getX() + 1);
        setEnetgy(getEnergy() - 1);
        if(Conflict.fastCheck1(Main.plantsList, this.getX(), this.getY()))
            this.setEnetgy(this.getEnergy() + max);
        if(Conflict.fastCheck3(Main.predatorsList,this.getX(),this.getY()))
            death();
        refresh();
    }
    @Override
    public char[] sight(){
        /*
        0 for up2
        1 for up1
        2 for right2
        3 for right1
        4 for down2
        5 for down1
        6 for left2
        7 for left1
         */
        char nit = 'n';
        char[] locs = new char[8];
        try{
            locs[0]=Env.field[getX()][getY()-2];
        }catch(ArrayIndexOutOfBoundsException e){
            locs[0]=nit;
        }
        try{
            locs[1]=Env.field[getX()][getY()-1];
        }catch(ArrayIndexOutOfBoundsException e){
            locs[1]=nit;
        }
        try{
            locs[2]=Env.field[getX()+2][getY()];
        }catch(ArrayIndexOutOfBoundsException e){
            locs[2]=nit;
        }
        try{
            locs[3]=Env.field[getX()+1][getY()];
        }catch(ArrayIndexOutOfBoundsException e){
            locs[3]=nit;
        }
        try{
            locs[4]=Env.field[getX()][getY()+2];
        }catch(ArrayIndexOutOfBoundsException e){
            locs[4]=nit;
        }
        try{
            locs[5]=Env.field[getX()][getY()+1];
        }catch(ArrayIndexOutOfBoundsException e){
            locs[5]=nit;
        }
        try{
            locs[6]=Env.field[getX()-2][getY()];
        }catch(ArrayIndexOutOfBoundsException e){
            locs[6]=nit;
        }
        try{
            locs[7]=Env.field[getX()-1][getY()];
        }catch(ArrayIndexOutOfBoundsException e){
            locs[7]=nit;
        }
        return locs;
    }
    @Override
    public void thinking(char lookId){
        char[] locs = sight();
        boolean check =false;
        for(int i=0;i<locs.length;i++){
            if(locs[i]!='n'){
                if(locs[i]==lookId){
                    if(!check) {
                        if (i == 0 || i == 1) {
                            moveUp();
                            check = true;
                        }
                        if (i == 2 || i == 3) {
                            moveRight();
                            check = true;
                        }
                        if (i == 4 || i == 5) {
                            moveDown();
                            check = true;
                        }
                        if (i == 6 || i == 7) {
                            moveLeft();
                            check = true;
                        }
                    }
                }
            }
        }
        if(!check)
            randomMove();
    }
}
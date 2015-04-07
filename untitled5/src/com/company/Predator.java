package com.company;
public class Predator extends Animal{
	public Predator(char id,int x,int y){
		super(id,x,y);
	}
    @Override
    public void moveRight(){
        clear();
        if (!isDead())
            setX(getX()+1);
        setEnetgy(getEnergy()-1);
        // тут должна быть проверка
        if(Conflict.fastCheck2(Main.herbivoresList, this.getX(), this.getY()))
            this.setEnetgy(this.getEnergy() + max);
        refresh();
    }
    @Override
    public void moveLeft(){
        clear();
        if(!isDead())
            setX(getX()-1);
        setEnetgy(getEnergy()-1);
        if(Conflict.fastCheck2(Main.herbivoresList,this.getX(),this.getY()))
            this.setEnetgy(this.getEnergy() + max);
        refresh();
    }
    @Override
    public void moveDown(){
        clear();
        if(!isDead())
            setY(getY()+1);
        setEnetgy(getEnergy()-1);
        if(Conflict.fastCheck2(Main.herbivoresList,this.getX(),this.getY()))
            this.setEnetgy(this.getEnergy()+max);
        refresh();
    }
    @Override
    public void moveUp(){
        clear();
        if(!isDead())
            setY(getY()-1);
        setEnetgy(getEnergy()-1);
        if(Conflict.fastCheck2(Main.herbivoresList,this.getX(),this.getY()))
            this.setEnetgy(this.getEnergy()+max);
        refresh();
    }
}

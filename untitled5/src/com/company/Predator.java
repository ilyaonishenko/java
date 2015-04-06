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
        Conflict.fastCheck2(Main.herbivoresList, this.getX(), this.getY());
        refresh();
    }
    @Override
    public void moveLeft(){
        clear();
        if(!isDead())
            setX(getX()-1);
        setEnetgy(getEnergy()-1);
        Conflict.fastCheck2(Main.herbivoresList,this.getX(),this.getY());
        refresh();
    }
    @Override
    public void moveDown(){
        clear();
        setY(getY()+1);
        setEnetgy(getEnergy()-1);
        Conflict.fastCheck2(Main.herbivoresList,this.getX(),this.getY());
        refresh();
    }
    @Override
    public void moveUp(){
        clear();
        setY(getY()-1);
        setEnetgy(getEnergy()-1);
        Conflict.fastCheck2(Main.herbivoresList,this.getX(),this.getY());
        refresh();
    }
}

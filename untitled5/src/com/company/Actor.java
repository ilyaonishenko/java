package com.company;
public class Actor{
	private int x,y,energy;
	private char id,before;
	final static char none = '-';
	final static int max = 100;
	private boolean dead = false;
	public Actor(char id,int x,int y)
	{
		this.x = x;
		this.y = y;
		this.id = id;
		this.energy = max;
		refresh();
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public int getX()
	{
		return x;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public int getY()
	{
		return y;
	}
	public int getEnergy()
	{
		return this.energy;
	}
	public void setEnetgy(int energy)
	{
		this.energy = energy;
	}
	public void addEnergy(int energy)
	{
		this.energy +=energy;
	}
	public char getBefore()
	{
		return before;
	}
	public void setBefore(char before){
		this.before = before;
	}
	public void setID(char id)
	{
		this.id = id;
	}
	public char getID()
	{
		return id;
	}
	public void refresh(){
		if (!isDead()){
			this.before = Env.field[x][y];
			Env.field[x][y]=id;
		}
		else{
			Env.field[x][y]=id;
		}
	}
	public void clear(){
		Env.field[x][y]=this.before;
	}
	public void death(){
		this.id=none;
		//this.before = none;
		this.dead = true;
		refresh();
	}
	public boolean isDead(){
		return this.dead;
	}
	public void info()
	{
		System.out.println("------------------------");
		System.out.println("id: "+this.id);
		System.out.println("x: "+this.x);
		System.out.println("y: "+this.y);
		System.out.println("energy: "+this.energy);
		System.out.println("before: "+this.before);
		System.out.println("------------------------");
	}
}

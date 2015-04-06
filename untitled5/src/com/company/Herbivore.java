package com.company;
public class Herbivore extends Animal {
    public Herbivore(char id, int x, int y) {
        super(id, x, y);
    }
    @Override
    public void moveUp() {
        clear();
        setY(getY() - 1);
        setEnetgy(getEnergy() - 1);
        Conflict.fastCheck1(Main.plantsList, this.getX(), this.getY());
        refresh();
    }
    @Override
    public void moveDown() {
        clear();
        setY(getY() + 1);
        setEnetgy(getEnergy() - 1);
        Conflict.fastCheck1(Main.plantsList, this.getX(), this.getY());
        refresh();
    }
    @Override
    public void moveLeft() {
        clear();
        setY(getX() - 1);
        setEnetgy(getEnergy() - 1);
        Conflict.fastCheck1(Main.plantsList, this.getX(), this.getY());
        refresh();
    }
    @Override
    public void moveRight() {
        clear();
        setY(getX() + 1);
        setEnetgy(getEnergy() - 1);
        Conflict.fastCheck1(Main.plantsList, this.getX(), this.getY());
        refresh();
    }
}
package com.javarush.games.spaceinvaders.gameobjects;



public class Ship extends GameObject {
    public boolean isAlive = true;

    public Bullet fire() {
        return null;
    }

    public Ship(double x, double y) {
        super(x, y);
    }

    public void setStaticView(int[][] viewFrame) {
            super.setMatrix(viewFrame);
    }

    public void kill() {
        this.isAlive = false;
    }
}

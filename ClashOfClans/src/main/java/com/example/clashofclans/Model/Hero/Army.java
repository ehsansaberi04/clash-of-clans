package com.example.clashofclans.Model.Hero;

public abstract class Army {
    private int x ;
    private int y ;
    private double health ;
    public Army (double health) {
        this.health = health ;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public double getHealth() {
        return health;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setHealth(double health) {
        this.health = health;
    }
}

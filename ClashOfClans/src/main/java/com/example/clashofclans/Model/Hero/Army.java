package com.example.clashofclans.Model.Hero;

import javafx.scene.image.ImageView;

import java.util.IdentityHashMap;

public abstract class Army {
    private double x ;
    private double y ;
    private double health ;
    public Army (double health , ImageView imageView) {
        this.health = health ;
        this.x = imageView.getX() + 10 ;
        this.y = imageView.getY() + 10 ;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getHealth() {
        return health;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setHealth(double health) {
        this.health = health;
    }
    public void hurting (double damage) {
        this.health -= damage ;
    }
}

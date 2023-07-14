package com.example.clashofclans.Model.Building;

import javafx.scene.image.ImageView;

public abstract class Building {
    private final Type type ;
    private double health ;
    private final double x ;
    private final double y ;
    public final ImageView imageView ;
    public Building (Type type , double health , ImageView imageView) {
        this.type = type ;
        this.health = health ;
        if (type.equals(Type.main)){
            this.x = imageView.getX() + 20;
            this.y = imageView.getY() + 20;
        } else {
            this.x = imageView.getX() + 15;
            this.y = imageView.getY() + 15;
        }
        this.imageView = imageView;
    }
    public Type getType() {
        return type;
    }
    public double getHealth() {
        return health;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public void setHealth(double health) {
        this.health = health;
    }
    public void hurting (double damage) {
        this.health -= damage ;
    }
}

package com.example.clashofclans.Model.Building;

import com.example.clashofclans.Clash;
import javafx.scene.image.Image;

public class Toop {
    public Toop (double damage) {
        this.damage = damage ;
    }
    private double damage ;
    private final static Image image = new Image(Clash.class.getResource("image/toop.png").toString());
    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    synchronized public static Image getImage() {
        return image;
    }
}

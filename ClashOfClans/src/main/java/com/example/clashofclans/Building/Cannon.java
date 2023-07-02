package com.example.clashofclans.Building;

import javafx.scene.image.ImageView;

public class Cannon extends Building{
//    properties
    private final double bord = 7;
    private final double speedDamage = 1;
    private static int level = 1 ;
    private double damage ;
//    constructor

    public Cannon (ImageView imageView) {
        super(Type.defence , (517 + (level * 33)) , imageView);
        create();
    }
    private void create () {
        this.damage = 34 + (level * 6) ;
    }
//    getter
    public double getBord() {
        return bord;
    }
    public double getSpeedDamage() {
        return speedDamage;
    }
    public double getDamage() {
        return damage;
    }
    public static int getLevel() {
        return level;
    }
    //    setter
    public static void setLevel(int level) {
        Cannon.level = level;
    }
    public void setDamage(double damage) {
        this.damage = damage;
    }
}

package com.example.clashofclans.Hero;

import com.example.clashofclans.Clash;
import javafx.scene.image.ImageView;

public class Archer extends Army {
//    properties
    private final double speed = 2 ;
    private final double bord = 5 ;
    private final double speedDamage = 0.7 ;
    private final int space = 1 ;
    private final Target target = Target.all ;
    private static int level = 1 ;
    private double health ;
    private double damage ;
    public final ImageView imageView = new ImageView (Clash.class.getResource("image/archer.png").toString());
//    constructor
    public Archer () {
        create();
    }
    private void create () {
        this.health = 140 + (level * 25) ;
        this.damage = 26 + (level * 6) ;
    }
//    getter
    public double getSpeed() {
        return speed;
    }
    public double getSpeedDamage() {
        return speedDamage;
    }
    public int getSpace() {
        return space;
    }
    public double getDamage() {
        return damage;
    }
    public double getHealth() {
        return health;
    }
    public static int getLevel() {
        return level;
    }
    public Target getTarget() {
        return target;
    }
    public double getBord() {
        return bord;
    }

    //    setter
    public void setHealth(double health) {
        this.health = health;
    }
    public static void setLevel(int level) {
        Archer.level = level;
    }
    public void setDamage(double damage) {
        this.damage = damage;
    }
}
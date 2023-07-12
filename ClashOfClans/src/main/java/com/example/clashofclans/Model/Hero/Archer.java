package com.example.clashofclans.Model.Hero;

import com.example.clashofclans.Clash;
import javafx.scene.image.ImageView;

public class Archer extends Army {
//    properties
    private final double speed = 2 ;
    private final double bord = 4 ;
    private final double speedDamage = 0.7 ;
    private final int space = 1 ;
    private final Target target = Target.all ;
    private static int level = 1 ;
    private double damage ;
    public static final ImageView imageView = new ImageView (Clash.class.getResource("image/archer.png").toString());
//    constructor
    public Archer () {
        super(140 + (level * 25));
        create();
    }
    private void create () {
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
    public static void setLevel(int level) {
        Archer.level = level;
    }
    public void setDamage(double damage) {
        this.damage = damage;
    }
}
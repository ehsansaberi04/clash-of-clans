package com.example.clashofclans.Model.Hero;

import com.example.clashofclans.Clash;
import javafx.scene.image.ImageView;

public class Barbarian extends Army {
//  properties
    private final double speed = 1 ;
    private final double speedDamage = 1 ;
    private final int space = 1 ;
    private final Target target = Target.all ;
    private static int level = 1 ;
    private double damage ;
    public static final ImageView imageView = new ImageView (Clash.class.getResource("image/barbars/barbar.png").toString());
//    constructor
    public Barbarian () {
        super(170 + (level * 30));
        create();
    }
    private void create () {
        this.damage = 180 + (level * 2) ;
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
//    setter
    public static void setLevel(int level) {
        Barbarian.level = level;
    }
    public void setDamage(double damage) {
        this.damage = damage;
    }
}
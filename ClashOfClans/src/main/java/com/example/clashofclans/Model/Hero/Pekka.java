package com.example.clashofclans.Model.Hero;

import com.example.clashofclans.Clash;
import javafx.scene.image.ImageView;

public class Pekka extends Army {
//    properties
    private final double speed = 0.8 ;
    private final double speedDamage = 2.2 ;
    private final int space = 25 ;
    private final Target target = Target.all ;
    private static int level = 1 ;
    private double damage ;
    public static final ImageView imageView = new ImageView (Clash.class.getResource("image/pekka.png").toString());
//    constructor
    public Pekka (ImageView imageView) {
        super(1250 + (level * 250) , imageView);
        create();
    }
    private void create () {
        this.damage = 180 + (level * 20) ;
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
        Pekka.level = level;
    }
    public void setDamage(double damage) {
        this.damage = damage;
    }
}

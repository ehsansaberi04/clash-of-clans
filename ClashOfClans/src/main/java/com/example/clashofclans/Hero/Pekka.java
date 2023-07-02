package com.example.clashofclans.Hero;

import com.example.clashofclans.Clash;
import javafx.scene.image.ImageView;

public class Pekka extends Army {
//    properties
    private final double speed = 0.8 ;
    private final double speedDamage = 2.2 ;
    private final int space = 25 ;
    private final Target target = Target.all ;
    private static int level = 1 ;
    private double health ;
    private double damage ;
    public final ImageView imageView = new ImageView (Clash.class.getResource("image/pekka.png").toString());
//    constructor
    public Pekka () {
        create();
    }
    private void create () {
        this.health = 1250 + (level * 250) ;
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
    public double getHealth() {
        return health;
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
    public void setHealth(double health) {
        this.health = health;
    }
    public void setDamage(double damage) {
        this.damage = damage;
    }
}

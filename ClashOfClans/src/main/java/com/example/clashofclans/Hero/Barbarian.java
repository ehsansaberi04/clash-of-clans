package com.example.clashofclans.Hero;

import com.example.clashofclans.Clash;
import javafx.scene.image.ImageView;

public class Barbarian extends Army {
//  properties
    private final double speed = 1 ;
    private final double speedDamage = 1 ;
    private final int space = 1 ;
    private final Target target = Target.all ;
    private static int level = 1 ;
    private double health ;
    private double damage ;
    public final ImageView imageView = new ImageView (Clash.class.getResource("image/barbar.png").toString());
//    constructor
    public Barbarian () {
        create();
    }
    private void create () {
        this.health = 170 + (level * 30) ;
        this.damage = 18000 + (level * 2) ;
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
    public void setHealth(double health) {
        this.health = health;
    }
    public static void setLevel(int level) {
        Barbarian.level = level;
    }
    public void setDamage(double damage) {
        this.damage = damage;
    }
}
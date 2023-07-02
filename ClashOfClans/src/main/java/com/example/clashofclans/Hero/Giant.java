package com.example.clashofclans.Hero;

import com.example.clashofclans.Clash;
import javafx.scene.image.ImageView;

public class Giant extends Army {
//    properties
    private final double speed = 1 ;
    private final double speedDamage = 1.4 ;
    private final int space = 5 ;
    private final Target target = Target.defence ;
    private static int level = 1 ;
    private double health ;
    private double damage ;
    public final ImageView imageView = new ImageView (Clash.class.getResource("image/giant.png").toString());
//    constructor
    public Giant () {
        create();
    }
    private void create () {
        this.health = 825 + (level * 75) ;
        this.damage = 40 + (level * 5) ;
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
    public void setDamage(double damage) {
        this.damage = damage;
    }
    public void setHealth(double health) {
        this.health = health;
    }
    public static void setLevel(int level) {
        Giant.level = level;
    }
}


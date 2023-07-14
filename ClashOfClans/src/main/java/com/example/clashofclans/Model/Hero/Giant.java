package com.example.clashofclans.Model.Hero;

import com.example.clashofclans.Clash;
import javafx.scene.image.ImageView;

public class Giant extends Army {
//    properties
    private final double speed = 1 ;
    private final double speedDamage = 1.4 ;
    private final int space = 5 ;
    private final Target target = Target.defence ;
    private static int level = 1 ;
    private double damage ;
    public static final ImageView imageView = new ImageView (Clash.class.getResource("image/giant.png").toString());
//    constructor
    public Giant (ImageView imageView) {
        super(825 + (level * 75) , imageView);
        create();
    }
    private void create () {
        this.damage = 400 + (level * 5) ;
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
    public void setDamage(double damage) {
        this.damage = damage;
    }
    public static void setLevel(int level) {
        Giant.level = level;
    }
}
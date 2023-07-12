package com.example.clashofclans.Model.Building;


import javafx.scene.image.ImageView;

public class ArcherTower extends Building{
//    properties
    private final double bord = 10;
    private final double speedDamage = 1;
    private static int level = 1;
    private double damage ;
//    constructor
    public ArcherTower (ImageView imageView) {
        super(Type.defence , (470 + (level * 30)) , imageView);
        create();
    }
    private void create () {
        this.damage = 25 + (level * 5) ;
    }
//    getter
    public double getBord() {
        return bord;
    }
    public double getSpeedDamage() {
        return speedDamage;
    }
    public static int getLevel() {
        return level;
    }
    public double getDamage() {
        return damage;
    }
//    setter
    public static void setLevel(int level) {
        ArcherTower.level = level;
    }
    public void setDamage(double damage) {
        this.damage = damage;
    }
}

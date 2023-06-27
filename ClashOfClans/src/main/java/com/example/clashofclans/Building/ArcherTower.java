package com.example.clashofclans.Building;


public class ArcherTower extends Building{
    private final double bord = 10;
    private final double speedDamage = 1;
    private final Type type = Type.defence ;
    private static int level ;
    private double damage ;
    private double health ;

    public ArcherTower () {
        create();
    }
    private void create () {
        this.health = 470 + (level * 30) ;
        this.damage = 25 + (level * 5) ;
    }
}

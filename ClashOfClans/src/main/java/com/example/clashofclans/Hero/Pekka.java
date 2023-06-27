package com.example.clashofclans.Hero;

public class Pekka extends Army {
    private final double speed = 0.8 ;
    private final double speedDamage = 2.2 ;
    private final int space = 25 ;
    private final Target target = Target.normal ;
    private static int level ;
    private double health ;
    private double damage ;
    public Pekka () {
        create();
    }
    private void create () {
        this.health = 1250 + (level * 250) ;
        this.damage = 180 + (level * 20) ;
    }
}

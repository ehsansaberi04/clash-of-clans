package com.example.clashofclans.Hero;

public class Archer extends Army {
    private final double speed = 4 ;
    private final double speedDamage = 0.7 ;
    private final int space = 1 ;
    private final Target target = Target.normal ;
    private static int level ;
    private double health ;
    private double damage ;
    public Archer () {
        create();
    }
    private void create () {
        this.health = 140 + (level * 25) ;
        this.damage = 26 + (level * 6) ;
    }
}

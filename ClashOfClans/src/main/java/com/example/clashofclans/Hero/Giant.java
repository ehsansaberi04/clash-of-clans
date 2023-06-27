package com.example.clashofclans.Hero;

public class Giant extends Army {
    private final double speed = 1 ;
    private final double speedDamage = 1.4 ;
    private final int space = 5 ;
    private final Target target = Target.defence ;
    private static int level ;
    private double health ;
    private double damage ;
    public Giant () {
        create();
    }
    private void create () {
        this.health = 825 + (level * 75) ;
        this.damage = 40 + (level * 5) ;
    }
}


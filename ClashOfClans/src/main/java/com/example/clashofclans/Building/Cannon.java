package com.example.clashofclans.Building;

import com.example.clashofclans.Building.Type;

public class Cannon extends Building{
    private final double bord = 7;
    private final double speedDamage = 1;
    private final Type type = Type.defence ;
    private static int level ;
    private double damage ;
    private double health ;

    public Cannon () {
        create();
    }
    private void create () {
        this.health = 517 + (level * 33) ;
        this.damage = 34 + (level * 6) ;
    }
}

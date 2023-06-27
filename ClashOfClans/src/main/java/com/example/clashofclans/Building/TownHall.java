package com.example.clashofclans.Building;

public class TownHall extends Building{
    private final Type type = Type.main ;
    private static int level ;
    private double health ;

    public TownHall () {
        create();
    }
    private void create () {
        this.health = 700 + (level * 100) ;
    }
}

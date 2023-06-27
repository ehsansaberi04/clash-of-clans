package com.example.clashofclans.Building;


public class Barrack extends Building{
    private final Type type = Type.army ;
    private static int level ;
    private double health ;

    public Barrack () {
        create();
    }
    private void create () {
        this.health = 250 + (level * 50) ;
    }
}

package com.example.clashofclans.Hero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class Barbarian extends Army {

    private final double speed = 2 ;
    private final double speedDamage = 1 ;
    private final int space = 1 ;
    private final Target target = Target.normal ;
    private static int level ;
    private double health ;
    private double damage ;
    private ImageView imageView ;
    public Barbarian () {
        create();
    }
    private void create () {
        this.health = 170 + (level * 30) ;
        this.damage = 18 + (level * 2) ;
        imageView = new ImageView("");
    }
    void findBuilding () {

    }
}

package com.example.clashofclans.Building;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ElixirMaker extends Building{
//    properties
    private static int level = 1;
//    constructor
    public ElixirMaker(ImageView imageView) {
        super(Type.army , (250 + (level * 50)) , imageView);
    }
//    getter
    public static int getLevel() {
        return level;
    }
    //    setter
    public static void setLevel(int level) {
        ElixirMaker.level = level;
    }
}

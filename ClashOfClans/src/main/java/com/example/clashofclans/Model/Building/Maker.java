package com.example.clashofclans.Model.Building;


import javafx.scene.image.ImageView;

public class Maker extends Building{
//    properties
    private static int level = 1;
//    constructor
    public Maker(ImageView imageView) {
        super(Type.army , (250 + (level * 50)), imageView);
    }
//    getter
    public static int getLevel() {
        return level;
    }
    //    setter
    public static void setLevel(int level) {
        Maker.level = level;
    }
}

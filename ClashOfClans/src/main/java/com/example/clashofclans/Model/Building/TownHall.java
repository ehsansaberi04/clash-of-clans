package com.example.clashofclans.Model.Building;

import javafx.scene.image.ImageView;

public class TownHall extends Building{
//    properties

    private static int level = 1;
//    constructor
    public TownHall (ImageView imageView) {
        super(Type.main , (700 + (level * 100)), imageView);
    }
//    getter
    public static int getLevel() {
        return level;
    }
//    setter
    public static void setLevel(int level) {
        TownHall.level = level;
    }
}

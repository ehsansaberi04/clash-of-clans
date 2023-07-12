package com.example.clashofclans.Attack;

import com.example.clashofclans.Model.Building.Building;
import com.example.clashofclans.Model.Hero.Army;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class War {
    public static List<Building> buildings = new ArrayList<Building>() ;
    public static List<Army> armies = new ArrayList<Army>();
    public static Map<Building , ImageView> map = new HashMap<>();
    public static void clear () {
        map.clear();
        buildings.clear();
        armies.clear();
    }
}

package com.example.clashofclans;


import com.example.clashofclans.Hero.* ;
import com.example.clashofclans.Building.* ;

public class Player {
    private String name ;
    private String pass ;
    private int level ;
    private Map map ;
    public Player (String name , String pass) {
        this.name = name ;
        this.pass = pass ;
    }

    public int getLevel() {
        return level;
    }

    public Map getMap() {
        return map;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }
}

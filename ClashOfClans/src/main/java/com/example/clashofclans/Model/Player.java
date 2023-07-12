package com.example.clashofclans.Model;

public class Player {
    private String name ;
    private String pass ;
    private int level ;
    private int indexMap ;
    private int wins ;
    private int losses ;
    private int indexProfile ;
    private int limit ;
    public Player (String name , String pass) {
        this.name = name ;
        this.pass = pass ;
        level = 1 ;
    }

    public void levelUp () {
        level ++ ;
        limit += 20 ;
    }

    public String getName() {
        return name;
    }
    public String getPass() {
        return pass;
    }
    public int getLevel() {
        return level;
    }
    public int getIndexMap() {
        return indexMap;
    }
    public int getWins() {
        return wins;
    }
    public int getLosses() {
        return losses;
    }
    public int getIndexProfile() {
        return indexProfile;
    }
    public int getLimit() {
        return limit;
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setIndexMap(int indexMap) {
        this.indexMap = indexMap;
        switch (indexMap){
            case 1-> {
                limit = 40 ;
            }
            case 2-> {
                limit = 50 ;
            }
            case 3-> {
                limit = 55 ;
            }
            case 4-> {
                limit = 36 ;
            }
            default ->{
                limit = 0 ;
            }
        }
    }
    public void setWins(int wins) {
        this.wins = wins;
    }
    public void setLosses(int losses) {
        losses = losses;
    }
    public void setIndexProfile(int indexProfile) {
        this.indexProfile = indexProfile;
    }
    public void addWin () {
        wins ++ ;
    }
    public void addLost () {
        losses ++ ;
    }

}

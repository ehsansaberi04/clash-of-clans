package com.example.clashofclans.Attack;

import com.example.clashofclans.Building.Building;
import com.example.clashofclans.Hero.* ;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.Thread.sleep;

public class ThreadBarbar implements Runnable {
    private Barbarian barbarian ;
    private ImageView imageView ;

    public ThreadBarbar (Barbarian barbarian , ImageView imageView) {
        this.barbarian = barbarian ;
        this.imageView = imageView ;
    }
    @Override
    public void run() {
        while (barbarian.getHealth() > 0){
            findBuilding();
            move();
            while (War.buildings.get(indexTarget).getHealth() > 0) {
                attack();
                try {
                    sleep((long) (barbarian.getSpeedDamage()*5000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(barbarian.getHealth() <= 0){
                    break;
                }
            }
            if(War.buildings.get(indexTarget).getHealth() <= 0){
                War.images.get(indexTarget).setVisible(false);
                War.images.remove(indexTarget);
                War.buildings.remove(indexTarget) ;
            }
        }
    }

    private void findBuilding () {
        double min = distance(imageView.getX() , imageView.getY() ,
                War.buildings.get(0).getX() , War.buildings.get(0).getY()) ;
//        ImageView minImage = Map1.buildings.get(0) ;
        Building temp = War.buildings.get(0) ;
        int iMin = 0 ;
        for(Building building : War.buildings) {
            double distance = distance(imageView.getX() , imageView.getY() , building.getX() , building.getY()) ;
            if(distance < min) {
                min = distance ;
                temp = building ;
                iMin = War.buildings.indexOf(building) ;
            }
        }
        indexTarget = iMin ;
        x = temp.getX() - imageView.getX() ;
        y = temp.getY() - imageView.getY();
        distance = sqrt(pow(x , 2) + pow(y , 2)) ;
        target = temp ;
    }
    private double distance (double x1 , double y1 , double x2 , double y2) {
        double x = (x1 - x2) * (x1 - x2) ;
        double y = (y1 - y2) * (y1 - y2) ;
        double distance = sqrt (x + y) ;
        return distance ;
    }


    private double distance ;
    private double x = 0;
    private double y = 0;
    private int indexTarget ;
    private Building target ;

    private void move () {
        TranslateTransition transition = new TranslateTransition() ;
        transition.setNode(imageView);
        transition.setDuration(Duration.millis(duration()));
        transition.setCycleCount(1);
        transition.setByX(x);
        transition.setByY(y);
        transition.play();
    }
    private double duration () {
        double duration =  ((distance/20) / barbarian.getSpeed()) * 1000 ;
        return duration ;
    }
    private void check () {

    }

    public void hurt (double damage) {
        barbarian.setHealth(barbarian.getHealth()-damage);
    }

    private void attack () {
        War.buildings.get(indexTarget).setHealth(War.buildings.get(indexTarget).getHealth()-barbarian.getDamage());
        System.out.println(War.buildings.get(indexTarget).getType());
    }

}

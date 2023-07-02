package com.example.clashofclans.Attack;

import com.example.clashofclans.Building.Building;
import com.example.clashofclans.Hero.Barbarian;
import com.example.clashofclans.Hero.Pekka;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class ThreadPekka implements Runnable{
    private Pekka pekka;
    private ImageView imageView ;

    public ThreadPekka(Pekka pekka , ImageView imageView) {
        this.pekka = pekka ;
        this.imageView = imageView ;
    }
    @Override
    public void run() {
        findBuilding();
        System.out.println(x);
        System.out.println(y);
        move();
    }

    private void findBuilding () {
        double min = distance(imageView.getX() , imageView.getY() ,
                War.buildings.get(0).getX() , War.buildings.get(0).getY()) ;
        Building temp = War.buildings.get(0) ;
        for(Building building : War.buildings) {
            double distance = distance(imageView.getX() , imageView.getY() , building.getX() , building.getY()) ;
            if(distance < min) {
                min = distance ;
                temp = building ;
            }
        }
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
        double duration =  ((distance/20) / pekka.getSpeed()) * 1000 ;
        return duration ;
    }
    private void check () {

    }

    public void hurt (double damage) {
        pekka.setHealth(pekka.getHealth()-damage);
    }

    private void attack () {

    }

}

package com.example.clashofclans.Attack.HeroThreads;

import com.example.clashofclans.Attack.War;
import com.example.clashofclans.Model.Building.Building;
import com.example.clashofclans.Model.Hero.Barbarian;
import com.example.clashofclans.Model.Hero.Giant;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class ThreadGiant implements Runnable{
    private Giant giant ;
    private ImageView imageView ;
    private double myX ;
    private double myY ;
    public ThreadGiant(ImageView imageView){
        giant = new Giant() ;
        this.imageView = imageView ;
        myX = imageView.getX() ;
        myY = imageView.getY() ;
    }
    @Override
    public void run() {
        finding();
    }

    private double moveX ;
    private double moveY ;
    private double distance ;
    private Building target ;

    private synchronized void finding () {
        if(War.buildings.size() != 0) {
            double minX = 10000;
            double minY = 10000;
            Building near = null;
            double minDistance = 10000;
            for (Building building : War.buildings) {
                double x2 = building.getX();
                double y2 = building.getY();
                double distance = distance(myX, x2, myY, y2);
                if (distance <= minDistance) {
                    minDistance = distance;
                    near = building;
                    minX = x2;
                    minY = y2;
                }
            }
            moveX = minX - myX ;
            moveY = minY - myY ;
            distance = minDistance ;
            target = near ;
            myX += moveX ;
            myY += moveY ;
            walking();
        } else {
            destroying();
        }
    }
    TranslateTransition transition ;
    private void walking () {
        transition = new TranslateTransition();
        transition.setNode(imageView);
        transition.setDuration(Duration.millis(duration(distance)));
        transition.setByX(moveX);
        transition.setByY(moveY);
        transition.setCycleCount(1);
        transition.play();
        transition.setOnFinished(ez -> {
            ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
            executor.scheduleAtFixedRate(()->{
                if (target.getHealth() > 0) {
                    target.hurting(giant.getDamage());
                } else {
                    executor.shutdown();
                    finding();
                }
            },0,1, TimeUnit.SECONDS);
        });
    }

    synchronized  boolean isAlive () {
        if(giant.getHealth() <= 0 )
            return false ;
        else return true ;
    }
    private void destroying () {
        War.armies.remove(War.armies.indexOf(giant));
        imageView.setVisible(false);
    }
    private double distance (double x1 , double x2 , double y1 , double y2) {
        double distance = sqrt(pow(x1 - x2 , 2) + pow(y1 - y2 , 2));
        return distance ;
    }
    private double duration (double distance) {
        double duration = ((distance/20) / giant.getSpeed()) * 1000 ;
        return duration ;
    }






//    private void attack (Building target) {
//        while (true) {
//            if (target.getHealth() > 0) {
//                if (isAlive()) {
//                    target.setHealth(target.getHealth() - barbarian.getDamage());
//                    try {
//                        sleep((long) (1000 * barbarian.getSpeedDamage()));
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                } else {
//                    break;
//                }
//            } else break;
//        }
//        if(isAlive()) {
//            finding();
//        } else {
//
//        }
//    }



}
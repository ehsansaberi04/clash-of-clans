package com.example.clashofclans.Attack.HeroThreads;

import com.example.clashofclans.Attack.War;
import com.example.clashofclans.Clash;
import com.example.clashofclans.Model.Building.Building;
import com.example.clashofclans.Model.Hero.Giant;
import javafx.animation.TranslateTransition;
import javafx.geometry.NodeOrientation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.* ;
import static java.lang.Thread.sleep;

public class ThreadGiant implements Runnable{
    private Giant giant ;
    private ImageView imageView ;
    private double myX ;
    private double myY ;
    public ThreadGiant(ImageView imageView){
        giant = new Giant(imageView) ;
        this.imageView = imageView ;
        myX = imageView.getX() ;
        myY = imageView.getY() ;
    }
    @Override
    public void run() {
        setImages();
        imageView.setImage(images.get(2));
        imageView.setFitHeight(40);
        imageView.setFitWidth(40);
        finding();
    }

    private double moveX ;
    private double moveY ;
    private double distance ;
    private Building target ;
    private TranslateTransition transition ;
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
    private void walking () {
        transition = new TranslateTransition();
        transition.setNode(imageView);
        transition.setDuration(Duration.millis(duration(distance)));
        transition.setByX(moveX);
        transition.setByY(moveY);
        transition.setCycleCount(1);
        transition.play();
        isWalked = true ;
        animationWalking();
        transition.setOnFinished(ez -> {
            isWalked = false ;
            isAttacked = true ;
            animationAttacking();
            ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
            executor.scheduleAtFixedRate(()->{
                if (target.getHealth() > 0) {
                    target.hurting(giant.getDamage());
                } else {
                    isAttacked = false ;
                    executor.shutdown();
                    finding();
                }
            },0,1, TimeUnit.SECONDS);
        });
    }

    synchronized boolean isAlive () {
        if(giant.getHealth() <= 0 )
            return false ;
        else return true ;
    }
    private void destroying () {
        imageView.setVisible(false);
        War.armies.remove(War.armies.indexOf(giant));
    }
    private double distance (double x1 , double x2 , double y1 , double y2) {
        double distance = sqrt(pow(x1 - x2 , 2) + pow(y1 - y2 , 2));
        return distance ;
    }
    private double duration (double distance) {
        double duration = ((distance/20) / giant.getSpeed()) * 1000 ;
        return duration ;
    }
    private boolean isWalked ;
    private boolean isAttacked ;
    private int counter ;
    private void animationWalking () {
        if (moveX < 0) {
            imageView.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        } else {
            imageView.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        }
        imageView.setImage(images.get(0));
    }
    private void animationAttacking () {
        imageView.setImage(images.get(1));
    }
    private List <Image> images = new ArrayList<Image>();
    private void setImages () {
        images.add(new Image(Clash.class.getResource("image/walk.gif").toString()));
        images.add(new Image(Clash.class.getResource("image/attack1.gif").toString()));
        images.add(new Image(Clash.class.getResource("image/giant.png").toString()));
    }
}
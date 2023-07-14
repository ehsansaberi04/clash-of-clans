package com.example.clashofclans.Attack.HeroThreads;

import com.example.clashofclans.Attack.War;
import com.example.clashofclans.Clash;
import com.example.clashofclans.Model.Building.Building;
import com.example.clashofclans.Model.Hero.Barbarian;
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

public class ThreadBarbar implements Runnable{
    private Barbarian barbarian ;
    private ImageView imageView ;
    private double myX ;
    private double myY ;
    public ThreadBarbar (ImageView imageView){
        barbarian = new Barbarian(imageView) ;
        War.armies.add(barbarian);
        this.imageView = imageView ;
        myX = imageView.getX() ;
        myY = imageView.getY() ;
    }
    @Override
    public void run() {
        setImages();
        finding();
    }

    private double moveX ;
    private double moveY ;
    private double distance ;
    private Building target ;
    private TranslateTransition transition ;
    private void finding () {
        if(isAlive()) {
            if (War.buildings.size() != 0) {
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
                moveX = minX - myX;
                moveY = minY - myY;
                distance = minDistance;
                target = near;
//                myX += moveX;
//                myY += moveY;
                walking();
            } else {
                destroying();
            }
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
                    target.hurting(barbarian.getDamage());
                } else {
                    isAttacked = false ;
                    executor.shutdown();
                    finding();
                }
            },0,1, TimeUnit.SECONDS);
        });
    }
    synchronized  boolean isAlive () {
        if(barbarian.getHealth() <= 0 )
            return false ;
        else return true ;
    }
    private void destroying () {
        War.armies.remove(War.armies.indexOf(barbarian));
        imageView.setVisible(false);
    }
    private double distance (double x1 , double x2 , double y1 , double y2) {
        double distance = sqrt(pow(x1 - x2 , 2) + pow(y1 - y2 , 2));
        return distance ;
    }
    private double duration (double distance) {
        double duration = ((distance/20) / barbarian.getSpeed()) * 1000 ;
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
        counter = 1 ;
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            if(isAlive()) {
                if (isWalked) {
                    if (counter % 2 == 0) {
                        imageView.setImage(images.get(0));
                    } else {
                        imageView.setImage(images.get(1));
                    }
                    counter += 1;
//                    fixLocation();
                } else {
                    executor.shutdown();
                }
            } else {
                executor.shutdown();
                destroying();
            }
        }, 0, 600, TimeUnit.MILLISECONDS);
        imageView.setImage(images.get(0));
    }
    private void animationAttacking () {
        counter = 1 ;
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            if (isAttacked) {
                switch (counter % 4) {
                    case 1->{
                        imageView.setImage(images.get(2));
                    }
                    case 2->{
                        imageView.setImage(images.get(3));
                    }
                    case 3->{
                        imageView.setImage(images.get(4));
                    }
                    case 0->{
                        imageView.setImage(images.get(0));
                    }
                }
                counter += 1 ;
            } else {
                System.out.println("attack finished");
                executor.shutdown();
            }
        }, 0, 250, TimeUnit.MILLISECONDS);
        imageView.setImage(images.get(0));
    }
    private List <Image> images = new ArrayList<Image>();
    private void setImages () {
        images.add(new Image(Clash.class.getResource("image/barbars/barbar.png").toString()));
        images.add(new Image(Clash.class.getResource("image/barbars/barbar2.png").toString()));
        images.add(new Image(Clash.class.getResource("image/barbars/barbar-2.png").toString()));
        images.add(new Image(Clash.class.getResource("image/barbars/barbar-3.png").toString()));
        images.add(new Image(Clash.class.getResource("image/barbars/barbar-4.png").toString()));
    }
    private void fixLocation () {
        double myTargetX = target.getX();
        double myTargetY = target.getY();
        double ratio ;
        if(moveX == 0) {
            barbarian.setY(barbarian.getY() + (distance/duration(distance))*1000);
        } else if (moveY == 0) {
            barbarian.setX(barbarian.getX() + (distance/duration(distance))*1000);
        } else if (abs(moveX) < abs(moveY)){
            ratio = moveX/abs(moveY) ;
            barbarian.setX(barbarian.getX() + (distance/duration(distance))*1000*(moveX/abs(moveX))*ratio);
            barbarian.setY(barbarian.getY() + (distance/duration(distance))*1000*(moveY/abs(moveY)));
        } else {
            ratio = moveY/abs(moveX) ;
            barbarian.setX(barbarian.getX() + (distance/duration(distance))*1000*(moveX/abs(moveX)));
            barbarian.setY(barbarian.getY() + (distance/duration(distance))*1000*(moveY/abs(moveY))*ratio);
        }
        myX = barbarian.getX();
        myY = barbarian.getY();
    }
}
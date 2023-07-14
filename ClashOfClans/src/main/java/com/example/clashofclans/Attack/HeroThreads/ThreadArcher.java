package com.example.clashofclans.Attack.HeroThreads;

import com.example.clashofclans.Attack.War;
import com.example.clashofclans.Clash;
import com.example.clashofclans.Model.Building.Building;
import com.example.clashofclans.Model.Hero.Archer;
import com.example.clashofclans.Model.Hero.Barbarian;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.chart.BarChart;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.*;

public class ThreadArcher implements Runnable{
    private Archer archer ;
    private ImageView imageView ;
    private double myX ;
    private double myY ;
    Pane pane ;
    public ThreadArcher(ImageView imageView , Pane pane){
        archer = new Archer(imageView) ;
        this.imageView = imageView ;
        myX = imageView.getX() ;
        myY = imageView.getY() ;
        this.pane = pane ;
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
            fixBord();
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
        System.out.println(target.getHealth());
        transition.setOnFinished(ez -> {
            ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
            executor.scheduleAtFixedRate(()->{
                if (target.getHealth() > 0) {
                    ImageView temp = new ImageView();
                    temp.setImage(new Image(Clash.class.getResource("image/raw.png").toString()));
                    temp.setFitHeight(40);
                    temp.setFitWidth(40);
                    temp.setX(myX);
                    temp.setY(myY);
                    temp.setVisible(true);
                    pane.getChildren().add(temp);
                    System.out.println("added");
                    ThreadRaw threadRaw = new ThreadRaw(temp , rawX , rawY) ;
                    Platform.runLater(threadRaw);
                } else {
                    executor.shutdown();
                    finding();
                }
            },0,1, TimeUnit.SECONDS);
        });
    }

    synchronized  boolean isAlive () {
        if(archer.getHealth() <= 0 )
            return false ;
        else return true ;
    }
    private void destroying () {
        War.armies.remove(War.armies.indexOf(archer));
        imageView.setVisible(false);
    }
    private double distance (double x1 , double x2 , double y1 , double y2) {
        double distance = sqrt(pow(x1 - x2 , 2) + pow(y1 - y2 , 2));
        return distance ;
    }
    private double duration (double distance) {
        double duration = ((distance/20) / archer.getSpeed()) * 1000 ;
        return duration ;
    }
    private double rawX = 0;
    private double rawY = 0;
    private void fixBord () {
        distance -= archer.getBord()*20 ;
        double x = (sqrt(2)/2)*archer.getBord()*20 ;
        if(moveX > 0){
            moveX -= x ;
            rawX = x ;
        } else {
            moveX += x ;
            rawX = -x ;
        }
        if(moveY > 0){
            moveY -= x ;
            rawY = x ;
        } else {
            moveY += x ;
            rawY = -x ;
        }
    }

}
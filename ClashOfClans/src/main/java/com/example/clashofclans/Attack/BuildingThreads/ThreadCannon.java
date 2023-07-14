package com.example.clashofclans.Attack.BuildingThreads;

import com.example.clashofclans.Attack.War;
import com.example.clashofclans.Clash;
import com.example.clashofclans.Model.Building.*;
import com.example.clashofclans.Model.Hero.*;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.controlsfx.control.spreadsheet.SpreadsheetCellEditor;

import java.util.concurrent.*;

import static java.lang.Math.*;
import static java.lang.Thread.sleep;

public class ThreadCannon implements Runnable {
    private Cannon cannon;
    private ImageView imageView;
    private ImageView toopA ;
//    private AnchorPane pane ;
    public ThreadCannon(ImageView imageView , AnchorPane pane){
        cannon = new Cannon(imageView) ;
        War.buildings.add(cannon);
        War.map.put(cannon , imageView) ;
        this.imageView = imageView ;
        toopA = new ImageView();
        toopA.setImage(new Image(Clash.class.getResource("image/toop.png").toString()));
        toopA.setVisible(false);
        pane.getChildren().add(toopA) ;
//        this.pane = pane ;
    }
    @Override
    public void run() {
        onAttacked = false;
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            if (isAlive()) {
                if (target == null && War.armies.size() > 0) {
                    finding();
                }
                if (target != null && !onAttacked) {
                    attacking();
                }
            } else {
                destroying();
                executor.shutdown();
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    private boolean isAlive () {
        if (cannon.getHealth() <= 0)
            return false;
        else return true;
    }
    private boolean onAttacked ;
    private Army target = null ;
    private void attacking () {
        setOnAttacked(true);
        System.out.println("my x : " + cannon.getX());
        System.out.println("my y : " + cannon.getY());
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(()->{
            if (target.getHealth() > 0) {
                ImageView toop = toopA;
                toop.setFitWidth (20);
                toop.setFitHeight(20);
                toop.setX(cannon.getX());
                toop.setY(cannon.getY());
                toop.setVisible(true);
                targetX = target.getX();
                targetY = target.getY();
                System.out.println("x : " + targetX);
                System.out.println("y : " + targetY);
                ThreadToop threadToop = new ThreadToop(toop , targetX , targetY , target , cannon.getDamage());
                Platform.runLater(threadToop);
            } else {
                target = null ;
                setOnAttacked(false);
                executor.shutdown();
            }
        },0,1500, TimeUnit.MILLISECONDS);
    }




//    -----------------------------

    private void finding () {
        double minX = 1000 ;
        double minY = 1000 ;
        Army near = null ;
        double x1 = cannon.getX();
        double y1 = cannon.getY();
        double minDistance = 1000;
        for(Army army : War.armies){
            double x2 = army.getX();
            double y2 = army.getY();
            double distance = distance(x1 , x2 , y1 , y2);
            if(distance <= minDistance) {
                minDistance = distance ;
                near = army ;
                minX = x2 ;
                minY = y2 ;
            }
        }
//        System.out.println("that is in : " + distance(cannon.getX() , minX , cannon.getY(), minY));
        System.out.println(cannon.getX() + " : " + minX + " : " + cannon.getY() + " : " + minY);
        if(minDistance <= cannon.getBord()*20 + 30) {
            System.out.println("enemy found");
            targetX = minX;
            targetY = minY;
            target = near;
        }
    }


    private double targetX ;
    private double targetY ;


    public boolean isOnAttacked() {
        return onAttacked;
    }

    public synchronized void setOnAttacked(boolean onAttacked) {
        this.onAttacked = onAttacked;
    }

    private double distance (double x1 , double x2 , double y1 , double y2) {
        double distance = sqrt(pow(x1 - x2 , 2) + pow(y1 - y2 , 2));
        return distance ;
    }
    private void destroying () {
        War.buildings.remove(War.buildings.indexOf(cannon));
        War.map.get(cannon).setVisible(false);
        War.map.remove(cannon) ;
    }
}
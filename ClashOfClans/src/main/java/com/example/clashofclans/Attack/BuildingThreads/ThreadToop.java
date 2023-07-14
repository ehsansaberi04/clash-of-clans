package com.example.clashofclans.Attack.BuildingThreads;

import com.example.clashofclans.Model.Building.Toop;
import com.example.clashofclans.Model.Hero.Army;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import java.util.concurrent.*;

public class ThreadToop implements Runnable{
    public ThreadToop (ImageView imageView , double x , double y , Army target , double damage) {
        this.imageView = imageView ;
        this.x = x ;
        this.y = y ;
        this.target = target ;
        toop = new Toop(damage) ;
    }
    @Override
    public void run() {
        shooting();
    }
    private void shooting () {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(imageView);
        transition.setDuration(Duration.millis(1000));
        transition.setByX(x);
        transition.setByY(y);
        transition.setCycleCount(1);
        transition.play();
        transition.setOnFinished(ez -> {
            target.hurting(toop.getDamage());
            imageView.setVisible(false);
//            fixing();
            System.out.println("i put");
        });
    }
    private void fixing () {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(imageView);
        transition.setDuration(Duration.millis(1));
        transition.setByX(-x);
        transition.setByY(-y);
        transition.setCycleCount(1);
        transition.play();
//        transition.setOnFinished(ez -> {
//            target.hurting(toop.getDamage());
//            imageView.setVisible(false);
//            System.out.println("i put");
//        });
    }
//    private TranslateTransition transition ;
    private ImageView imageView ;
    private double x ;
    private double y ;
    private Army target ;
    private Toop toop ;
}

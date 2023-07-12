package com.example.clashofclans.Attack.HeroThreads;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class ThreadRaw implements Runnable{
    private ImageView imageView ;
    private TranslateTransition transition ;
    private double x ;
    private double y ;
    public ThreadRaw (ImageView imageView , double x , double y) {
        this.imageView = imageView ;
    }
    @Override
    public void run() {
        System.out.println("i run");
        transition = new TranslateTransition();
        transition.setNode(imageView);
        transition.setDuration(Duration.millis(1000));
        transition.setByX(x);
        transition.setByY(y);
        transition.setCycleCount(1);
        transition.play();
        System.out.println(" i finished");
    }
}

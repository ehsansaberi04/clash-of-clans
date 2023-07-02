package com.example.clashofclans.Attack;

import com.example.clashofclans.Building.ArcherTower;
import com.example.clashofclans.Building.Cannon;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Arc;

import static java.lang.Thread.sleep;


public class ThreadArcherTower implements Runnable{
    private ArcherTower archerTower;
    private ImageView imageView ;
    private boolean alive ;
    public ThreadArcherTower(ArcherTower archerTower , ImageView imageView) {
        this.archerTower = archerTower ;
        this.imageView = imageView ;
        alive = true ;
    }
    @Override
    public void run() {
        while (alive) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
            }
            isAlive();
        }
    }
    public void hurt (double damage) {
        archerTower.setHealth(archerTower.getHealth()-damage);
    }
    private void isAlive () {
        if(archerTower.getHealth() <= 0){
            alive = false ;
        }
    }
}

package com.example.clashofclans.Attack;

import com.example.clashofclans.Building.Cannon;
import javafx.scene.image.ImageView;

import static java.lang.Thread.sleep;


public class ThreadCannon implements Runnable{
    private Cannon cannon ;
    private ImageView imageView ;
    private boolean alive ;
    public ThreadCannon (Cannon cannon , ImageView imageView) {
        this.cannon = cannon ;
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
        cannon.setHealth(cannon.getHealth()-damage);
    }
    private void isAlive () {
        if(cannon.getHealth() <= 0){
            alive = false ;
        }
    }
}

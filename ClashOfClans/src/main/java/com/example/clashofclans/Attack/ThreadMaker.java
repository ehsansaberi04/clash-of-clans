package com.example.clashofclans.Attack;

import com.example.clashofclans.Building.Cannon;
import com.example.clashofclans.Building.Maker;
import javafx.scene.image.ImageView;

import static java.lang.Thread.sleep;


public class ThreadMaker implements Runnable{
    private Maker maker ;
    private ImageView imageView ;
    private boolean alive ;
    public ThreadMaker(Maker maker , ImageView imageView) {
        this.maker = maker ;
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
        maker.setHealth(maker.getHealth()-damage);
    }
    private void isAlive () {
        if(maker.getHealth() <= 0){
            alive = false ;
        }
    }
}

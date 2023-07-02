package com.example.clashofclans.Attack;

import com.example.clashofclans.Building.Cannon;
import com.example.clashofclans.Building.ElixirMaker;
import javafx.scene.image.ImageView;

import static java.lang.Thread.sleep;


public class ThreadElixirMaker implements Runnable{
    private ElixirMaker elixirMaker ;
    private ImageView imageView ;
    private boolean alive ;
    public ThreadElixirMaker(ElixirMaker elixirMaker , ImageView imageView) {
        this.elixirMaker = elixirMaker ;
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
        elixirMaker.setHealth(elixirMaker.getHealth()-damage);
    }
    private void isAlive () {
        if(elixirMaker.getHealth() <= 0){
            alive = false ;
        }
    }
}

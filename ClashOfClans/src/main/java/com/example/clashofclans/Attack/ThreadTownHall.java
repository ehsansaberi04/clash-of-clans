package com.example.clashofclans.Attack;

import com.example.clashofclans.Building.Cannon;
import com.example.clashofclans.Building.TownHall;
import javafx.scene.image.ImageView;

import static java.lang.Thread.sleep;

public class ThreadTownHall implements Runnable{
    private TownHall townHall ;
    private ImageView imageView ;
    private boolean alive ;
    public ThreadTownHall(TownHall townHall , ImageView imageView) {
        this.townHall = townHall ;
        this.imageView = imageView ;
        alive = true ;
    }
    @Override
    public void run() {
        while (townHall.getHealth() > 0) {
            try {
                sleep(100);
            } catch (InterruptedException e) {

            }
        }

    }

}

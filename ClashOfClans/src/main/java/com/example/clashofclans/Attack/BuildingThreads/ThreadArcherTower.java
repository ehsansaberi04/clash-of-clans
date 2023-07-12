package com.example.clashofclans.Attack.BuildingThreads;

import com.example.clashofclans.Attack.War;
import com.example.clashofclans.Model.Building.ArcherTower;
import javafx.scene.image.ImageView;

import static java.lang.Thread.sleep;

public class ThreadArcherTower implements Runnable{
    private ArcherTower archerTower ;
    private ImageView imageView ;
    public ThreadArcherTower(ImageView imageView){
        archerTower = new ArcherTower(imageView) ;
        War.buildings.add(archerTower);
        War.map.put(archerTower , imageView) ;
        this.imageView = imageView ;
    }
    @Override
    public void run() {
        while (isAlive()) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        War.buildings.remove(War.buildings.indexOf(archerTower));
        War.map.get(archerTower).setVisible(false);
        War.map.remove(archerTower) ;
    }
    private boolean isAlive () {
        if(archerTower.getHealth() <= 0 )
            return false ;
        else return true ;
    }






//    -----------------------------

//    private void finding () {
//        double minX = 1000 ;
//        double minY = 1000 ;
//        Army near = null ;
//        double x1 = imageView.getX();
//        double y1 = imageView.getY();
//        double minDistance = 1000;
//        for(Army army : War.armies){
//            double x2 = army.getX();
//            double y2 = army.getY();
//            double distance = distance(x1 , x2 , y1 , y2);
//            if(distance <= minDistance) {
//                minDistance = distance ;
//                near = army ;
//                minX = x2 ;
//                minY = y2 ;
//            }
//        }
//        minX -= x1 ;
//        minY -= y1 ;
//        System.out.println("i found");
//        System.out.println(near.getHealth());
//        if (isAlive()){
//            walking(minX, minY, minDistance, near);
//        } else {
//            imageView.setVisible(false);
//        }
//    }
//    private void walking (double x , double y , double distance , Army target) {
//        if(isAlive()) {
//            System.out.println("i went");
//            attack(target);
//        } else {
//            imageView.setVisible(false);
//        }
//    }
//    private void attack (Army target) {
//        while (target.getHealth() > 0) {
//            if(isAlive()) {
//                System.out.println("i damaged");
//                target.setHealth(target.getHealth() - archerTower.getDamage());
//                try {
//                    sleep((long) (1000 * archerTower.getSpeedDamage()));
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            } else {
//                imageView.setVisible(false);
//            }
//        }
//        if(isAlive()) {
//            finding();
//        } else {
//            imageView.setVisible(false);
//        }
//    }
//    private double distance (double x1 , double x2 , double y1 , double y2) {
//        double distance = sqrt(pow(x1-x2 , 2) + pow(y1-y2 , 2));
//        return distance ;
//    }
}
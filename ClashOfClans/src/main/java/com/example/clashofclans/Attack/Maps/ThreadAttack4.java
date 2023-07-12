package com.example.clashofclans.Attack.Maps;

import com.example.clashofclans.Attack.War;

import static java.lang.Thread.sleep;

public class ThreadAttack4 implements Runnable{
    public boolean attackWinner ;
    private Map4 map ;
    public ThreadAttack4(Map4 map) {
        this.map = map ;
    }

    @Override
    public void run() {
        while (!(endGameH() || endGameB())) {
            setTexts();
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        setAttackWinner();
        showEndGame();
        System.out.println("game end");
    }
    private boolean endGameB () {
        if(War.buildings.size() == 0) {
            return true ;
        } else return false ;
    }
    private boolean endGameH () {
        if(War.armies.size() == 0 && remain()==0) {
            return true ;
        } else return false ;
    }
    private int remain () {
        int remain = Map4.setRemain() ;
        return remain ;
    }
    private void setAttackWinner () {
        if (endGameB()) {
            attackWinner = true ;
            Map4.attackerWinn = true ;
        } else {
            attackWinner = false;
            Map4.attackerWinn = false ;
        }
    }
    private void showEndGame () {
        map.endShow();
    }
    private void setTexts () {
        map.setTexts();
    }
 }

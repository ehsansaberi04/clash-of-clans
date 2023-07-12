package com.example.clashofclans.Attack.Maps;

import com.example.clashofclans.Attack.War;

import static java.lang.Thread.sleep;

public class ThreadAttack1 implements Runnable{
    public boolean attackWinner ;
    private Map1 map ;
    public ThreadAttack1(Map1 map) {
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
        int remain = Map1.setRemain() ;
        return remain ;
    }
    private void setAttackWinner () {
        if (endGameB()) {
            attackWinner = true ;
            Map1.attackerWinn = true ;
        } else {
            attackWinner = false;
            Map1.attackerWinn = false ;
        }
    }
    private void showEndGame () {
        map.endShow();
    }
    private void setTexts () {
        map.setTexts();
    }
 }

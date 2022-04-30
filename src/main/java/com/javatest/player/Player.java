package com.javatest.player;

public class Player {
    private Dice dice;
    private int minNumberForWin;

    public Player(Dice dice, int minNumberForWin) {
        this.dice = dice;
        this.minNumberForWin = minNumberForWin;
    }

    public boolean play(){
        int diceNumber = dice.roll();
        return diceNumber > minNumberForWin;
    }
}

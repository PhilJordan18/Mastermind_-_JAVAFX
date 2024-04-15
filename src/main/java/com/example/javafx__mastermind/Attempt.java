package com.example.javafx__mastermind;

public class Attempt {

    private String attempt;
    private int goodPlaced;
    private int goodButMisplaced;

    public Attempt (String attempt, int goodPlaced, int goodButMisplaced) {
        this.attempt = attempt;
        this.goodPlaced = goodPlaced;
        this.goodButMisplaced = goodButMisplaced;
    }

    @Override
    public String toString() {
        return attempt + " - Bien placé: " + goodPlaced + ", Mal placés: " + goodButMisplaced;
    }
}

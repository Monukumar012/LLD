package com.snakeladder.entity;

import java.util.Random;

public class Dice {
    private int dimension;
    private final Random random;

    public Dice(int dimension) {
        this.dimension = dimension;
        random = new Random();
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int rollDice() {
        return random.nextInt(1, dimension);
    }

}

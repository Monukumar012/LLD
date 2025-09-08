package com.snakeladder.entity;

public class Cell {
    private Jump jump;

    public Jump getJump() {
        return jump;
    }

    public void setJump(Jump jump) {
        this.jump = jump;
    }

    public boolean hasJump() {
        return jump != null;
    }


    @Override
    public String toString() {
        return "Cell{" +
                "jump=" + jump +
                '}';
    }
}

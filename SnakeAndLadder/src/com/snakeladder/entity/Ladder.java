package com.snakeladder.entity;


public class Ladder extends Jump {

    public Ladder(int start, int end) {
        super(start, end);
        if (start >= end) {
            throw new IllegalArgumentException("Ladder start position should be less than end positon: " + start + " and end: " + end);
        }
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

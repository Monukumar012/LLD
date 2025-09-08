package com.snakeladder.entity;

public class Snake extends Jump {

    public Snake(int start, int end) {
        super(start, end);
        if (start <= end) {
            throw new IllegalArgumentException("Snake start position should be greater than end position: " + start + " and end: " + end);
        }
    }


    @Override
    public String toString() {
        return "Snake{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

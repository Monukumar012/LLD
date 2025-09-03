package com.ttt.entity;


import java.util.Optional;

public class Board {
    private int size;
    private int winningCount;
    private int markedCells;
    private Mark[][] cells;

    public Board(int size, int winningCount) {
        this.size = size;
        this.winningCount = winningCount;
        markedCells = 0;
        cells = new Mark[size][size];
    }

    public void markCell(int[] position, Mark mark){
        markCell(position[0], position[1], mark);
    }

    public void markCell(int row, int col, Mark mark){
        if(!isInsideSideBoard(row, col)){
            throw new RuntimeException("Entered position is outside grid : Row = "+ row + " Column = "+col);
        }
        if(cells[row][col] != null){
            throw new RuntimeException("Entered position is already filled with mark: " + cells[row][col]);
        }
        cells[row][col] = mark;
        ++markedCells;
    }

    public String getBoardData(){
        StringBuilder sb = new StringBuilder("\n");
        for(Mark[] row: cells){
            for(Mark mark: row){
                sb.append(mark == null ? "-" : mark).append(" | ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private boolean isInsideSideBoard(int row, int col) {
        return row >= 0 && col >= 0 && row < size && col < size;
    }

    public boolean hasAnyBlankCell() {
        return markedCells < size * size;
    }

    public boolean isWinner(int row, int col, Mark playerMark) {
        return checkDirection(row, col, playerMark, 0, 1)
                || checkDirection(row, col, playerMark, 1, 0)
                || checkDirection(row, col, playerMark, 1, 1)
                || checkDirection(row, col, playerMark, 1, -1);
    }

    private boolean checkDirection(int row, int col, Mark playerMark, int dr, int dc) {
        int cnt = 1;
        int r = row + dr, c = col + dc;
        while(isInsideSideBoard(r, c) && playerMark.equals(cells[r][c])){
            cnt++;
            r += dr; c += dc;
        }
        r = row - dr; c = col - dc;
        while(isInsideSideBoard(r, c) && playerMark.equals(cells[r][c])){
            cnt++;
            r -= dr; c -= dc;
        }
        return cnt >= winningCount;
    }

    public boolean isWinner(int[] position, Mark playerMark) {
        return isWinner(position[0], position[1], playerMark);
    }
}

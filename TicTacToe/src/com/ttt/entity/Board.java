package com.ttt.entity;


public class Board {
    private int size;
    private int winningCount;
    private int markedCells;
    private Mark[][] cells;

    public Board(int size, int winningCount) {
        if (winningCount < 3 || winningCount > size) {
            throw new IllegalArgumentException("Board is not deign for given size: " + size + " and winningCnt: " + winningCount);
        }
        this.size = size;
        this.winningCount = winningCount;
        markedCells = 0;
        cells = new Mark[size][size];
    }

    public void markCell(Position position, Mark mark) {
        markCell(position.getRow(), position.getColumn(), mark);
    }

    public void markCell(int row, int col, Mark mark) {
        if (!isInsideBoard(row, col)) {
            throw new RuntimeException("Entered position is outside grid : Row = " + row + " Column = " + col);
        }
        if (cells[row][col] != null) {
            throw new RuntimeException("Entered position is already filled with mark: " + cells[row][col]);
        }
        cells[row][col] = mark;
        ++markedCells;
    }

    public String getBoardData() {
        StringBuilder sb = new StringBuilder("\n");
        for (Mark[] row : cells) {
            for (Mark mark : row) {
                sb.append(mark == null ? "-" : mark).append(" | ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private boolean isInsideBoard(int row, int col) {
        return row >= 0 && col >= 0 && row < size && col < size;
    }

    public boolean isFull() {
        return markedCells >= size * size;
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
        while (isInsideBoard(r, c) && playerMark.equals(cells[r][c])) {
            cnt++;
            r += dr;
            c += dc;
        }
        r = row - dr;
        c = col - dc;
        while (isInsideBoard(r, c) && playerMark.equals(cells[r][c])) {
            cnt++;
            r -= dr;
            c -= dc;
        }
        return cnt >= winningCount;
    }

    public boolean isWinner(Position position, Mark playerMark) {
        return isWinner(position.getRow(), position.getColumn(), playerMark);
    }

    public Mark getMark(Position position) {
        return cells[position.getRow()][position.getColumn()];
    }


    public boolean isInvalidMove(Position position) {
        return !isInsideBoard(position.getRow(), position.getColumn()) || getMark(position) != null;
    }
}

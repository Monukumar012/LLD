package com.snakeladder.entity;

import java.util.Arrays;

public class Board {
    private Long boardId;
    private Cell[] cells;
    private long boardSize;
    private static Long sequence = 50000L;

    public Board(int boardSize) {
        this.boardId = sequence++;
        this.boardSize = boardSize;
        initializeBoard(boardSize);
    }

    private void initializeBoard(int boardSize) {
        cells = new Cell[boardSize + 1];
        for (int i = 0; i <= boardSize; i++) {
            cells[i] = new Cell();
        }
    }

    public void addSnake(Snake snake) {
        Cell cell = cells[snake.getStart()];
        if (cell.hasJump()) {
            throw new RuntimeException("Cell already have some snake or ladder: " + cell.getJump());
        }
        cell.setJump(snake);
    }

    public void addLadder(Ladder ladder) {
        Cell cell = cells[ladder.getStart()];
        if (cell.hasJump()) {
            throw new RuntimeException("Cell already have some snake or ladder: " + cell.getJump());
        }
        cell.setJump(ladder);
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public long getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(long boardSize) {
        this.boardSize = boardSize;
    }

    public int getUpdatedPosition(int position) {
        Cell cell = cells[position];
        if (cell.hasJump()) {
            return cell.getJump().getEnd();
        }
        return position;
    }
}

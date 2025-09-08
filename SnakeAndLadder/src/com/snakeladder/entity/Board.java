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
        cells = new Cell[boardSize];
        Arrays.fill(cells, new Cell());
    }

    public void addSnake(Snake snake) {
        cells[snake.getStart()].setJump(snake);
    }

    public void addLadder(Ladder ladder) {
        cells[ladder.getStart()].setJump(ladder);
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
        Cell cell = cells[position - 1];
        if (cell.hasJump()) {
            return cell.getJump().getEnd();
        }
        return position;
    }
}

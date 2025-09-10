package com.snakeladder;

import com.snakeladder.controller.GameController;
import com.snakeladder.entity.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Driver {
    private static final Random random = new Random();

    public static void main(String[] args) {
        Queue<Player> players = initializePlayer(4);
        Board board = initializeBoard(100);
        Dice dice = new Dice(6);
        GameController gameController = new GameController(players, board, dice);
        gameController.startGame();
    }

    private static Board initializeBoard(int boardSize) {
        Board board = new Board(boardSize);
        // Add Snakes
        for (int i = 0; i < random.nextInt(1, 4); i++) {
            int snakeEnd = random.nextInt(1,boardSize/3);
            int snakeStart = random.nextInt(snakeEnd+1, boardSize);
            Snake snake = new Snake(snakeStart, snakeEnd);
            board.addSnake(snake);
            System.out.println("Snaked added: "+snake);
        }

        // Add Ladder
        for (int i = 0; i < random.nextInt(1, 3); i++) {
            int ladderStart = random.nextInt(5,boardSize/2);
            int ladderEnd = random.nextInt(ladderStart, boardSize);
            Ladder ladder = new Ladder(ladderStart, ladderEnd);
            board.addLadder(ladder);
            System.out.println("Ladder added: "+ladder);
        }

        return board;
    }

    private static Queue<Player> initializePlayer(int numOfPlayer) {
        Queue<Player> players = new LinkedList<>();
        for (int i = 1; i <= numOfPlayer; i++) {
            players.add(new Player(50000L + i, "Player_" + i));
        }
        return players;
    }
}
package com.snakeladder;

import com.snakeladder.controller.GameController;
import com.snakeladder.entity.Board;
import com.snakeladder.entity.Dice;
import com.snakeladder.entity.Player;

import java.util.LinkedList;
import java.util.Queue;

public class Driver {
    public static void main(String[] args) {
        Queue<Player> players = initializePlayer(2);
        Board board = initializeBoard(20);
        Dice dice = new Dice(6);
        GameController gameController = new GameController(players, board, dice);
        gameController.startGame();
    }

    private static Board initializeBoard(int boardSize) {
        Board board = new Board(boardSize);
        // Add Snakes

        // Add Ladder

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
package com.snakeladder.controller;

import com.snakeladder.entity.Board;
import com.snakeladder.entity.Dice;
import com.snakeladder.entity.Player;
import com.snakeladder.enums.GameState;

import java.util.Queue;

public class GameController {
    private Queue<Player> players;
    private Board board;
    private Dice dice;
    private GameState gameState;
    private final int totalPlayers;

    public GameController(Queue<Player> players, Board board, Dice dice) {
        this.players = players;
        this.board = board;
        this.dice = dice;
        totalPlayers = players.size();
    }

    public void startGame() {
        gameState = GameState.IN_PROGRESS;
        while (gameState == GameState.IN_PROGRESS) {
            Player player = players.poll();
            playTurn(player);
        }
    }

    private void playTurn(Player player) {
        int diceNumber = dice.rollDice();
        int playerTempPosition = diceNumber + player.getPlayerPosition();

        if (isInvalidMove(playerTempPosition)) {
            handleInvalidMove(player, diceNumber);
        } else {
            int updatedPosition = board.getUpdatedPosition(playerTempPosition);
            player.setPlayerPosition(updatedPosition);
            if (isWinningMove(updatedPosition)) {
                handleWin(player);
            } else {
                players.offer(player);
            }
        }
    }

    private void handleWin(Player player) {
        int rank = totalPlayers - players.size();
        System.out.println(player.getPlayerName() + " won with rank " + rank);
        if (players.isEmpty()) {
            gameState = GameState.FINISHED;
        }
    }

    private boolean isWinningMove(int updatedPosition) {
        return updatedPosition == board.getBoardSize();
    }

    private void handleInvalidMove(Player player, int diceNumber) {
        System.out.println(player.getPlayerName() + " rolled " + diceNumber + " but move is invalid.");
        players.offer(player);
    }

    private boolean isInvalidMove(int playerTempPosition) {
        return playerTempPosition > board.getBoardSize();
    }
}

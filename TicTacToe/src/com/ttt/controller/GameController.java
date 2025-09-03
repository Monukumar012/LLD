package com.ttt.controller;

import com.ttt.entity.Board;
import com.ttt.entity.Mark;
import com.ttt.entity.Player;

import java.util.*;

public class GameController {
    private Deque<Player> players;
    private Board board;
    private int totalPlayer;
    private static final Scanner sc = new Scanner(System.in);

    public GameController(int boardSize, int winningCount, int numOfPlayer) {
        this.totalPlayer = numOfPlayer;
        initialize(boardSize, winningCount, numOfPlayer);
    }

    private void initialize(int boardSize, int winningCount, int numOfPlayer) {
        board = new Board(boardSize, winningCount);
        initializePlayers(numOfPlayer);
    }

    private void initializePlayers(int numOfPlayer) {
        players = new ArrayDeque<>();
        for (int i = 0; i < numOfPlayer; i++) {
            Character symbol = (char) ('A' + i);
            Player player = new Player(10000L + i, "Player_" + (i + 1), new Mark(symbol));
            players.add(player);
        }
    }

    public void startGame() {
        System.out.println("Game Start With Players: " + players);
        while (!players.isEmpty()) {
            if (!board.hasAnyBlankCell()) {
                System.out.println("Board Filled Completely");
                System.out.println("Gamed Tied Between Players: "+players);
            }
            Player player = players.poll();
            displayBoard();
            boolean isPlayed = playTurn(player);
            if (!isPlayed) {
                players.addFirst(player);
            }

        }
        System.out.println("Game Ended!");
    }

    private int getCurrentWinnerRank() {
        return totalPlayer - players.size();
    }

    private boolean playTurn(Player player) {
        System.out.println("Player Turn : " + player);
        int[] position = getPositionFromPlayer();
        try {
            board.markCell(position, player.getPlayerMark());
            if (board.isWinner(position, player.getPlayerMark())) {
                System.out.println("Winner : " + getCurrentWinnerRank() + " | " + player);
            } else {
                players.add(player);
            }
            return true;
        } catch (Exception ex) {
            // Handle Exception
            System.out.println(ex.getMessage());
        }
        return false;
    }

    private int[] getPositionFromPlayer() {
        System.out.println("Enter position to mark cell ->");
        System.out.print("Enter row number: ");
        int row = sc.nextInt();
        System.out.print("Enter column number: ");
        int column = sc.nextInt();
        return new int[]{row, column};
    }

    public void displayBoard() {
        System.out.println(board.getBoardData());
    }

}

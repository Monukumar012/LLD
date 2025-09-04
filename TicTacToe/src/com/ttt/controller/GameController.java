package com.ttt.controller;

import com.ttt.entity.Board;
import com.ttt.entity.Player;
import com.ttt.entity.Position;
import com.ttt.enums.GameState;
import com.ttt.moveprovider.MoveProvider;

import java.util.Queue;

public class GameController {
    private Queue<Player> players;
    private Board board;
    private MoveProvider moveProvider;

    public GameController(Board board,
                          Queue<Player> players,
                          MoveProvider moveProvider) {
        this.board = board;
        this.players = players;
        this.moveProvider = moveProvider;
    }


    public void startGame() {
        System.out.println("Game Start With Players: " + players);
        GameState gameState = GameState.RUNNING;
        while (gameState == GameState.RUNNING) {
            Player player = players.peek();
            displayBoard();
            Position position = moveProvider.nextMove(player, board);
            if (board.isInvalidMove(position)) {
                System.out.println("Invalid Move Please Enter correct position!");
                continue;
            }
            players.poll();
            board.markCell(position, player.getPlayerMark());
            if (board.isWinner(position, player.getPlayerMark())) {
                declareWinner(player);
                gameState = GameState.WON;
            } else if (board.isFull()) {
                players.add(player);
                declareTie();
                gameState = GameState.TIE;
            } else {
                players.add(player);
            }
        }
        players.clear();
        System.out.println("Game Ended with : " + gameState);
    }

    private void declareTie() {
        System.out.println("Board Filled Completely");
        System.out.println("Gamed Tied Between Players: " + players);
    }

    private void declareWinner(Player player) {
        System.out.println("Winner Winner : " + player);
    }


    public void displayBoard() {
        System.out.println(board.getBoardData());
    }
}

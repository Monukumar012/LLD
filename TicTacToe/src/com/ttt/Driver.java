package com.ttt;

import com.ttt.controller.GameController;
import com.ttt.entity.Board;
import com.ttt.entity.Mark;
import com.ttt.entity.Player;
import com.ttt.moveprovider.ConsoleMoveProvider;
import com.ttt.moveprovider.MoveProvider;

import java.util.LinkedList;
import java.util.Queue;

public class Driver {
    public static void main(String[] args) {
        Board board = new Board(3, 3);
        Queue<Player> players = getPlayers(2);
        MoveProvider moveProvider = new ConsoleMoveProvider();
        GameController gameController = new GameController(board, players, moveProvider);
        gameController.startGame();
    }

    private static Queue<Player> getPlayers(int numOfPlayer) {
        Queue<Player> players = new LinkedList<>();
        for (int i = 0; i < numOfPlayer; i++) {
            Character symbol = (char) ('A' + i);
            Player player = new Player(10000L + i, "Player_" + (i + 1), new Mark(symbol));
            players.add(player);
        }
        return players;
    }
}

package com.ttt.moveprovider;

import com.ttt.entity.Board;
import com.ttt.entity.Player;
import com.ttt.entity.Position;

import java.util.Scanner;

public class ConsoleMoveProvider implements MoveProvider{
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public Position nextMove(Player player, Board board) {
        System.out.println(player.getPlayerName() + " (" + player.getPlayerMark() + "), enter row and col:");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new Position(row-1, col-1);
    }
}

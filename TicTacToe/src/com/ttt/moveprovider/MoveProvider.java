package com.ttt.moveprovider;

import com.ttt.entity.Board;
import com.ttt.entity.Player;
import com.ttt.entity.Position;

public interface MoveProvider {
    Position nextMove(Player player, Board board);
}

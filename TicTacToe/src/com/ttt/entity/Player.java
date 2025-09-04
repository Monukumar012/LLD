package com.ttt.entity;

import java.util.Objects;

public class Player {
    private final Long playerId;
    private final String playerName;
    private final Mark playerMark;

    public Player(Long playerId, String playerName, Mark playerMark) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerMark = playerMark;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Mark getPlayerMark() {
        return playerMark;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Player player)) return false;
        return Objects.equals(playerId, player.playerId) && Objects.equals(playerName, player.playerName) && playerMark == player.playerMark;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(playerId);
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", playerName='" + playerName + '\'' +
                ", playerMark=" + playerMark +
                '}';
    }
}

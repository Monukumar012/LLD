package com.ttt.entity;

import java.util.Objects;

public class Player {
    private Long playerId;
    private String playerName;
    private Mark playerMark;

    public Player() {
    }

    public Player(Long playerId, String playerName, Mark playerMark) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerMark = playerMark;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Mark getPlayerMark() {
        return playerMark;
    }

    public void setPlayerMark(Mark playerMark) {
        this.playerMark = playerMark;
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

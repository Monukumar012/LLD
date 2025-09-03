package com.ttt;

import com.ttt.controller.GameController;

public class Driver {
    public static void main(String[] args) {
        GameController gameController = new GameController(3, 3, 2);
        gameController.startGame();
    }
}

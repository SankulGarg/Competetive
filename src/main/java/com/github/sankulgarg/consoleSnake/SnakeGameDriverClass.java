package com.github.sankulgarg.consoleSnake;

import java.util.Scanner;

public class SnakeGameDriverClass {
    public static void main(String[] args) {

        System.out.println("Going to start game");
        Cell initPos = new Cell(0, 0);
        Snake initSnake = new Snake(initPos);
        Board board = new Board(10, 10, false);
        board.generateFoodRandomFood();
        Game newGame = new Game(initSnake, board, true);

        Scanner scanner = new Scanner(System.in);
        while (!newGame.isGameOver()) {
            newGame.makeMove(scanner.next().charAt(0));
        }
        newGame.stopAutoMove();
        System.out.println("Game Over");
    }
}

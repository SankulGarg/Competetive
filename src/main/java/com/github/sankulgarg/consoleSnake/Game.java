package com.github.sankulgarg.consoleSnake;

import lombok.Getter;

// To represent Snake Game
public class Game {

    public static final char MOVE_UP = 'w';
    public static final char MOVE_DOWN = 's';
    public static final char MOVE_LEFT = 'a';
    public static final char MOVE_RIGHT = 'd';

    private Snake snake;
    private Board board;

    @Getter
    private boolean gameOver;
    private boolean autoMove;
    private Thread autoMoveThread;
    private char direction = MOVE_RIGHT;

    public Game(Snake snake, Board board, boolean autoMove) {
        this.snake = snake;
        this.board = board;
        this.autoMove = autoMove;
        if (autoMove) {
            autoMoveThread = new Thread(() -> {
                while (autoMove && !gameOver) {
                    try {
                        Thread.sleep(3000);
                        makeMove(direction); // Move the snake in the current direction
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            autoMoveThread.setDaemon(true);
            autoMoveThread.start();
        }
    }

    public void stopAutoMove() {
        autoMove = false;
    }


    // We need to update the game at regular intervals,
    // and accept user input from the Keyboard.
    public void makeMove(char direction) {
        System.out.println("move called with direction: " + direction);
        if (!gameOver) {
            Cell nextCell
                    = board.getNextCell(snake.getHead(), direction);

            if (snake.checkCrash(nextCell) || nextCell == null)
                gameOver = true;
            else {
                boolean isFood = nextCell.getCellType()
                        == CellType.FOOD;
                snake.move(nextCell);
                if (isFood) {
                    board.generateFoodRandomFood();
                }
            }
        }
        board.display();
        this.direction = direction;
    }
}

package com.github.sankulgarg.consoleSnake;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SnakeTest {
    // write test cases for all use cases

    @Test
    public void testSnake_snakeSizeIncrease() {
        // test case for snake size increase
        Snake snake = getSnake();
        Cell cell = new Cell(0, 1);
        cell.setCellType(CellType.FOOD);
        snake.move(cell);
        Assert.assertEquals(snake.getSnakeSize(), 2);
        assertTrue(snake.getHead() == cell);
    }

    private Board getBoard() {
        return new Board(10, 10, false);
    }

    private Snake getSnake() {
        return new Snake(new Cell(0, 0));
    }


}

package com.github.sankulgarg.consoleSnake;

import java.util.Arrays;

public class Board {

    final int ROW_COUNT, COL_COUNT;
    final boolean WALL_BREAK;
    private Cell[][] cells;

    public Board(int rowCount, int columnCount, boolean wallBreak) {
        ROW_COUNT = rowCount;
        COL_COUNT = columnCount;
        WALL_BREAK = wallBreak;

        cells = new Cell[ROW_COUNT][COL_COUNT];
        for (int row = 0; row < ROW_COUNT; row++) {
            for (int column = 0; column < COL_COUNT;
                 column++) {
                cells[row][column] = new Cell(row, column);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }


    public void generateFood(int r, int c) {
		Cell cell = cells[r][c];
        if (cell.getCellType() == CellType.SNAKE_NODE)
            throw new IllegalArgumentException(
                    "Can't place food on snake");
        cell.setCellType(CellType.FOOD);
    }

    public void generateFoodRandomFood() {
        System.out.println("Going to generate food");
        int row = 0, column = 0;
        while (true) {
            row = (int) (Math.random() * ROW_COUNT);
            column = (int) (Math.random() * COL_COUNT);
            if (cells[row][column].getCellType()
                    != CellType.SNAKE_NODE)
                break;
        }
        cells[row][column].setCellType(CellType.FOOD);
        System.out.println("Food is generated at: " + row
                + " " + column);
    }

    public Cell getNextCell(Cell snakeHead, char direction) {
        int row = snakeHead.getRow();
        int col = snakeHead.getCol();

        if (direction == 'd') {
            col++;
        } else if (direction == 'a') {
            col--;
        } else if (direction == 'w') {
            row--;
        } else if (direction == 's') {
            row++;
        }
        if (!WALL_BREAK) {
            if (row == ROW_COUNT) {
                row = 0;
            } else if (row < 0) {
                row = ROW_COUNT - 1;
            }
            if (col == COL_COUNT) {
                col = 0;
            } else if (col < 0) {
                col = COL_COUNT - 1;
            }
        } else {
            if (row == ROW_COUNT || row < 0
                    || col == COL_COUNT || col < 0) {
                System.out.println("Going to crash into wall");
                return null;
            }
        }
        return cells[row][col];
    }

    public void display() {
        System.out.println(Arrays.deepToString(cells)
                .replace("], ", "]\n") // Add newline after each row
                .replace("[[", "[")    // Remove extra brackets
                .replace("]]", "]"));

    }
}

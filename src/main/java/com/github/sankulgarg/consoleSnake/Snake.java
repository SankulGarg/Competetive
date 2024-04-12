package com.github.sankulgarg.consoleSnake;// To represent a snake

import java.util.LinkedList;


public class Snake {

    private LinkedList<Cell> snakePartList
            = new LinkedList<>();
    private Cell head;

    public Snake(Cell initPos) {
        head = initPos;
        snakePartList.add(head);
        head.setCellType(CellType.SNAKE_NODE);
    }

    public void move(Cell nextCell) {
        System.out.println("Snake is moving to "
                + nextCell.getRow() + " "
                + nextCell.getCol());
        if (nextCell.getCellType() != CellType.FOOD) {
            Cell tail = snakePartList.removeLast();
            tail.setCellType(CellType.EMPTY);
        }
        head = nextCell;
        head.setCellType(CellType.SNAKE_NODE);
        snakePartList.addFirst(head);
    }

    public boolean checkCrash(Cell nextCell) {
        for (Cell cell : snakePartList) {
            if (cell == nextCell) {
                System.out.println("Crash with self");
                return true;
            }
        }

        return false;
    }

    public Cell getHead() {
        return head;
    }

	public int getSnakeSize(){
		return snakePartList.size();
	}

}

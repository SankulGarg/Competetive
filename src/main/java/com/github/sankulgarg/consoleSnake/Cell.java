package com.github.sankulgarg.consoleSnake;// To represent a cell of display board

public class Cell {

	private final int row, col;
	private CellType cellType;

	public Cell(int row, int col)
	{
		this.row = row;
		this.col = col;
		this.cellType = CellType.EMPTY;
	}

	public CellType getCellType() { return cellType; }

	public void setCellType(CellType cellType)
	{
		this.cellType = cellType;
	}

	public int getRow() { return row; }

	public int getCol() { return col; }

	@Override
	public String toString()
	{
		switch (cellType) {
		case FOOD:
			return "F";
		case SNAKE_NODE:
			return "*";
		}
		return ".";
	}
}

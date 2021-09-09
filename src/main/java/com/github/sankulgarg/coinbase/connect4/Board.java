package com.github.sankulgarg.coinbase.connect4;

import java.util.Arrays;

public class Board {

	int rows = 6;
	int cols = 7;
	int numOfMoves = 42;
	Piece[][] fields;

	public void show() {

		for (Piece[] row : fields)
			System.out.println(Arrays.toString(row));
	}

	public Board() {

		fields = new Piece[rows][cols];
		for (Piece[] row : fields)
			Arrays.fill(row, Piece.E);

	}

	Move moveAtCol(Player player, int col) throws Exception {

		if (col >= cols)
			throw new Exception("invalid colum number");
		for (int r = 0; r < rows; r++) {
			if (fields[r][col] == Piece.E) {
				fields[r][col] = player.p;
				numOfMoves--;
				return new Move(player, r, col);
			}
		}

		throw new Exception("column is full");

	}

	public boolean isFull() {

		return numOfMoves == 0;
	}

}

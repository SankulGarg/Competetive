package com.github.sankulgarg.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

class ValidSudoku {

	boolean checkBoxes(int boxNo, char[][] board) {
		Set<Character> visited = new HashSet<>();

		int colModifier = boxNo % 3==0?0:boxNo % 3==1?3:6;
		int rowModifier = boxNo < 3 ? 0 : boxNo < 6 ? 3 : 6;

		for (int col = colModifier; col < colModifier + 3; col++) {
			for (int row = rowModifier; row < rowModifier + 3; row++) {
				if (visited.contains(board[row][col]))
					return false;
				else if ((int) board[row][col] > '/')
					visited.add(board[row][col]);
			}
		}

		return true;

	}

	boolean checkRow(int row, char[][] board) {
		Set<Character> visited = new HashSet<>();

		for (int col = 0; col < 9; col++) {
			if (visited.contains(board[row][col]))
				return false;
			else if ((int) board[row][col] > '/')
				visited.add(board[row][col]);
		}

		return true;

	}

	boolean checkCol(int col, char[][] board) {
		Set<Character> visited = new HashSet<>();

		for (int row = 0; row < 9; row++) {
			if (visited.contains(board[row][col]))
				return false;
			else if ((int) board[row][col] > '/')
				visited.add(board[row][col]);
		}

		return true;

	}

	public boolean isValidSudoku(char[][] board) {

		// Check Boxes

		for (int i = 0; i < 9; i++) {
			if (!checkBoxes(i, board) || !checkCol(i, board) || !checkRow(i, board))
				return false;
		}

		// System.out.println("boxTest passes");
		return true;

	}

	public static void main(String[] args) {
		ValidSudoku ob = new ValidSudoku();
		System.out.println(ob.isValidSudoku(new char[][] { { '.', '9', '.', '.', '4', '.', '.', '.', '.' },
				{ '1', '.', '.', '.', '.', '.', '6', '.', '.' }, { '.', '.', '3', '.', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '7', '.', '.', '.', '.', '.' },
				{ '3', '.', '.', '.', '5', '.', '.', '.', '.' }, { '.', '.', '7', '.', '.', '4', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '7', '.', '.', '.', '.' } }));
	}
}
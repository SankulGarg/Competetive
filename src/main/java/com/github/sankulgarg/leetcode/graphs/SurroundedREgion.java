package com.github.sankulgarg.leetcode.graphs;

class SurroundedREgion {
	int directions[][] = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

	private boolean validIndex(int rows, int cols, int r, int c) {
		return (r >= 0 && c >= 0 && r < rows && c < cols);
	}

	public void dfsColor(char[][] board, int r, int c) {
		if (!validIndex(board.length, board[0].length, r, c) || board[r][c] != 'O')
			return;

			board[r][c] = 'S';
		for (int[] dir : directions) {
			int i = r + dir[0];
			int j = c + dir[1];
			dfsColor(board, i, j);
		}

	}

	public void solve(char[][] board) {

		int rows = board.length;
		int cols = board[0].length;

		// topRow
		for (int i = 0; i < cols; i++)
			dfsColor(board, 0, i);

		// bottomRow
		for (int i = 0; i < cols; i++)
			dfsColor(board, r - 1, i);

		// leftCol
		for (int i = 0; i < rows; i++)
			dfsColor(board, i, 0);

		// rightCol
		for (int i = 0; i < rows; i++)
			dfsColor(board, i, cols - 1);

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (board[r][c] == 'O')
					board[r][c] = 'X';
				else if (board[r][c] == 'S')
					board[r][c] = 'O';
			}
		}
	}
}
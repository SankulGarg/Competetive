package com.github.sankulgarg.coinbase.connect4;

public class WinningStrategy {
	
	/* 
	 * Strategy learning previous game
	 * 
	 * Move{
	 * player p;
	 * int numOfOccur;
	 * int win;
	 * }
	 * step 1: create a hassKey representing board state
	 * step 2: save data as key vale
	 * key: hash
	 * val: PriorityQueue<Moves> made on that state
	 * 
	 * 
	 * 
	 * 
	 * */
	
	public static boolean checkWinningMove(Board board, Move move) {

		return checkVertical(board, move) || checkHorizontal(board, move) || checkForwardDiagnal(board, move)
				|| checkBackwordDiagnal(board, move);
	}

	private static boolean checkBackwordDiagnal(Board board, Move move) {
		int count = 0;
		int currCol = move.c;
		int currRow = move.r;

		// go downRight
		while (currRow >= 0 && currCol < board.cols && board.fields[move.r][currCol] == move.player.p) {
			currRow--;
			currCol++;
			count++;
		}

		currCol = move.c;
		currRow = move.r;
		// go topLeft
		while (currCol >= 0 && currRow < board.rows && board.fields[move.r][currCol] == move.player.p) {
			currRow++;
			currCol--;
			count++;
		}

		count--;
		return count >= 4;
	}

	private static boolean checkForwardDiagnal(Board board, Move move) {
		int count = 0;
		int currCol = move.c;
		int currRow = move.r;

		// do downLeft
		while (currRow >= 0 && currCol >= 0 && board.fields[move.r][currCol] == move.player.p) {
			count++;
			currRow--;
			currCol--;
		}
		currCol = move.c;
		currRow = move.r;
		// go topRight
		while (currRow < board.rows && currCol < board.cols && board.fields[move.r][currCol] == move.player.p) {
			count++;
			currRow++;
			currCol++;
		}
		count--;

		return count >= 4;
	}

	private static boolean checkHorizontal(Board board, Move move) {
		int count = 0;
		int currCol = move.c;
		// go left
		while (currCol >= 0 && board.fields[move.r][currCol] == move.player.p) {
			count++;
			currCol--;
		}
		currCol = move.c;
		while (currCol < board.cols && board.fields[move.r][currCol] == move.player.p) {
			count++;
			currCol++;
		}
		count--;
		return count >= 4;
	}

	private static boolean checkVertical(Board board, Move move) {
		int count = 0;
		for (int r = move.r; r >= 0; r--) {
			if (board.fields[r][move.c] == move.player.p)
				count++;
			else
				break;
		}

		return count >= 4;
	}

}

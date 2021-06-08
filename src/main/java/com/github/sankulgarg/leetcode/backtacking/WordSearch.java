package com.github.sankulgarg.leetcode.backtacking;

class WordSearch {
	boolean isVisted[][];

	private boolean isSol(char[][] board, String word, String curr, int i, int j) {

		if (word.equals(curr))
			return true;

		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(curr.length())
				|| isVisted[i][j])
			return false;

		isVisted[i][j] = true;
		curr += board[i][j];


		 if(isSol(board, word, curr, i+1, j) ||
				 isSol(board, word, curr, i-1, j) ||
				 isSol(board, word, curr, i, j+1) ||
				 isSol(board, word, curr, i, j-1)) 
           return true;
       isVisted[i][j]=false;
       return false;

	}

	public boolean exist(char[][] board, String word) {
		isVisted = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++) {
				
				if (isSol(board, word, "", i, j))
					return true;
			}
		return false;

	}
}
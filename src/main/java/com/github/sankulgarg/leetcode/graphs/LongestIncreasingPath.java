package com.github.sankulgarg.leetcode.graphs;

class LongestIncreasingPath {
	int cache[][];
	int rows = 0;
	int colmns = 0;
	static final int[][] DIRECTIONS = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public int longestIncreasingPath(int[][] matrix) {
		rows = matrix.length;
		colmns = matrix[0].length;

		cache = new int[rows][colmns];
		int maxLength = 0;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < colmns; c++) {
				maxLength = Math.max(maxLength, dfs(matrix, r, c));
			}
		}
		return maxLength;
	}

	int dfs(int[][] matrix, int r, int c) {
		if (cache[r][c] > 0)
			return cache[r][c];

		// just include this cell
		int maxIncreasingLengthPath = 1;
		for (int[] dir : DIRECTIONS) {
			int adjRow = r + dir[0];
			int adjCol = c + dir[1];

			// outside the grid, ignore it
			if (adjRow < 0 || adjRow >= rows || adjCol < 0 || adjCol >= colmns)
				continue;
			// not greater than current cell, ignore it
			if (matrix[adjRow][adjCol] <= matrix[r][c])
				continue;

			maxIncreasingLengthPath = Math.max(maxIncreasingLengthPath, dfs(matrix, adjRow, adjCol) + 1);

		}
		cache[r][c] = maxIncreasingLengthPath;
		return maxIncreasingLengthPath;
	}

}
package com.github.sankulgarg.leetcode.trees;

class NumIslands {
	public int numIslands(char[][] grid) {

		int island = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					island++;
					markIsland(grid, i, j);

				}
			}

		}
		return island;
	}

	private void markIsland(char[][] grid, int i, int j) {
		if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
			grid[i][j] = '0';
			markIsland(grid, i, j + 1);
			markIsland(grid, i, j - 1);
			markIsland(grid, i + 1, j);
			markIsland(grid, i - 1, j);
		}
	}
}
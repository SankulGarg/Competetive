package com.github.sankulgarg.leetcode.arrays;

class SetZeroes {
	public void setZeroes(int[][] matrix) {

		boolean fROw = false;
		boolean fCol = false;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				
				if (matrix[i][j] == 0) {
					if(j==0)
						fCol=true;
					if(i==0)
						fROw=true;
					matrix[0][j] = 0;
					matrix[i][0] = 0;

				}
			}
		}

		for (int i = 1; i < matrix.length; i++)
			for (int j = 1; j < matrix[0].length; j++)
				if (matrix[i][0] == 0 || matrix[0][j] == 0)
					matrix[i][j] = 0;

		// updateIst row
		if (fROw)
			for (int i = 0; i < matrix[1].length; i++)
				matrix[0][i] = 0;

		// updateIst col
		if (fCol)
			for (int i = 0; i < matrix.length; i++)
				matrix[i][0] = 0;

	}

	public static void main(String[] args) {
		new SetZeroes().setZeroes(new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } });
	}

}
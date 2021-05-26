package com.github.sankulgarg.leetcode.arrays;

import java.util.Arrays;

class RotateImage {

	public void rotate(int[][] matrix) {
	
	
		int n= matrix[0].length;
		int temp=0;
		for(int i=0;i<(n+1)/2;i++) {
			for(int j=0;j<(n)/2;j++) {
				temp=matrix[i][j];
				matrix[i][j]=matrix[n-1-j][i];
				matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
				matrix[j][n-1-i]=temp;
				System.out.println(Arrays.deepToString(matrix));
				
			}
		}
		
		System.out.println(Arrays.deepToString(matrix));
	
	}
	public static void main(String[] args) {
		RotateImage ob=new RotateImage();
		ob.rotate(new int[][] {{1,2,3},{4,5,6},{7,8,9}});
	}
}
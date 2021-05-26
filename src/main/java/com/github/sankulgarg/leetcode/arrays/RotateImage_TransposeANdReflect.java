package com.github.sankulgarg.leetcode.arrays;

import java.util.Arrays;

class RotateImage_TransposeANdReflect {

	public void rotate(int[][] matrix) {
	
	
		int n= matrix[0].length;
		
		//transpose
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				int temp=matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=temp;
				
			}
		}
		
		//reflect
		for(int i=0;i<n;i++) {
			for(int j=0;j<n/2;j++) {
			
				int temp=matrix[i][j];
				matrix[i][j]=matrix[i][n-j-1];
				matrix[i][n-j-1]=temp;
			}}
		
		System.out.println(Arrays.deepToString(matrix));
	
	}
	public static void main(String[] args) {
		RotateImage_TransposeANdReflect ob=new RotateImage_TransposeANdReflect();
		ob.rotate(new int[][] {{1,2,3},{4,5,6},{7,8,9}});
	}
}
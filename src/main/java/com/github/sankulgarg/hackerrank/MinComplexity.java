package com.github.sankulgarg.hackerrank;

public class MinComplexity {

	int findMinComplexity(int[] arr,int days) {

		int minComplexity = 0;
		
		for(int i=0;i<arr.length;i++) {
			
		}

		return 0;
	}

	int minComplexity(int daysLeft,int arr[],int complexity,int ind) {
		if(daysLeft==0&&ind==arr.length) {
			return complexity;
		}
		else if(daysLeft>0&&ind==arr.length)
			return Integer.MAX_VALUE;
		else if(daysLeft==0&&ind<arr.length)
			return Integer.MAX_VALUE;
		
		for(int i=ind;i<arr.length;i++) {
			//include in a prev group
			
		}
		return ind;
		
	}
}

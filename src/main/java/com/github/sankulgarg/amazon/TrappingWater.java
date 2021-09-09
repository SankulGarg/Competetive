package com.github.sankulgarg.amazon;

class TrappingWater {

	// arr: input array
	// n: size of array
	// Function to find the trapped water between the blocks.

	static int findRigthMax(int ind, int arr[]) {
		int rightMaxIndex = ind;
		int rightMax = arr[ind];
		for (int i = ind; i < arr.length; i++) {
			if (arr[i] > rightMax) {
				rightMaxIndex = i;
				rightMax = arr[i];
			}

		}
		return rightMaxIndex;
	}

	static int trappingWater(int arr[], int n) {
		int leftMax = arr[0];
		int waterTrapped = 0;
		int rightMaxIndex = findRigthMax(1, arr);
		int rightMax = arr[rightMaxIndex];

		for (int i = 1; i < arr.length - 1; i++) {

			if (rightMaxIndex <= i) {
				rightMaxIndex = findRigthMax(i, arr);
				rightMax = arr[rightMaxIndex];

			}
			int waterBucket = Math.min(rightMax, leftMax) - arr[i];
			if (waterBucket > 0)
				waterTrapped += waterBucket;

			if (arr[i] > leftMax)
				leftMax = arr[i];

		}
		return waterTrapped;
	}

	public static void main(String[] args) {
		trappingWater(new int[] { 1, 1, 5, 2, 7, 6, 1, 4, 2, 3 }, 10);
	}
}

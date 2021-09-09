package com.github.sankulgarg.leetcode.sortingAndSearching;

class MinPatches {
	public int minPatches(int[] nums, int n) {

		int patches = 0, ind = 0;
		long coveredTill = 1l;
		while (coveredTill <= n) {
			if (ind < nums.length && nums[ind] <= coveredTill) {
				coveredTill += nums[ind++];
			} else {
				patches++;
				coveredTill += coveredTill;
			}
		}
		return patches;
	}

	public static void main(String[] args) {
		System.out.println(new MinPatches().minPatches(new int[] { 1, 5, 10 }, 20));
	}
}
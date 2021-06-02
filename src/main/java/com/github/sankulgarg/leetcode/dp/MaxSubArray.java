package com.github.sankulgarg.leetcode.dp;

class MaxSubArray {
	public int maxSubArray(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0];

		int maxEnding = nums[0], res = nums[0];

		for (int i = 1; i < n; i++) {
			maxEnding = Math.max(maxEnding + nums[i], nums[i]);
			res = Math.max(res, maxEnding);
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(new MaxSubArray().maxSubArray(new int[] { 8, -19, 5, -4, 20 }));
	}
}
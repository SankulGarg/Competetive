package com.github.sankulgarg.leetcode.arrays;

class SingleNumber2 {
	public int singleNumber(int[] nums) {
		int ones = 0, twos = 0, threes = 0;

		for (int i = 0; i < nums.length; i++) {
			// twos holds the num that appears twice
			twos |= ones & nums[i];

			// ones holds the num that appears once
			ones ^= nums[i];

			// threes holds the num that appears three times
			threes = ones & twos;

			// if num[i] appears three times
			// doing this will clear ones and twos
			ones &= ~threes;
			twos &= ~threes;
		}

		return ones;
	}
	public static void main(String[] args) {
		SingleNumber2 sol=new SingleNumber2();
		System.out.println(sol.singleNumber(new int[] {1,1,2,1,3,3,3}));
	}

}
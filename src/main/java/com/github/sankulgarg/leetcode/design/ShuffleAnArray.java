package com.github.sankulgarg.leetcode.design;

import java.util.Arrays;
import java.util.Random;

class ShuffleAnArray {
	private int[] original;
	private int[] shuffled;
	Random random;

	public ShuffleAnArray(int[] nums) {
		random = new Random();
		original = Arrays.copyOf(nums, nums.length);
		shuffled = Arrays.copyOf(nums, nums.length);
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return original;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int randomInd = 0;
		for (int i = 0; i < shuffled.length; i++) {
			randomInd = random.nextInt(shuffled.length);
			swap(shuffled, randomInd, i);
			break;
		}

		return shuffled;
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}

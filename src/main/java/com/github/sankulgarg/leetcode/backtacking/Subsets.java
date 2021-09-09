package com.github.sankulgarg.leetcode.backtacking;

import java.util.ArrayList;
import java.util.List;

class Subsets {

	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {

		subSet(new ArrayList<>(), nums, 0);
		return result;

	}

	private void subSet(List<Integer> subset, int[] nums, int ind) {
		System.out.println("subset added every traversal "+ subset);
		result.add(new ArrayList<>(subset));

		for (int i = ind; i < nums.length; i++) {

			subset.add(nums[i]);

			subSet(subset, nums, i + 1);
			subset.remove(subset.size() - 1);
			System.out.println("subset removal every traversal "+ subset);
		}
	}

	public static void main(String[] args) {
		System.out.println(new Subsets().subsets(new int[] { 1, 2, 3 }));
	}
}
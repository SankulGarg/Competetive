package com.github.sankulgarg.leetcode.arrays;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TwoSums {
	public int[] twoSum(int[] nums, int target) {

		Map<Integer, List<Integer>> lookup = IntStream.range(0, nums.length).boxed()
				.collect(Collectors.groupingBy(e -> nums[e]));

		for (Map.Entry<Integer, List<Integer>> entry : lookup.entrySet()) {
			int num1 = entry.getKey();
			List<Integer> indexes = entry.getValue();
			if (target == 2 * num1 && indexes.size() >= 2)
				return new int[] { indexes.get(0), indexes.get(1) };

			else if (lookup.containsKey(target - num1))
				return new int[] { indexes.get(0), lookup.get(target - num1).get(0) };

		}

		return nums;

	}

	public static void main(String[] args) {

		TwoSums twoSums = new TwoSums();
		twoSums.twoSum(new int[] { 3, 2, 4 }, 6);
	}
}
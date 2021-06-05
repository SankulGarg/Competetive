package com.github.sankulgarg.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		
		Set<List<Integer>> triplets = new HashSet<>();
		Map<Integer, Integer> mapMaxOcc = IntStream.range(0, nums.length).boxed()
				.collect(Collectors.toMap(x -> nums[x], Function.identity(), (o1, o2) -> o2>01?o2:o1));

		for (int i = 0; i < nums.length - 2; i++) {

			for (int j = i + 1; j < nums.length - 1; j++) {
				int targetSum = -1 * (nums[i] + nums[j]);
				if (mapMaxOcc.containsKey(targetSum) && mapMaxOcc.get(targetSum) > j)
					triplets.add(Arrays.asList(nums[i], nums[j], targetSum));

			}
		}

		return new ArrayList<>(triplets);
	}

	public static void main(String[] args) {
		new ThreeSum().threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
	}
}
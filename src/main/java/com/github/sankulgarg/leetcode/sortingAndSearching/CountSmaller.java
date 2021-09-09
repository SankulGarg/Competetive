package com.github.sankulgarg.leetcode.sortingAndSearching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CountSmaller {
	public List<Integer> countSmaller(int[] nums) {
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int num : nums) {
			frequencyMap.putIfAbsent(num, 0);
			if (min > num)
				min = num;
			if (max < num)
				max = num;
			frequencyMap.put(num, frequencyMap.get(num) + 1);
		}
		int last = 0;
		for (int key = min; key <= max; key++) {

			if (frequencyMap.containsKey(key)) {
				int temp = frequencyMap.get(key);
				frequencyMap.put(key, last);
				last += temp;
			}
		}
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++)
			result.add(frequencyMap.get(nums[i]));

		return result;
	}
}
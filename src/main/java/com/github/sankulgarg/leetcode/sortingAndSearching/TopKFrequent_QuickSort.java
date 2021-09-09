package com.github.sankulgarg.leetcode.sortingAndSearching;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TopKFrequent_QuickSort {

	public int[] topKFrequent(int[] nums, int k) {

		Map<Integer, Long> frequencyMap = IntStream.range(0, nums.length).boxed()
				.collect(Collectors.groupingBy(i -> nums[i], Collectors.counting()));

		//TO:DO 
		return null;

	}
}
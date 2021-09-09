package com.github.sankulgarg.leetcode.sortingAndSearching;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TopKFrequent_Heap {

	public int[] topKFrequent(int[] nums, int k) {

		Map<Integer, Long> frequencyMap = IntStream.range(0, nums.length).boxed()
				.collect(Collectors.groupingBy(i -> nums[i], Collectors.counting()));

		PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparing(frequencyMap::get));
		PriorityQueue<Integer> minHeap2 = new PriorityQueue<>(k, Comparator.reverseOrder());
		for (int num : frequencyMap.keySet()) {
			minHeap.offer(num);
			if (minHeap.size() > k)
				minHeap.poll();
		}

		return minHeap.stream().mapToInt(x -> x).toArray();

	}
}
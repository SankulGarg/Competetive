package com.github.sankulgarg.leetcode.sortingAndSearching;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class MaxSlidingWindow {
	public int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> q = new ArrayDeque<>(); // stores *indices*
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
				q.removeLast();
			}
			q.addLast(i);
			// remove first element if it's outside the window
			if (q.getFirst() == i - k) {
				q.removeFirst();
			}
			// if window has k elements add to results (first k-1 windows have < k elements
			// because we start from empty window and add 1 element each iteration)
			if (i >= k - 1) {
				res.add(nums[q.peek()]);
			}
		}
		return res.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {
		new MaxSlidingWindow().maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3);
	}
}
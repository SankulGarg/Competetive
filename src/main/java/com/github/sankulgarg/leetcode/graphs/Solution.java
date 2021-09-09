package com.github.sankulgarg.leetcode.graphs;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public boolean canReach(int[] arr, int start) {

		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		boolean visited[] = new boolean[arr.length];
		while (!queue.isEmpty()) {

			int currInd = queue.poll();
			if (visited[currInd])
				continue;
			if (arr[currInd] == 0)
				return true;
			else {

				visited[currInd] = true;
				int startIndex = currInd - arr[currInd];
				int endIndex = currInd + arr[currInd];
				if (startIndex >= 0 && !visited[startIndex])
					queue.add(startIndex);
				if (endIndex < arr.length && !visited[endIndex])
					queue.add(endIndex);

			}
		}
		return false;
	}

	public static void main(String[] args) {
		new Solution().canReach(new int[] { 4, 2, 3, 0, 3, 1, 2 }, 5);
	}
}
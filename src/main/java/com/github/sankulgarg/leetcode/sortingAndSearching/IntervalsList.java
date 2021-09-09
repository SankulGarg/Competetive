package com.github.sankulgarg.leetcode.sortingAndSearching;

import java.util.ArrayList;
import java.util.List;

class IntervalsList {
	public int[][] insert(int[][] intervals, int[] newInterval) {

		List<int[]> intervalsList = new ArrayList<>();
		boolean merge=false;
		for (int[] top : intervals) {

			intervalsList.add(top);

			if ((newInterval[0] >= top[0] && newInterval[0] <= top[1])
					|| (newInterval[1] >= top[0] && newInterval[1] <= top[1])
					|| (newInterval[0]) < top[0] && newInterval[1] > top[1]) {
				// merge
				top[0] = Math.min(top[0], newInterval[0]);
				top[1] = Math.max(top[1], newInterval[1]);
				merge=true;
				newInterval = top;
			} else if (!merge && top[0] > newInterval[1])
				intervalsList.add(newInterval);

		}

		int[][] sol = new int[intervalsList.size()][2];
		for (int i = 0; i < intervalsList.size(); i++)
			sol[i] = intervalsList.get(i);
		return sol;

	}

	/*
	 * [[1,3],[6,9]] [2,5]
	 */
	public static void main(String[] args) {
		new IntervalsList().insert(new int[][] { { 1, 3 }, { 6, 9 } }, new int[] { 2, 5 });
	}
}
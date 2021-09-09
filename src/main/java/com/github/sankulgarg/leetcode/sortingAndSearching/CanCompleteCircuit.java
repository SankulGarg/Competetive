package com.github.sankulgarg.leetcode.sortingAndSearching;

import java.util.stream.IntStream;

class CanCompleteCircuit {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int n = gas.length;
		// check negative case
		int totalGas = IntStream.range(0, n).boxed().mapToInt(ind -> gas[ind]).sum();
		int totalCost = IntStream.range(0, n).boxed().mapToInt(ind -> cost[ind]).sum();

		if (totalCost > totalGas)
			return -1;

		totalGas = gas[0] - cost[0];
		int sol = 0;
		for (int i = 1; i < n; i++) {

			if (totalGas < 0) {
				sol = i;
				totalGas = gas[i] - cost[i];
			} else
				totalGas += gas[i] - cost[i];
		}
		return sol;
	}

	public static void main(String[] args) {
		new CanCompleteCircuit().canCompleteCircuit(new int[] { 5, 1, 2, 3, 4 }, new int[] { 4, 4, 1, 5, 1 });
	}
	/* [5,1,2,3,4][4,4,1,5,1] */

}
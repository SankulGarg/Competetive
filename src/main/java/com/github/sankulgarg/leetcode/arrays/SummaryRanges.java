package com.github.sankulgarg.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<>();

		int prev = nums[0];
		int initial = 0;
		StringBuilder row = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			if (row.length() == 0) {
				row.append(nums[i]);
				prev = nums[i];
				initial = nums[i];
				continue;
			}
			if (nums[i] - 1 == prev) {
				prev = nums[i];
			} else {
				if (prev != initial)
					row.append("->").append(prev);
				result.add(row.toString());
				row = new StringBuilder();
				i--;
			}

		}
		if (prev != initial)
			row.append("->").append(prev);
		result.add(row.toString());
		return result;
	}

	public static void main(String[] args) {
		new SummaryRanges().summaryRanges(new int[] { 0, 2, 3, 4, 6, 8, 9 });
	}
}
package com.github.sankulgarg.leetcode.sortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

		List<List<Integer>> result = new ArrayList<>();
		int i = 0;
		int j = 0;

		while (k > 0) {
			try {
				result.add(Arrays.asList(nums1[i], nums2[j]));
				if (i + 1 >= nums1.length)
					j++;
				else if (j + 1 >= nums2.length)
					i++;
				else if (nums1[i + 1] > nums2[j + 1])
					j++;
				else
					i++;
				k--;
			} catch (Exception e) {
				break;
			}

		}
		return result;

	}

	public static void main(String[] args) {
		new Solution().kSmallestPairs(new int[] { 1, 2 }, new int[] { 3 }, 3);
	}
}
package com.github.sankulgarg.leetcode.sortingAndSearching;

class mergeSortedArray_nXm {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if (m == 0) {

			for (int ii = 0; ii < nums2.length; ii++)
				nums1[ii] = nums2[ii];
			return;
		}
		for (int i = m; i < nums1.length; i++) {
			nums1[i] = Integer.MAX_VALUE;
		}

		int i = 0;
		int j = 0;
	
		while (i < nums1.length && j < nums2.length) {

			if ( nums1[i] <= nums2[j])
				i++;

			else {

				rightShiftAfterIndex(nums2[j], nums1, i);
				j++;
				i++;

			}
		}
		
	}

	private void rightShiftAfterIndex(int newNumber, int[] nums, int ind) {

		for (int i = ind; i < nums.length; i++) {

			int temp = nums[i];
			nums[i] = newNumber;
			newNumber = temp;

		}

	}

	public static void main(String[] args) {
		new mergeSortedArray_nXm().merge(new int[] { -11, 0, 3, 0, 0, 0 }, 3, new int[] { 4, 5, 6 }, 3);
	}
}
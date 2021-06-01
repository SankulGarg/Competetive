package com.github.sankulgarg.leetcode.sortingAndSearching;

class mergeSortedArray_nPlusm {
	public void merge(int[] nums1, int m, int[] nums2, int n) {

		--m;
		--n;
		int i = nums1.length - 1;
		while (m >= 0 && n >= 0) {
			if (nums1[m] > nums2[n]) {
				nums1[i] = nums1[m];
				m--;
			} else {
				nums1[i] = nums2[n];
				n--;
			}
			i--;

		}
		while (n >= 0) {
			nums1[i--] = nums2[n--];
		}

	}

	public static void main(String[] args) {
		new mergeSortedArray_nPlusm().merge(new int[] { -11, 0, 3, 0, 0, 0 }, 3, new int[] { 4, 5, 6 }, 3);
	}
}
package com.github.sankulgarg.leetcode.arrays;

class FindMedianSortedArrays {
	public double findMedianSortedArrays(int[] a, int[] b) {
		if (a.length > b.length)
			return findMedianSortedArrays(b, a);

		int x = a.length;
		int y = b.length;

		int low = 0, high = x;

		while (low <= high) {
			int px = low + (high - low) / 2;
			int py = (x + y + 1) / 2 - px;

			int aLeft = (px == 0) ? Integer.MIN_VALUE : a[px - 1];
			int aRight = (px == x) ? Integer.MAX_VALUE : a[px]; // includes

			int bLeft = (py == 0) ? Integer.MIN_VALUE : b[py - 1];
			int bRight = (py == y) ? Integer.MAX_VALUE : b[py];

			if (aLeft <= bRight && bLeft <= aRight) {
				if ((x + y) % 2 == 0) {
					return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
				} else {
					return (double) Math.max(aLeft, bLeft);
				}
			} else if (aLeft > bRight) { // check on left
				high = px - 1;
			} else // check on right
				low = px + 1;
		}
		throw new IllegalArgumentException();
	}
}
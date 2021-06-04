package com.github.sankulgarg.leetcode.math;

class IsPowerOfThree_specialSol {
	public boolean isPowerOfThree(int n) {
		if (n <= 0) {
			return false;
		}
// since max number in integer range that is power of 3 is 1162261467
		return 1162261467 % n == 0;
	}
}
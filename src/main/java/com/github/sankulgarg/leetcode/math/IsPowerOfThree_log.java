package com.github.sankulgarg.leetcode.math;

class IsPowerOfThree_log {
	public boolean isPowerOfThree(int n) {
		if (n <= 0)
			return false;
		int res = (int) Math.round(Math.log10(n) / Math.log10(3)); // log (n) =log(n)/log(k)

		return (Math.pow(3, res) == n);
	}
	
	public static void main(String[] args) {
		

		new IsPowerOfThree_log().isPowerOfThree(9);
	}
}
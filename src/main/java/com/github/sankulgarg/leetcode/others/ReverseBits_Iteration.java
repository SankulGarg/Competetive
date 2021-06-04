package com.github.sankulgarg.leetcode.others;

public class ReverseBits_Iteration {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {

		int result = 0;
		int i = 0;

		while (i <= 31) {
			int lsb = n & 1; // last bit from right; // we can also use n % 2

			// left shift it by 31-i places

			lsb = lsb << (31 - i);

			result = result + lsb; // you can also use n |lsb ;
			// shift it to right by 1 time so that we always get ith bit from right
			n = n >> 1;

			i++;
		}
		return result;
		
	}

	public static void main(String[] args) {
		System.out.println(new ReverseBits_Iteration().reverseBits(964176192));
	}
}
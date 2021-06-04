package com.github.sankulgarg.leetcode.others;


public class ReverseBits_ExistingIntegerMethod {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		return Integer.reverse(n);
		

	}

	public static void main(String[] args) {

		System.out.println(new ReverseBits_ExistingIntegerMethod().reverseBits(964176192));
	}
}
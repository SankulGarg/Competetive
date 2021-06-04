package com.github.sankulgarg.leetcode.others;

public class HammingWeight {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		return hammingWeightUsingBitCount(n);

	}

	public int hammingWeightUsingBitCount(int n) {
		return Integer.bitCount(n);

	}

	public int hammingWeightUsingBinaryString(int n) {
		String binaryString = Integer.toBinaryString(n);
		return binaryString.chars().map(x -> x - '0').sum();

	}
}
package com.github.sankulgarg.leetcode.others;

public class ReverseBits_byByte {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		int i = 24;
		int result = 0;
		while (i >=0 ) {
			int lastByte = n & 0xff;// you can also use 255: 11111111=255 in unsigned and -1 in signed
			lastByte = reverseByte(lastByte);

			// left shift the byte by
			lastByte = lastByte << (i);

			result += lastByte;

			n = n >> 8;
			i -= 8;
		}
		return result;
	}

	private int reverseByte(int byteN) {
		/*
		 * The algorithm is documented as "reverse the bits in a byte with 3 operations"
		 * on the online book called Bit Twiddling Hacks by Sean Eron Anderson, where
		 * one can find more details.
		 */
		return (int) ((byteN * 8623620610l & 1136090292240l) % 1023);

	}

	public static void main(String[] args) {


		System.out.println(new ReverseBits_byByte().reverseBits(964176192));
	}
}
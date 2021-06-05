package com.github.sankulgarg.leetcode.arrays;

class LongestPalindrome {
	private String longestPalindrome(String s, int i, int j) {

		while (i >= 0 && j < s.length() && s.charAt(j) == s.charAt(i)) {
			i--;
			j++;
		}

		return s.substring(i + 1, j);

	}

	public String longestPalindrome(String s) {
		String longestPalindrome = "";
		String palindrome = "";

		for (int i = 0; i < s.length() - 1; i++) {

			palindrome = longestPalindrome(s, i, i); // odd
			longestPalindrome = longestPalindrome.length() > palindrome.length() ? longestPalindrome : palindrome;
			palindrome = longestPalindrome(s, i, i + 1);
			longestPalindrome = longestPalindrome.length() > palindrome.length() ? longestPalindrome : palindrome;

		}
		return longestPalindrome;
	}

	public static void main(String[] args) {
		System.out.println(new LongestPalindrome().longestPalindrome("cbbbbd"));
	}
}
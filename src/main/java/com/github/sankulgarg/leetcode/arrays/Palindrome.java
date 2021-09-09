package com.github.sankulgarg.leetcode.arrays;

public class Palindrome {

	public boolean isPalindrome(String sentence) {

		int start = 0;
		int end = sentence.length() - 1;
		sentence = sentence.toLowerCase();
		while (start < end) {
			if (!Character.isLetterOrDigit(sentence.charAt(start))) {
				start++;
				continue;
			}
			if (!Character.isLetterOrDigit(sentence.charAt(end))) {
				end--;
				continue;
			}

			if (sentence.charAt(start) != sentence.charAt(end))
				return false;

			else {
				start++;
				end--;
			}

		}

		return true;

	}

	public static void main(String[] args) {
		System.out.println(new Palindrome().isPalindrome("A man, a plan, a canal: Panama"));
	}

}

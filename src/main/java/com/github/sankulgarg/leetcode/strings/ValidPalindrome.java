package com.github.sankulgarg.leetcode.strings;

class ValidPalindrome {
	public boolean isPalindrome(String s) {

		int i = 0;
		int j = s.length() - 1;

		s = s.toLowerCase();
		while (i < j) {
			char l = s.charAt(i);
			char r = s.charAt(j);
			if (!Character.isLetterOrDigit(s.charAt(i)))
				i++;

			else if (!Character.isLetterOrDigit(s.charAt(j)))
				j--;

			else if (l != r)
				return false;

			else {
				i++;
				j--;
			}

		}
		return true;
	}

	public static void main(String[] args) {
		ValidPalindrome sol = new ValidPalindrome();
		System.out.println(sol.isPalindrome("OP"));
	}
}
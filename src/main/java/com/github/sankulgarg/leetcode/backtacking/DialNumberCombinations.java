package com.github.sankulgarg.leetcode.backtacking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DialNumberCombinations {
	private static final String[] DIGIT_CHARS = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv",
			"wxyz" };

	private void combinations(String prefix, List<String> combinations, int ind, String digits) {
		if (prefix.length() == digits.length()) {
			combinations.add(prefix);
			return;

		}
		String letter = DIGIT_CHARS[digits.charAt(ind) - '0'];

		for (char c : letter.toCharArray()) {
			combinations(prefix + c, combinations, ind + 1, digits);
		}

	}

	public List<String> letterCombinations(String digits) {

		if (digits.length() == 0)
			return Collections.emptyList();
		List<String> combinations = new ArrayList<>();
		combinations("", combinations, 0, digits);

		return combinations;

	}

	public static void main(String[] args) {
		System.out.println(new DialNumberCombinations().letterCombinations("234"));
	}
}
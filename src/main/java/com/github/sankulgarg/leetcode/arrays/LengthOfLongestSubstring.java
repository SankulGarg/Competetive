package com.github.sankulgarg.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

class LengthOfLongestSubstring {

	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> prevCharSet = new HashMap<>();
		int maxGLobalLength = 0;
		int maxLocalLength = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!prevCharSet.containsKey(c)) {
				maxLocalLength++;
				maxGLobalLength = Math.max(maxLocalLength, maxGLobalLength);
				prevCharSet.put(c, i);

			} else {
				i = prevCharSet.get(c);
				prevCharSet.clear();
				maxLocalLength = 0;

			}

		}
		return Math.max(maxLocalLength, maxGLobalLength);
	}

	public static void main(String[] args) {
		System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
	}
}
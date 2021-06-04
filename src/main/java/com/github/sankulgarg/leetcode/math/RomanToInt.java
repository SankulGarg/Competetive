package com.github.sankulgarg.leetcode.math;

import java.util.Map;

class RomanToInt {
	public int romanToInt(String s) {
		Character lastChracter = null;
		Map<Character, Integer> valueMap = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			Character curr = s.charAt(i);
			if (lastChracter != null && valueMap.get(lastChracter) < valueMap.get(curr)) {
				sum += valueMap.get(curr) - 2*valueMap.get(lastChracter);
			} else
				sum += valueMap.get(curr);

			lastChracter = curr;
		}

		return sum;

	}

	public static void main(String[] args) {
		System.out.println(new RomanToInt().romanToInt("III"));
	}
}
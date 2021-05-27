package com.github.sankulgarg.leetcode.strings;

class FirstUniqChar {
	public int firstUniqChar(String s) {
		int ind = s.length();
		for (char i = 'a'; i <= 'z'; i++) {
			int idx = s.indexOf(i);
			if (idx != -1 && idx == s.lastIndexOf(i)) {
				ind = Math.min(ind, idx);
			}
		}

		return ind == s.length() ? -1 : ind;
	}

	public static void main(String[] args) {
		FirstUniqChar sol = new FirstUniqChar();
		sol.firstUniqChar("leetcode");
	}
}
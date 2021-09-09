package com.github.sankulgarg.leetcode.sortingAndSearching;

class MinWindow {
	public String minWindow(String s, String t) {
		char[] sch = s.toCharArray();
		char[] tch = t.toCharArray();
		int l = 0, r = -1, tcount = tch.length, min = Integer.MAX_VALUE, minStart = 0;
		int[] needs = new int[128];
		for (char c : tch) {
			needs[c - 'A']++;
		}
		while (r < sch.length - 1) {
			r++;
			char rch = sch[r];
			needs[rch - 'A']--;
			if (needs[rch - 'A'] >= 0) {
				tcount--;
			}
			while (l <= r && tcount == 0) {
				if (r - l + 1 <= min) {
					min = r - l + 1;
					minStart = l;
				}
				min = Math.min(min, r - l + 1);
				char lch = sch[l];
				needs[lch - 'A']++;
				if (needs[lch - 'A'] > 0) {
					tcount++;
				}
				l++;
			}
			// System.out.println("min = " + min + "minStart = " + minStart);
		}
		if (min == Integer.MAX_VALUE)
			return "";
		return s.substring(minStart, minStart + min);
	}
}
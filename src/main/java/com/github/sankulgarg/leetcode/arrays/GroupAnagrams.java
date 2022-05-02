package com.github.sankulgarg.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupAnagrams {
	public static void main(String[] args) {
		new GroupAnagrams()
				.groupAnagrams(new String[]{"sankul","pichu", "lala"});
	}
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0)
			return Collections.emptyList();
		Map<String, List<String>> ans = new HashMap<>();
		int[] count = new int[26];
		for (String s : strs) {
			Arrays.fill(count, 0);
			for (char c : s.toCharArray())
				count[c - 'a']++;

			StringBuilder sb = new StringBuilder("");
			for (int i = 0; i < 26; i++) {
				sb.append('#');
				sb.append(count[i]);
			}
			String key = sb.toString();

			ans.computeIfAbsent(key, k -> new ArrayList<>());
			ans.get(key).add(s);
		}
		return new ArrayList<>(ans.values());
	}
}
package com.github.sankulgarg.leetcode.strings;

import java.util.ArrayList;
import java.util.List;

class PalindromePartitioning {
	boolean dp[][] = null;

	public List<List<String>> partition(String s) {

		dp = new boolean[s.length()][s.length()];
		List<List<String>> results = new ArrayList<>();

		dfs(s, results, new ArrayList<>(), 0);
		return results;
	}

	void dfs(String s, List<List<String>> results, List<String> currList, int start) {

		if (start >= s.length())
			results.add(new ArrayList<>(currList));

		for (int end = start; end < s.length(); end++) {
			if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
				dp[start][end] = true;
				currList.add(s.substring(start, end + 1));
				dfs(s, results, currList, end + 1);
				currList.remove(currList.size() - 1);
			}

		}

	}
	public static void main(String[] args) {
		new PalindromePartitioning().partition("mississipi");
	}

}
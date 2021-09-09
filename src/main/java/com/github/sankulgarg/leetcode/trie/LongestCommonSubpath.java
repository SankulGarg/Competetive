package com.github.sankulgarg.leetcode.trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class LongestCommonSubpath {

	class TrieNode {
		int v;
		int length;
		Map<Integer, TrieNode> branches;

		public TrieNode(int v, int length) {
			this.length = length;
			this.v = v;
		}
	}

	TrieNode root;

	public int longestCommonSubpath(int n, int[][] paths) {
		root = new TrieNode(-1, 0);
		Arrays.sort(paths, (a, b) -> a.length - b.length);
		int[] smallestPath = paths[0];
		int max = smallestPath.length;
		buildSuffixTree(smallestPath);

		for (int k = 1; k < paths.length; k++) {
			int[] path = paths[k];

			int maxPlength = 0;
			for (int i = 0; i < path.length; i++) {
				int length = 0;
				TrieNode curr = root;
				int j = i;
				while (curr != null && j < path.length) {
					curr = search(path[j], curr);
					j++;
					if (curr != null)
						length = curr.length;
				}

				i = j;
				maxPlength = Math.max(length, maxPlength);
				if (maxPlength == max)
					break;
			}
			max = Math.min(max, maxPlength);
		}
		return max;

	}

	private void buildSuffixTree(int[] path) {

		for (int i = 0; i < path.length; i++) {
			TrieNode curr = root;
			for (int j = i; j < path.length; j++) {
				curr = insert(path[j], curr);
			}
		}
	}

	private TrieNode insert(int v, TrieNode curr) {
		if (curr.branches == null)
			curr.branches = new HashMap<>();

		return curr.branches.computeIfAbsent(v, v1 -> new TrieNode(v1, curr.length + 1));

	}

	private TrieNode search(int c, TrieNode curr) {
		if (curr.branches == null || !curr.branches.containsKey(c))
			return null;
		return curr.branches.get(c);
	}

	public static void main(String[] args) {
		new LongestCommonSubpath().longestCommonSubpath(5,
				new int[][] { { 0, 1, 2, 3, 4 }, { 2, 3, 4 }, { 4, 0, 1, 2, 3 } });
	}
}

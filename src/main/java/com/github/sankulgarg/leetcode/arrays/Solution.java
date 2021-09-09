package com.github.sankulgarg.leetcode.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

class Solution {

	class TrieNode {
		int v;
		Map<Integer, TrieNode> branches;

		public TrieNode(int v) {
			this.v = v;
		}
	}

	TrieNode root;

	public int longestCommonSubpath(int n, int[][] paths) {
		root= new TrieNode(-1);
		Optional<int[]> smallestPath = Arrays.stream(paths).reduce((a,b)-> a.length<b.length?a:b);
		buildSuffixTree(smallestPath.get());
		int[] prev = paths[0];

}

	private void buildSuffixTree(int[] path) {
		
		for(int i=0;i<path.length;i++)
			for(int j=i;j<path.length;j++) {
				
			}
	}
	}

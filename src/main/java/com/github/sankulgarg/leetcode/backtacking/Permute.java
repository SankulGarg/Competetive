package com.github.sankulgarg.leetcode.backtacking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Permute {

	boolean[] visited;
	List<List<Integer>> result = null;

	public List<List<Integer>> permute(int[] nums) {
		result = new ArrayList<>();
		visited = new boolean[nums.length];
		addPermutation(new ArrayList<>(), visited, nums);
		return result;

	}

	private void addPermutation(List<Integer> permutation, boolean[] visited, int nums[]) {
		if (permutation.size() == nums.length) {
			result.add(new ArrayList<>(permutation));

		}
		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				permutation.add(nums[i]);
				visited[i] = true;
				addPermutation(permutation, visited, nums);
				visited[i] = false;
				permutation.remove(permutation.size() - 1);
			}
		}

	}
}

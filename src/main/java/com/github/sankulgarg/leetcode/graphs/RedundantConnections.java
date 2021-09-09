package com.github.sankulgarg.leetcode.graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class RedundantConnections {
	public int[] findRedundantConnection(int[][] edges) {
		Map<Integer, Set<Integer>> graph = new HashMap<>();

		for (int i = 0; i < edges.length; i++) {
			int from = edges[i][0];
			int to = edges[i][1];

			Set<Integer> visited = new HashSet<>();
			if (dfs(graph, visited, from, to))
				return new int[] { from, to };

			graph.putIfAbsent(from, new HashSet<>());
			graph.get(from).add(to);
			graph.putIfAbsent(to, new HashSet<>());
			graph.get(to).add(from);

		}
		return new int[2];
	}

	boolean dfs(Map<Integer, Set<Integer>> graph, Set<Integer> visited, int source, int target) {

		if (visited.contains(source))
			return false;
		visited.add(source);

		if (source == target)
			return true;
		if (graph.get(source) != null)
			for (Integer neighbour : graph.get(source)) {
				if (dfs(graph, visited, neighbour, target))
					return true;
			}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(
				new RedundantConnections().findRedundantConnection(new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } })));
	}
}
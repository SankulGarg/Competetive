package com.github.sankulgarg.leetcode.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class CalcEquation {

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

		Map<String, Map<String, Double>> graph = new HashMap<>();
		for (int i = 0; i < equations.size(); i++) {
			String from = equations.get(i).get(0);
			String to = equations.get(i).get(1);
			graph.computeIfAbsent(from,a->new HashMap<>());
            graph.computeIfAbsent(to,a->new HashMap<>());
            graph.get(from).put(to,values[i]);
            graph.get(to).put(from,1/values[i]);
		}
		double[] sol = new double[queries.size()];
		int i = 0;
		for (List<String> query : queries) {
			sol[i] = dfs(query.get(0), query.get(1), graph, new HashSet<>());
			i++;
		}
		return sol;

	}

	double dfs(String numerator, String denominator, Map<String, Map<String, Double>> graph, Set<String> visited) {

		if (!graph.containsKey(numerator))
			return -1.0;

		if (graph.get(numerator).containsKey(denominator))
			return graph.get(numerator).get(denominator);

		visited.add(numerator);

		for (Map.Entry<String, Double> conn : graph.get(numerator).entrySet()) {
			if (!visited.contains(conn.getKey())) {
				double weight = dfs(conn.getKey(), denominator, graph, visited);
				if (weight != -1.0)
					return conn.getValue() * weight;
			}
		}
		return -1.0;

	}

}
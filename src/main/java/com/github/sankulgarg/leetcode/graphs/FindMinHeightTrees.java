package com.github.sankulgarg.leetcode.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class FindMinHeightTrees {
     public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n < 2) {
            return Collections.singletonList(0);
        }
        
        Map<Integer, Set<Integer>> tree = buildGraph(edges);
        
        while (tree.size() > 2) {
            Set<Integer> leaves = getLeaves(tree);
            
            removeLeaves(tree, leaves);
        }
        
        return new ArrayList<>(tree.keySet());
    }
    
    private void removeLeaves(Map<Integer, Set<Integer>> graph, Set<Integer> leaves) {
        for (int leaf : leaves) {
            int connection = graph.get(leaf)
                .stream()
                .findFirst()
                .orElseThrow(IllegalStateException::new);
            
            graph.get(connection).remove(leaf);
            graph.remove(leaf);
        }
    }
    
    private Set<Integer> getLeaves(Map<Integer, Set<Integer>> graph) {
        return graph.entrySet()
            .stream()
            .filter(entry -> entry.getValue().size() == 1)
            .map(entry -> entry.getKey())
            .collect(Collectors.toSet());
    }
    
    private Map<Integer, Set<Integer>> buildGraph(int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            
            if (!graph.containsKey(from)) {
                graph.put(from, new HashSet<>());
            }
            
            if (!graph.containsKey(to)) {
                graph.put(to, new HashSet<>());
            }
            
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        
        return graph;
    }
}
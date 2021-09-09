package com.github.sankulgarg.leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// Definition for a Node.
class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}

class CloneGraph {
	public Node cloneGraph(Node node) {
		Node newRoot = null;
		Node curr = node;

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(curr);
		Map<Node, Node> mappingTable = new HashMap<>();
		while (!queue.isEmpty()) {
			curr = queue.poll();
			if (curr == null || mappingTable.containsKey(curr))
				continue;
			Node copy = new Node(curr.val);
			copy.neighbors = curr.neighbors;
			if (newRoot == null)
				newRoot = copy;
			if (curr.neighbors != null)
				for (Node child : curr.neighbors)
					queue.add(child);
			mappingTable.put(curr, copy);
		}

		queue.add(node);
		Set<Node> visited = new HashSet<>();
		while (!queue.isEmpty()) {
			curr = queue.poll();
			if (curr == null || visited.contains(curr))
				continue;
			if (curr.neighbors != null) {
				List<Node> newNeighbors = new ArrayList<>();
				for (Node child : curr.neighbors) {
					newNeighbors.add(mappingTable.get(child));
					queue.add(child);
				}
				mappingTable.get(curr).neighbors = newNeighbors;

			}
			visited.add(curr);

		}
		return newRoot;

	}
}
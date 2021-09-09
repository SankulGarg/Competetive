package com.github.sankulgarg.amazon;

import java.util.ArrayList;
import java.util.List;

class LowestCommonAncestor {
	class Node {
		Node left, right;
		int data;

		Node(int d) {
			data = d;
			left = right = null;
		}

	}

	boolean findPathToANode(Node curr, Node n, List<Integer> path) {

		if (curr == null)
			return false;
		if (curr == n)
			return true;

		path.add(curr.data);
		if (curr.left != null && findPathToANode(curr.left, n, path))
			return true;
		if (curr.right != null && findPathToANode(curr.right, n, path))
			return true;

		// fail case not in path
		path.remove(path.size() - 1);
		return false;
	}

	// Function to convert binary tree to doubly linked list and return it.
	int lowestCommonAncestor(Node root, Node n1, Node n2) {

		List<Integer> path1 = new ArrayList<>();
		List<Integer> path2 = new ArrayList<>();

		findPathToANode(root, n2, path1);
		findPathToANode(root, n2, path2);

		int i = 0;
		for (i = 0; i < path1.size() && i < path2.size(); i++) {
			if (path1.get(i) != path2.get(i))
				break;
		}

		return path1.get(i - 1);
	}
}
package com.github.sankulgarg.leetcode.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
};

class Connect {
	public Node connect(Node root) {
		if (root == null)
			return root;
		Queue<Node> queue = new LinkedList<>();
		List<List<Node>> bfs = new ArrayList<>();
		queue.add(root);

		while (!queue.isEmpty()) {

			int levelSize = queue.size();

			LinkedList<Node> level = new LinkedList<>();
			for (int i = 0; i < levelSize; i++) {
				Node node = queue.poll();
				level.add(node);
				if (node.left != null)
					queue.add(node.left);

				if (node.right != null)
					queue.add(node.right);
			}
			bfs.add(level);

		}

		for (List<Node> level : bfs) {

			for (int i = 0; i < level.size() - 1; i++) {
				level.get(i).next = level.get(i + 1);

			}

		}
		return root;

	}

	public static void main(String[] args) {
		new Connect().connect(new Node(1, new Node(2, new Node(4), new Node(5), null),
				new Node(3, new Node(6), new Node(7), null), null));
	}
}
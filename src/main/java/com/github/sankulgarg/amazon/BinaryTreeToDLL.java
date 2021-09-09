package com.github.sankulgarg.amazon;

import java.util.LinkedList;

class BinaryTreeToDLL {
	class Node {
		Node left, right;
		int data;

		Node(int d) {
			data = d;
			left = right = null;
		}

	}

	// Function to convert binary tree to doubly linked list and return it.
	Node bToDLL(Node root) {

		LinkedList<Node> queue = new LinkedList<>();
		Node sol = null;
		Node solCurr = null;
		Node curr = root;

		while (!queue.isEmpty() || curr != null) {

			while (curr != null) {
				queue.push(curr);
				curr = curr.left;
			}
			curr = queue.poll();
			if (sol == null) {
				sol = curr;
				solCurr = curr;
			} else {
				curr.left = solCurr;
				solCurr.right = curr;
				solCurr = curr;
			}
			curr = curr.right;

		}
		return sol;

	}
}
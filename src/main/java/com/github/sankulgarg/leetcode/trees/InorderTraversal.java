package com.github.sankulgarg.leetcode.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class InorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();

		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode curr = root;

		while (curr != null || !stack.isEmpty()) {

			while (curr != null) {
				stack.addFirst(curr);
				curr = curr.left;

			}

			curr = stack.pop();
			list.add(curr.val);
			curr = curr.right;

		}
		return list;

	}
}
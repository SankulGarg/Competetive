package com.github.sankulgarg.leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class KthSmallest {
	public int kthSmallest(TreeNode root, int k) {

		
		LinkedList<TreeNode> stack = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		TreeNode curr = root;

		while (!stack.isEmpty() || curr != null) {

			while (curr != null) {
				stack.addFirst(curr);
				curr = curr.left;

			}

			curr = stack.pop();
			list.add(curr.val);
			curr = curr.right;

		}

		return list.get(k);

	}

	public static void main(String[] args) {
		new KthSmallest().kthSmallest(new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4)), 1);
	}
}
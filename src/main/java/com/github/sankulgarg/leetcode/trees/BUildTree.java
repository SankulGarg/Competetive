package com.github.sankulgarg.leetcode.trees;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class BUildTree {
	int preorderIndex;
	Map<Integer, Integer> inorderIndexMap;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		preorderIndex = 0;
		// build a hashmap to store value -> its index relations
		inorderIndexMap =IntStream.range(0, inorder.length).boxed().collect(Collectors.toMap(x -> inorder[x], x -> x));

		return arrayToTree(preorder, 0, preorder.length - 1);
	}

	private TreeNode arrayToTree(int[] preorder, int left, int right) {
		// if there are no elements to construct the tree
		if (left > right)
			return null;

		// select the preorder_index element as the root and increment it
		int rootValue = preorder[preorderIndex++];
		TreeNode root = new TreeNode(rootValue);

		// build left and right subtree
		// excluding inorderIndexMap[rootValue] element because it's the root
		root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
		root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
		return root;
	}

	public static void main(String[] args) {
		new BUildTree().buildTree(new int[] { 1, 2, 3 }, new int[] { 3, 2, 1 });
	}
}
package com.github.sankulgarg.leetcode.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

	private void searilzeTree(TreeNode node, StringBuilder searilize) {
		if (node == null)
			searilize.append("#").append(":");

		else {
			searilize.append(node.val).append(":");
			searilzeTree(node.left, searilize);
			searilzeTree(node.right, searilize);
		}
	}

	private TreeNode buildTree(Queue<String> serialized) {
		String val = serialized.poll();
		if (val.equals("#"))
			return null;

		else {
			TreeNode node = new TreeNode(Integer.valueOf(val));
			node.left = buildTree(serialized);
			node.right = buildTree(serialized);
			return node;
		}
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder serializeString = new StringBuilder();

		searilzeTree(root, serializeString);
		return serializeString.toString().substring(0, serializeString.length() - 1);

	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		Queue<String> q = new LinkedList<>(Arrays.asList(data.split(":")));

		return buildTree(q);

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		Codec codec = new Codec();
		String serialize = codec.serialize(root);
		codec.deserialize(serialize);
	}
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
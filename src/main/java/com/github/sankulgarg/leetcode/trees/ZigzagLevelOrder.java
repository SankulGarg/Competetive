
package com.github.sankulgarg.leetcode.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ZigzagLevelOrder {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
			if (root == null)
				return Collections.emptyList();

		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int levelNumber = 0;

		while (!queue.isEmpty()) {
			levelNumber++;
			int levelSize = queue.size();

			LinkedList<Integer> level = new LinkedList<>();

			for (int i = 0; i < levelSize; i++) {
				TreeNode node = queue.poll();
				if (levelNumber % 2 == 0)
					level.addFirst(node.val);
				else {
					level.add(node.val);
				}

				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			result.add(level);

		}
		return result;
	}
	
}


package com.github.sankulgarg.leetcode.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ZigzagLevelOrder_Recursion {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null)
			return Collections.emptyList();

		Map<Integer, List<Integer>> levelMap = new HashMap<>();
		levelOrder(root, 0, levelMap, true);

		List<List<Integer>> zigzagLevelList = new ArrayList<>();
		boolean isRev = false;
		for (List<Integer> level : levelMap.values()) {

			if (isRev) {
				Collections.reverse(level);

			}

			zigzagLevelList.add(level);

			isRev = !isRev;
		}
		return new ArrayList<>(levelMap.values());
	}

	private void levelOrder(TreeNode node, int level, Map<Integer, List<Integer>> levelMap, boolean leftToRIght) {
		if (node == null)
			return;

		List<Integer> levelList = levelMap.computeIfAbsent(level, l -> new ArrayList<>());

		levelList.add(node.val);

		levelOrder(node.left, level + 1, levelMap, !leftToRIght);
		levelOrder(node.right, level + 1, levelMap, !leftToRIght);

	}

}

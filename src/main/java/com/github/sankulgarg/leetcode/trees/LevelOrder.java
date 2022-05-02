package com.github.sankulgarg.leetcode.trees;

import java.util.*;

class LevelOrder {

    private void levelOrder(TreeNode node, Integer level, Map<Integer, List<Integer>> levelMap) {
        if (node == null)
            return;

        List<Integer> levelList = levelMap.computeIfAbsent(level, l -> new ArrayList<>());

        levelList.add(node.val);
        levelOrder(node.left, level + 1, levelMap);
        levelOrder(node.right, level + 1, levelMap);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        levelOrder(root, 0, levelMap);
        return new ArrayList<>(levelMap.values());


    }

}
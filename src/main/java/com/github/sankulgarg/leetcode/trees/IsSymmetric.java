package com.github.sankulgarg.leetcode.trees;

class IsSymmetric {

	private boolean isSymm(TreeNode node1, TreeNode node2) {

		if (node1 == null && node2 == null)
			return true;

		if (node1!=null && node2!=null&& node1.val == node2.val)
			return isSymm(node1.left, node2.right) && isSymm(node1.right,node2.left);

		return false;
	}

	public boolean isSymmetric(TreeNode root) {
		
		return isSymm(root, root);
	}

	
}
package com.github.sankulgarg.leetcode.trees;

class IsValidBST_Recursion {

	private boolean isValidBST(TreeNode n, Integer lower, Integer upper) {

		if (n == null)
			return true;

		if ((lower != null && lower >= +n.val) ||
				( upper != null && upper <= n.val))
			return false;

		return isValidBST(n.left, lower, n.val) && isValidBST(n.right, n.val, upper);

	}

	public boolean isValidBST(TreeNode root) {

		if (root.left == null && root.right == null) {
			return true;
		}
		return isValidBST(root, null, null);
	}

	public static void main(String[] args) {
		System.out.println(new IsValidBST_Recursion().isValidBST(new TreeNode(2, null, new TreeNode(2))));
	}
}
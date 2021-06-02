package com.github.sankulgarg.leetcode.trees;

class SortedArrayToBST {

	private TreeNode sortedArrayToBST(int nums[], int start, int end) {
		if (start > end)
			return null;

		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = sortedArrayToBST(nums, start, mid - 1);
		node.right = sortedArrayToBST(nums, mid + 1, end);
		return node;
	}

	public TreeNode sortedArrayToBST(int[] nums) {

		int length = nums.length;

		return sortedArrayToBST(nums, 0, length - 1);

	}
}
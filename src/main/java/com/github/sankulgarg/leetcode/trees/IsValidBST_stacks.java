package com.github.sankulgarg.leetcode.trees;

import java.util.LinkedList;

class IsValidBST_stacks {
	public boolean isValidBST(TreeNode root) {
		
		
		
		LinkedList<TreeNode> stack = new LinkedList<>();
		
		TreeNode curr=root;
		int prev=Integer.MIN_VALUE;
		while (curr!=null || !stack.isEmpty()) {
			
		while(curr!=null) {
			stack.push(curr);
		curr=curr.left;
		}
		
		curr=stack.pop();
		if(prev>=curr.val)
			return false;
		else
			prev=curr.val;
		curr=curr.right;
		}
		return true;

	}
	public static void main(String[] args) {
		System.out.println(new IsValidBST_stacks().isValidBST(new TreeNode(2, new TreeNode(2), new TreeNode(2))));
	}
}
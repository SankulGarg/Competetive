package com.github.sankulgarg.amazon;

//  Definition for binary tree
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
}

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class MaxSubPathSum {

	int max=Integer.MIN_VALUE;
	private int maxSubPathSum(TreeNode curr) {

		if (curr == null)
			return 0;

		
		int l = Math.max(maxSubPathSum(curr.left), 0);
		int r = Math.max(maxSubPathSum(curr.right), 0);
		 
		max= Math.max(max, curr.val+l+r);
		return curr.val+ Math.max(Math.max(l,r),l+r);

	}

    public int maxPathSum(TreeNode A) {
        return maxSubPathSum(A);



    }


	
	public static void main(String[] args) {
		TreeNode root=new TreeNode(-100);
		root.left=new TreeNode(-200);
		root.left.left=new TreeNode(-300);
		root.left.right=new TreeNode(-400);
		System.out.println(new MaxSubPathSum().maxPathSum(root));
	}
}

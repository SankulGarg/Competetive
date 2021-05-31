package com.github.sankulgarg.leetcode.trees;
class MaxDepth_Recursion {
    
    private int maxDepth(int dep,TreeNode node){
        
        if(node== null)
            return dep;
        
        int depL=maxDepth(dep+1,node.left);
        int depR=maxDepth(dep+1,node.right);

        return Math.max(depL,depR);
        }
    public int maxDepth(TreeNode root) {
        return maxDepth(0,root);
    }
}
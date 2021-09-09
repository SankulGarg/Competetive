package com.github.sankulgarg.leetcode.sortingAndSearching;

import java.util.Arrays;
import java.util.Stack;

class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        
        
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        
        Stack<int[]> stack= new Stack<>();
        
        
        stack.push(intervals[0]);
        for(int[] interval:intervals){
            
            int top[]=stack.peek();
            
            if(interval[0]>top[1])
                stack.push(interval);
            else{
                top[1]=Math.max(top[1],interval[1]);
                stack.pop();
                stack.push(top);
            }
                
        }
        
        return stack.toArray(new int[stack.size()][2]);
        
        
        
    }
}
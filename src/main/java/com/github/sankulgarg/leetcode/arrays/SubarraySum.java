package com.github.sankulgarg.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        
        int currSum=0;
        Map<Integer,Integer> sumCounter=new HashMap<>();
        int count = 0;
        sumCounter.put(0,1);
        
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            
        if(sumCounter.containsKey(currSum-k))
             count += sumCounter.get(currSum - k);
         sumCounter.put(currSum, sumCounter.getOrDefault(currSum, 0) + 1);
        }
        return count;
    }
    /*
    10,2,-2,-20,10
    */
    public static void main(String[] args) {
		new SubarraySum().subarraySum(new int[] {10,2,-2,-20,10}, -10);
	}
}
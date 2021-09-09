package com.github.sankulgarg.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

class Solution {
	Map<Integer,Integer> map= new HashMap<>();
    public int combinationSum4(int[] nums, int target) {
    	if (target < 0) {
			return 0;
		}
		if(map.containsKey(target)) {
			return map.get(target);
		}
		if (target == 0) {
			return 1;        
		}
		int count=0;
		for (int n : nums) {
			int remainder = target - n;
			
			count+=combinationSum4( nums,remainder);
			
		}
		map.put(target,count);
		return count;
		
	}
}
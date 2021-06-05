package com.github.sankulgarg.leetcode.arrays;

class IncreasingTriplet {
	public boolean increasingTriplet(int[] nums) {
		Integer min1 = Integer.MAX_VALUE;
		Integer min2 = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {

			if (min1 >= nums[i])
				min1=nums[i];
			else if(min2>nums[i])
				min2=nums[i];
			else if(nums[i]>min2)
				return true;
			
		
		}

		return false;
	}

	public static void main(String[] args) {
		new IncreasingTriplet().increasingTriplet(new int[] { 1, 1, -2, 6 });
	}
}
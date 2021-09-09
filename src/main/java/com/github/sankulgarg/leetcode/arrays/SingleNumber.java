package com.github.sankulgarg.leetcode.arrays;

import java.util.Arrays;

class SingleNumber {
	public int singleNumber(int[] nums) {
		Arrays.sort(nums);
		int i=0;
		for (i = 1; i < nums.length; i+=2) {
			if (nums[i] != nums[i - 1]) {
				if (i - 2 >= 0 && nums[i - 2] == nums[i - 1])
					return nums[i];
				else
					return nums[i - 1];
			}
		}
		
		if(nums[nums.length-1]!=nums[nums.length-2])
			return nums[nums.length-1];
		return 0;
	}
public static void main(String[] args) {
	SingleNumber sol=new SingleNumber();
	System.out.println(sol.singleNumber(new int[] {4,1,2,1,2}));
}

}
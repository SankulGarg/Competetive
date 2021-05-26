package com.github.sankulgarg.leetcode.arrays;


class RemoveDuplicateFromSortedArray {
	public int removeDuplicates(int[] nums) {

		int prev = 0;
		int atIndex = 1;
		if (nums.length == 2 && nums[0] == nums[1])
			return 1;

		for (int i = 1; i < nums.length; i++) {
			
		
			if (nums[prev] == nums[i]) {

				int maxIndex = getMaxIndexOfCurrValue(i, nums);
				
				nums[atIndex] = nums[maxIndex];
	
				i = maxIndex ;
				prev = maxIndex ;

			} else
				prev = i;

				atIndex++;
			
		}

		return getMaxUniqueIndex(nums);
	}

	private int getMaxUniqueIndex(int[] nums) {

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] <= nums[i - 1])
				return i;
		}
		return nums.length;
	}

	private int getMaxIndexOfCurrValue(int i, int[] nums) {

		int num = nums[i];
		for (int k = i + 1; k < nums.length; k++) {
			if (nums[k] != num)
				return k;
		}
		return i;
	}

	public static void main(String[] args) {
		RemoveDuplicateFromSortedArray sol = new RemoveDuplicateFromSortedArray();

		System.out.println(sol.removeDuplicates(new int[] {1,1,2,3}));
	}
}
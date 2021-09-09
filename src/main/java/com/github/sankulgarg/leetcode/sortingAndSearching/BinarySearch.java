package com.github.sankulgarg.leetcode.sortingAndSearching;

class BinarySearch {

	private int[] binarySearch(int[] nums, int target, int left, int right) {
		if (right > left) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == target) {
				if (mid - 1 >= 0 && nums[mid - 1] == target)
					return new int[] { mid - 1, mid };
				else if (mid + 1 < nums.length && nums[mid + 1] == target)
					return new int[] { mid, mid + 1 };
				else
					return new int[] { mid, mid + 1 };
			} else if (nums[mid] > target)
				return binarySearch(nums, target, left, mid - 1);
			else
				return binarySearch(nums, target, mid + 1, right);
		}
		return new int[] { -1, -1 };
	}

	public int[] searchRange(int[] nums, int target) {

		return binarySearch(nums, target, 0, nums.length - 1);

	}
}
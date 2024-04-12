package com.github.sankulgarg.leetcode.arrays;


import java.util.Arrays;

class RemoveDuplicateFromSortedArray2 {
    public int removeDuplicates(int[] nums) {

        int start = 0;
        int end = 1;
        int startNumFreq = 1;
        if (nums.length < 2)
            return 1;
		//mark
        while (end < nums.length) {
            if (nums[start] == nums[end]) {
                //collison
                startNumFreq++;
                if (startNumFreq > 2){
					end = markArray(nums, end) -1;
					start = end -1;

				}

            } else
                startNumFreq = 1;
            end++;
            start++;

        }


	//Swap
        start = 0;
        end = 1;
        while (end < nums.length) {
            if (nums[start] == Integer.MIN_VALUE) {
                //find end with correct val
                while (end < nums.length) {
                    if (nums[end] != Integer.MIN_VALUE)
                        break;
                    end++;
                }
                if (end < nums.length) {
                    //swap
                    nums[start] = nums[end];
                    nums[end] = Integer.MIN_VALUE;
                }
            }
            start++;
            end++;
        }

        //get correct array index
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == Integer.MIN_VALUE)
                return i;

        return nums.length;
    }
	private int markArray(int[] nums, int end) {
		int repeatedNum= nums[end];
		for(int i = end; i < nums.length; i++) {
			if (nums[i] == repeatedNum)
				nums[i] = Integer.MIN_VALUE;
			else return i;
		}
		return nums.length;
	}
    public static void main(String[] args) {
        RemoveDuplicateFromSortedArray2 r = new RemoveDuplicateFromSortedArray2();
        int[] arr = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(r.removeDuplicates(arr));
        Arrays.stream(arr).sequential().forEach(a -> System.out.print(a + " , "));
    }
}
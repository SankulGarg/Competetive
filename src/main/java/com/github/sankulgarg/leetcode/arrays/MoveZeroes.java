package com.github.sankulgarg.leetcode.arrays;
class MoveZeroes {
    public void moveZeroes(int[] nums) {
        
    	
    	for (int i=0;i<nums.length;i++) {
    		
    		if(nums[i]==0)
    		{
    			int ind=findNextNonZero(nums,i+1);
    			if(ind>-1)
    			{
    				
    				nums[i]=nums[ind];
    				nums[ind]=0;
    			}
    		}
    	}
    }

	private int findNextNonZero(int[] nums, int k) {
		for (int i=k;i<nums.length;i++) {
			if(nums[i]!=0)
				return i;
		}
		return -1;
    		
	}
    
	public static void main(String[] args) {
		MoveZeroes mov=new MoveZeroes();
		mov.moveZeroes(new int[] {0,1,0,3,12});
	}
    
}